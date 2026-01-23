<script setup>
import { defineEmits, onMounted } from "vue";
import { useFetchJobTitles } from "../composables/useFetchJobTitles";

//Should probably move this fetch call to the parent component and pass down the data instead to
//make it reusable. However, not necessary now
const { jobTitles, loading, error, fetchJobTitles } = useFetchJobTitles();

const emit = defineEmits(["filter"]);

const appliedFilters = [];

const filter = (e) => {
  if (appliedFilters.includes(e.target.value)) {
    appliedFilters.splice(appliedFilters.indexOf(e.target.value), 1);
  } else {
    appliedFilters.push(e.target.value);
  }

  emit("filter", appliedFilters);
};

onMounted(fetchJobTitles);
</script>

<template>
  <div class="dropdown dropdown-hover">
    <div
      tabindex="0"
      role="button"
      class="btn input flex items-center justify-center"
    >
      Filter By JobTitles
    </div>
    <ul
      v-if="jobTitles.length > 0 && !error && !loading"
      class="dropdown-content menu bg-base-100 rounded-box z-1 w-52 p-2 space-y-2 shadow-sm"
    >
      <li v-for="jobTitle in jobTitles">
        <label class="flex items-center gap-2 cursor-pointer">
          <input
            @change="filter"
            type="checkbox"
            :value="jobTitle.id"
            class="checkbox checkbox-sm"
          />
          <span class="text-sm font-medium">{{ jobTitle.title }}</span>
        </label>
      </li>
    </ul>
  </div>
</template>

<style scoped></style>
