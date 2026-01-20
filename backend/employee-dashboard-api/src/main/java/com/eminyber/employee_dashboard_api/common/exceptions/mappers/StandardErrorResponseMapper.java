package com.eminyber.employee_dashboard_api.common.exceptions.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.http.HttpStatus;

import com.eminyber.employee_dashboard_api.common.exceptions.models.StandardErrorResponse;

@Mapper(componentModel = "spring")
public interface StandardErrorResponseMapper {

    @Mapping(target = "timeStamp", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "statusCode", expression = "java(status.value())")
    @Mapping(target = "errorMessage", source = "exception")
    @Mapping(target = "path", source = "path")
    @Mapping(target = "details", source = "details")
    StandardErrorResponse toResponse(
            String exception,
            HttpStatus status,
            String path,
            String details
    );
}
