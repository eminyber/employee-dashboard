package com.eminyber.employee_dashboard_api.common.models;

import java.util.List;

public record PaginatedResponse<T>(
        List<T> data,
        int currentPage,
        int totalPages,
        long totalItems,
        int pageSize
){}