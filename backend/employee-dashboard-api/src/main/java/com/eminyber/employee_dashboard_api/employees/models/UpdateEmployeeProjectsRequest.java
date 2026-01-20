package com.eminyber.employee_dashboard_api.employees.models;

import java.util.Set;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateEmployeeProjectsRequest(
    @NotNull(message = "Project IDs must be provided")
    Set<@Positive(message = "Project ID must be positive") Long> projectIds
){} 
