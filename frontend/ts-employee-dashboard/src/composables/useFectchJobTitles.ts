import { ref, type Ref } from "vue";
import { fetchJobTitles as fetchJobTitlesRequest } from "../api/jobTitles";
import type { Jobtitle } from "../models/JobTitle";

export function useFetchJobTitles() {
  const jobTitles: Ref<Jobtitle[] | null> = ref(null);
  const loading = ref<boolean>(true);
  const error = ref<unknown | null>(null);

  const fetchJobTitles = async (): Promise<void> => {
    loading.value = true;
    error.value = null;

    try {
      jobTitles.value = await fetchJobTitlesRequest();
    } catch (err: unknown) {
      error.value = err;
    } finally {
      loading.value = false;
    }
  };

  return {
    jobTitles,
    loading,
    error,
    fetchJobTitles,
  };
}
