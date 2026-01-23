<script setup>
import { ref, reactive, onMounted, watch } from "vue";
import { debounce } from "lodash";

import { useFetchEmployees } from "../composables/useFetchEmployees";
import EmployeeTable from "../components/EmployeeTable.vue";
import SearchBar from "../components/SearchBar.vue";
import FilterByJobTitleDropDown from "../components/FilterByJobTitleDropDown.vue";
import SortOrderDropDown from "../components/SortOrderDropDown.vue";
import Paginator from "../components/Paginator.vue";

//page traversing information
const pageInfo = reactive({
  size: 20,
  page: 1,
});

const filters = reactive({
  searchWords: "",
  sortingOrder: "asc",
  sortBy: "id",
  jobTitleIds: "",
  startDate: "",
  endDate: "",
});

//A separate value must be used for handling displayment of the current page size
//since binding it directly with the size parameter made it oupdate on each stroke
//Debounce could probably fix this
const displayedPageSize = ref(pageInfo.size);

const { employees, loading, error, fetchEmployees } = useFetchEmployees();

const fetchEmployeesData = () => {
  fetchEmployees(
    pageInfo.size,
    pageInfo.page,
    filters.searchWords,
    filters.sortingOrder,
    filters.sortBy,
    filters.jobTitleIds,
    filters.startDate,
    filters.endDate,
  );
};

watch(
  () => ({ ...filters }),
  () => {
    pageInfo.page = 1;
    fetchEmployeesData();
  },
  { deep: true },
);

watch(
  () => [pageInfo.size, pageInfo.page],
  () => {
    fetchEmployeesData();
  },
);

const handleSortFieldChange = (newSortField) => {
  filters.sortBy = newSortField;
};

const handleSearch = debounce((search) => {
  filters.searchWords = search
    .split(" ")
    .map((s) => s.trim())
    .filter(Boolean)
    .join(",");
}, 300);

const handleJobTitleFilterChange = (appliedFilters) => {
  filters.jobTitleIds = appliedFilters.join(",");
};

const handleSortOrderChange = (newSortOrder) => {
  filters.sortingOrder = newSortOrder;
};

const handleUpdatePageSize = (newPageSize) => {
  pageInfo.size = Math.max(0, newPageSize);
  pageInfo.page = 1;
};

const handlePageChange = (newPage) => {
  pageInfo.page = newPage;
};

onMounted(fetchEmployeesData);
</script>

<template>
  <div
    class="mx-6 my-4 bg-gray-100 rounded-lg p-6 shadow min-h-30 flex items-center gap-4"
  >
    <SearchBar @search="handleSearch" />

    <div class="flex ml-auto gap-4 items-end">
      <h2 class="pb-2.5">Filter Employees Between:</h2>
      <div class="flex flex-col">
        <label for="fromDate" class="text-sm font-medium mb-1"
          >From Date:</label
        >
        <input
          id="fromDate"
          v-model="filters.startDate"
          type="date"
          class="input"
        />
      </div>
      <div class="flex flex-col">
        <label for="toDate" class="text-sm font-medium mb-1">To Date:</label>
        <input
          id="toDate"
          v-model="filters.endDate"
          type="date"
          class="input"
        />
      </div>
      <FilterByJobTitleDropDown @filter="handleJobTitleFilterChange" />
      <SortOrderDropDown
        @sortOrderChanged="handleSortOrderChange"
        class="mr-10"
      />
    </div>
  </div>

  <!--Show A Loading status div-->
  <div
    v-if="loading && !error"
    class="mx-6 my-4 bg-gray-100 rounded-lg p-6 shadow min-h-80 grid place-items-center"
  >
    <h1 class="text-xl font-medium">Loading...</h1>
  </div>

  <!--Show simple div on error. Change to toast if time permits it-->
  <div
    v-else-if="error && !loading"
    class="mx-6 my-4 bg-gray-100 rounded-lg p-6 shadow min-h-80 grid place-items-center"
  >
    <h1 class="text-xl font-medium text-red-800">{{ error }}</h1>
  </div>

  <!--Show An empty div if no employees were found-->
  <div
    v-else-if="!loading && employees.data.length === 0"
    class="mx-6 my-4 bg-gray-100 rounded-lg p-6 shadow min-h-80 grid place-items-center"
  >
    <h1 class="text-3xl font-bold">No Employees Found...</h1>
  </div>

  <div
    v-else
    class="mx-6 my-6 bg-gray-100 rounded-lg p-6 shadow overflow-auto grid"
  >
    <EmployeeTable
      :employees="employees.data"
      @sortBy="handleSortFieldChange"
    />

    <div class="mt-3 ml-4 flex items-center gap-4 flex-wrap">
      <Paginator
        :pageDetails="{
          currentPage: employees.currentPage,
          totalPages: employees.totalPages,
        }"
        @pageChange="handlePageChange"
      />
      <div class="flex gap-3">
        <div>
          <p1 class="font-bold">Current Page: </p1>
          <p1>{{ pageInfo.page }}</p1>
        </div>
        <div>
          <p1 class="font-bold">Total Pages: </p1>
          <p1>{{ employees.totalPages }}</p1>
        </div>
      </div>

      <div class="flex items-center gap-2 ml-auto mr-3">
        <label for="pageSizeField" class="font-medium whitespace-nowrap"
          >Set Page Size:</label
        >
        <input
          id="pageSizeField"
          type="number"
          min="0"
          v-model="displayedPageSize"
          class="border rounded px-2 py-1 w-20"
        />
        <div
          tabindex="0"
          role="button"
          class="btn input flex items-center justify-center cursor-pointer"
          @click="handleUpdatePageSize(displayedPageSize)"
        >
          Update Page Size
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
