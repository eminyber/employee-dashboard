import apiClient from "./apiClient";
import type { MonthlyHires } from "../models/MontlyHires";

export const fetchHiresAGivenYear = async (
  year: number,
): Promise<MonthlyHires[]> => {
  try {
    const response = await apiClient.get<MonthlyHires[]>(
      "employees/analytics/hires-for-year",
      {
        params: { year },
      },
    );

    return response.data;
  } catch (error) {
    console.error("Error fetching number of hired employees:", error);
    throw error;
  }
};
