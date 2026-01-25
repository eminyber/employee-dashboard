import { ref, type Ref } from "vue";
import { fetchHiresAGivenYear as fetchHiresAGivenYearRequest } from "../api/statistics";
import type { MonthlyHires } from "../models/MontlyHires";

export function useFetchHiresAGivenYear() {
  const hireData: Ref<MonthlyHires[] | null> = ref(null);
  const loading = ref<boolean>(true);
  const error = ref<unknown | null>(null);

  const fetchHiresAGivenYear = async (year: number): Promise<void> => {
    loading.value = true;
    error.value = null;

    try {
      hireData.value = await fetchHiresAGivenYearRequest(year);
    } catch (err: unknown) {
      error.value = err;
    } finally {
      loading.value = false;
    }
  };

  return { hireData, loading, error, fetchHiresAGivenYear };
}
