import apiClient from "./apiClient";
import type { Jobtitle } from "../models/JobTitle";

export const fetchJobTitles = async (): Promise<Jobtitle[]> => {
  try {
    const response = await apiClient.get<Jobtitle[]>("/job-titles");
    return response.data;
  } catch (error) {
    console.error("Error fetching job titles:", error);
    throw error;
  }
};
