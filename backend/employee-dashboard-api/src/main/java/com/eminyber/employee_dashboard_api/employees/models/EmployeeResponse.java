package com.eminyber.employee_dashboard_api.employees.models;

import java.time.LocalDate;
import java.util.Set;

import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitleResponse;
import com.eminyber.employee_dashboard_api.projects.models.ProjectResponse;

public record EmployeeResponse(
        Long id,
        String firstName,
        String lastName,
        String email,
        JobTitleResponse jobTitle,
        LocalDate employedDate,
        Set<ProjectResponse> projects
) {}
