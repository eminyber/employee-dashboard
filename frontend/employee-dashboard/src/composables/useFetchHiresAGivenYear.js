import { ref } from "vue";
import { fetchHiresAGivenYear as fetchHiresAGivenYearRequest } from "../api/statistics";

export function useFetchHiresAGivenYear() {
  const hireData = ref([]);
  const loading = ref(true);
  const error = ref(null);

  const fetchHiresAGivenYear = async (year = "") => {
    loading.value = true;
    error.value = null;

    try {
      hireData.value = await fetchHiresAGivenYearRequest(year);
    } catch (err) {
      error.value = err;
    } finally {
      loading.value = false;
    }
  };

  return { hireData, loading, error, fetchHiresAGivenYear };
}
