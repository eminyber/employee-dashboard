import apiClient from "./apiClient";
import type { PaginatedResponse } from "../models/PaginatedResponse";

export const fetchEmployees = async (
  size: string = "",
  page: string = "",
  searchWords: string = "",
  sortDirection: string = "",
  sortBy: string = "",
  jobTitleIds: string = "",
  startDate: string = "",
  endDate: string = "",
): Promise<PaginatedResponse> => {
  try {
    const response = await apiClient.get<PaginatedResponse>("/employees", {
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
