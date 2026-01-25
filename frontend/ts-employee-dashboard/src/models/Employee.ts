import type { Jobtitle } from "./JobTitle";
import type { Project } from "./project";

export type Employee = {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  jobTitle: Jobtitle;
  employedDate: Date;
  projects: Project[];
};
