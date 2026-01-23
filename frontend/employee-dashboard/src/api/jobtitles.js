import apiClient from "./apiClient";

export const fetchJobTitles = async () => {
  try {
    const response = await apiClient.get("/job-titles");
    return response.data;
  } catch (error) {
    console.error("Error fetching job titles:", error);
    throw error;
  }
};
