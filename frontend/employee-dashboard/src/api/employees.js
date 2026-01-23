import apiClient from "./apiClient";

export const fetchEmployees = async (
  size = "",
  page = "",
  searchWords = "",
  sortDirection = "",
  sortBy = "",
  jobTitleIds = "",
  startDate = "",
  endDate = "",
) => {
  try {
    const response = await apiClient.get("/employees", {
      params: {
        size,
        page,
        searchWords,
        sortDirection,
        sortBy,
        jobTitleIds,
        startDate,
        endDate,
      },
    });
    return response.data;
  } catch (error) {
    console.error("Error fetching employees:", error);
    throw error;
  }
};
