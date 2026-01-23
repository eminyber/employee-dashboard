import apiClient from "./apiClient";

export const fetchHiresAGivenYear = async (year = "") => {
  try {
    const response = await apiClient.get("employees/analytics/hires-for-year", {
      params: { year },
    });
    return response.data;
  } catch (error) {
    console.error("Error fetching number of hired employees:", error);
    throw error;
  }
};
