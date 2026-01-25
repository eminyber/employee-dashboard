import { ref, type Ref } from "vue";
import { fetchEmployees as fetchEmployeesRequest } from "../api/employee";
import type { PaginatedResponse } from "../models/PaginatedResponse";

export function useFetchEmployees() {
  const employees: Ref<PaginatedResponse | null> = ref(null);
  const loading = ref<boolean>(true);
  const error = ref<unknown | null>(null);

  const fetchEmployees = async (
    size: string = "",
    page: string = "",
    searchWords: string = "",
    sortDirection: string = "",
    sortBy: string = "",
    jobTitleIds: string = "",
    startDate: string = "",
    endDate: string = "",
  ): Promise<void> => {
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
    } catch (err: unknown) {
      error.value = err;
    } finally {
      loading.value = false;
    }
  };

  return { employees, loading, error, fetchEmployees };
}
