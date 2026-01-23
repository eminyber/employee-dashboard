import { ref } from "vue";
import { fetchJobTitles as fetchJobTitlesRequest } from "../api/jobtitles";

export function useFetchJobTitles() {
  const jobTitles = ref([]);
  const loading = ref(true);
  const error = ref(null);

  const fetchJobTitles = async () => {
    loading.value = true;
    error.value = null;

    try {
      jobTitles.value = await fetchJobTitlesRequest();
    } catch (err) {
      error.value = err;
    } finally {
      loading.value = false;
    }
  };

  return { jobTitles, loading, error, fetchJobTitles };
}
