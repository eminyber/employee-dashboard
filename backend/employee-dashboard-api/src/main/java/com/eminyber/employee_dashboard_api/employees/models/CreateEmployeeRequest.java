package com.eminyber.employee_dashboard_api.employees.models;

import java.time.LocalDate;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public record CreateEmployeeRequest(
        @NotBlank(message = "First name is required")
        String firstName,

        @NotBlank(message = "Last name is required")
        String lastName,

        @NotBlank(message = "Email is required")
        @Email(message = "Email must be valid")
        String email,

        @NotNull(message = "Job title ID is required")
        @Positive(message = "Job title ID must be positive")
        Long jobTitleId,

        @NotNull(message = "Employed date is required")
        @PastOrPresent(message = "Employed date cannot be in the future")
        LocalDate employedDate,

        @NotNull(message = "Project IDs must be provided")
        Set<@Positive(message = "Project ID must be positive") Long> projectIds
){}