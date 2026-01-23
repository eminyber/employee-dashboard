import { ref } from "vue";
import { fetchEmployees as fetchEmployeesRequest } from "../api/employees";

export function useFetchEmployees() {
  const employees = ref([]);
  const loading = ref(true);
  const error = ref(null);

  const fetchEmployees = async (
    size = "",
    page = "",
    searchWords = "",
    sortDirection = "",
    sortBy = "",
    jobTitleIds = "",
    startDate = "",
    endDate = "",
  ) => {
    loading.value = true;
    error.value = null;

    try {
      employees.value = await fetchEmployeesRequest(
        size,
        page,
        searchWords,
        sortDirection,
        sortBy,
        jobTitleIds,
        startDate,
        endDate,
      );
    } catch (err) {
      error.value = err;
    } finally {
      loading.value = false;
    }
  };

  return { employees, loading, error, fetchEmployees };
}
