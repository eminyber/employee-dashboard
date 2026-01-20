package com.eminyber.employee_dashboard_api.common.exceptions.types;

public class ResourceAlreadyExistsException extends RuntimeException {
     public ResourceAlreadyExistsException(String resourceName, String field, Object value) {
        super("%s with %s '%s' already exists".formatted(resourceName, field, value));
    }

    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}
