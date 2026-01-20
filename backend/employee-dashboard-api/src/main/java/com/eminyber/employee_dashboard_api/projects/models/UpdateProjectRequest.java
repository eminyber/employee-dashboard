package com.eminyber.employee_dashboard_api.projects.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateProjectRequest(    
    @NotBlank(message = "name is required")
    @Size(max = 255, message = "name must be at most 255 characters")
    String name
){} 
