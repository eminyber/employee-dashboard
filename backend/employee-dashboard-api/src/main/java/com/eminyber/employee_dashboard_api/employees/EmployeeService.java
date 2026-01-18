package com.eminyber.employee_dashboard_api.employees;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    
}
