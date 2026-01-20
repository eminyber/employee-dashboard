package com.eminyber.employee_dashboard_api.common.exceptions.models;

import java.time.LocalDateTime;

public record StandardErrorResponse(LocalDateTime timeStamp, int statusCode, String errorMessage, String path, String details) {} 