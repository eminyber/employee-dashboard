package com.eminyber.employee_dashboard_api.common.exceptions.types;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String resourceName, String field, Object value) {
        super("%s with %s '%s' was not found".formatted(resourceName, field, value));
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}