package com.eminyber.employee_dashboard_api.common.exceptions;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eminyber.employee_dashboard_api.common.exceptions.mappers.StandardErrorResponseMapper;
import com.eminyber.employee_dashboard_api.common.exceptions.models.StandardErrorResponse;
import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceAlreadyExistsException;
import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceInUseException;
import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {

    private final StandardErrorResponseMapper errorMapper;

    public AppExceptionHandler(StandardErrorResponseMapper errorMapper) {
        this.errorMapper = errorMapper;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> handleResourceNotFoundException(
        ResourceNotFoundException ex,
        HttpServletRequest request
    ){ 
        logError(ex.getMessage(), ex);

        return buildResponse("Resource not found", HttpStatus.NOT_FOUND, request.getRequestURI(), ex.getMessage());
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<StandardErrorResponse> handleResourceAlreadyExistsException(
        ResourceAlreadyExistsException ex,
        HttpServletRequest request
    ){ 
        logError(ex.getMessage(), ex);

        return buildResponse("Resource already exists", HttpStatus.BAD_REQUEST, request.getRequestURI(), ex.getMessage());
    }

    @ExceptionHandler(ResourceInUseException.class)
    public ResponseEntity<StandardErrorResponse> handleResourceInUseException(        
        ResourceInUseException ex,
        HttpServletRequest request
    ){
        logError(ex.getMessage(), ex);

        return buildResponse("Resource in use", HttpStatus.CONFLICT, request.getRequestURI(), ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardErrorResponse> handleValidationException(
        MethodArgumentNotValidException ex,
        HttpServletRequest request
    ) {
        logError(ex.getMessage(), ex);

        String details = ex.getBindingResult().getFieldErrors().stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.joining(", "));

        return buildResponse("Validation failed", HttpStatus.BAD_REQUEST, request.getRequestURI(), details);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<StandardErrorResponse> handleConstraintViolation(
        ConstraintViolationException ex,
        HttpServletRequest request
    ) {
        logError(ex.getMessage(), ex);

        return buildResponse("Constraint violation", HttpStatus.BAD_REQUEST, request.getRequestURI(), ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<StandardErrorResponse> handleRuntimeException(
        RuntimeException ex,
        HttpServletRequest request
    ){
        logError(ex.getMessage(), ex);

        return buildResponse("Unhandled runtime exception", HttpStatus.INTERNAL_SERVER_ERROR, request.getRequestURI(), null);
    }

    private ResponseEntity<StandardErrorResponse> buildResponse(String ex, HttpStatus status, String path, String details) {
        StandardErrorResponse errorResponse = errorMapper.toResponse(ex, status, path, details);
        return ResponseEntity.status(status).body(errorResponse);
    }

    private void logError(String msg, Exception ex){
        log.error(msg, ex);
    }
}