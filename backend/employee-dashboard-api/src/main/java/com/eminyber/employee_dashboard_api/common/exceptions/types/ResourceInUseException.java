package com.eminyber.employee_dashboard_api.common.exceptions.types;

public class ResourceInUseException extends RuntimeException{
    public ResourceInUseException(String resourceName, String field, Object value, String usedByEntity) {
        super("%s with %s '%s' cannot be deleted since it is currently in use by one or more %s".formatted(resourceName, field, value, usedByEntity));
    }

    public ResourceInUseException(String message) {
        super(message);
    }
}
