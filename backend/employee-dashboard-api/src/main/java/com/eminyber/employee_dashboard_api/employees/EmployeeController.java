package com.eminyber.employee_dashboard_api.employees;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.eminyber.employee_dashboard_api.common.models.PaginatedResponse;
import com.eminyber.employee_dashboard_api.employees.models.CreateEmployeeRequest;
import com.eminyber.employee_dashboard_api.employees.models.EmployeeResponse;
import com.eminyber.employee_dashboard_api.employees.models.UpdateEmployeeProjectsRequest;
import com.eminyber.employee_dashboard_api.employees.models.UpdateEmployeeRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
     //Should probably change all of these RequestParams to a DTO 
     //It validates but the messages does not get printed probably, fix if I got time
    @GetMapping
    public ResponseEntity<PaginatedResponse<EmployeeResponse>> getEmployees( 
        @RequestParam(defaultValue = "1")  @Positive(message = "Page must be positive") int page,
        @RequestParam(defaultValue = "15") @Positive(message = "Size must be positive") int size,
        @RequestParam(defaultValue = "id")  String sortBy, 
        @RequestParam(defaultValue = "asc") String sortDirection,
        @RequestParam(required = false) String search,
        @RequestParam(defaultValue = "0") @PositiveOrZero(message = "jobTitleId must be zero or positive") int jobTitleId,
        @RequestParam(defaultValue = "0") @PositiveOrZero(message = "projectId must be zero or positive") int projectId,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ){
        PaginatedResponse<EmployeeResponse> retrievedEmployees = employeeService.getAllEmployees(page, size, sortBy, sortDirection, search, jobTitleId, projectId, startDate, endDate);
        return ResponseEntity.ok(retrievedEmployees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable @Positive Long id) {
        EmployeeResponse retrievedEmployee = employeeService.getEmployee(id);
        return ResponseEntity.ok(retrievedEmployee);
    }

    @PostMapping()
    public ResponseEntity<EmployeeResponse> createEmployee(
        @Valid @RequestBody CreateEmployeeRequest request,
        UriComponentsBuilder uriBuilder
    ){
        EmployeeResponse createdEmployee = employeeService.createEmployee(request);
        var uri = uriBuilder.path("/api/v1/employees/{id}").buildAndExpand(createdEmployee.id()).toUri();

        return ResponseEntity.created(uri).body(createdEmployee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
        @PathVariable @Positive Long id,
        @Valid @RequestBody UpdateEmployeeRequest request
    ){
        EmployeeResponse updatedEmployee = employeeService.updateEmployee(id, request);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable @Positive Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/projects")
    public ResponseEntity<EmployeeResponse> updateEmployeeProjects(
        @PathVariable @Positive Long id,
        @Valid @RequestBody UpdateEmployeeProjectsRequest request
    ){
        EmployeeResponse updatedEmployee = employeeService.updateEmployeeProjects(id, request);
        return ResponseEntity.ok(updatedEmployee);
    }
}