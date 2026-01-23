package com.eminyber.employee_dashboard_api.employees.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import com.eminyber.employee_dashboard_api.common.models.PaginatedResponse;
import com.eminyber.employee_dashboard_api.employees.models.CreateEmployeeRequest;
import com.eminyber.employee_dashboard_api.employees.models.Employee;
import com.eminyber.employee_dashboard_api.employees.models.EmployeeResponse;
import com.eminyber.employee_dashboard_api.employees.models.HiresPerMonthResponse;
import com.eminyber.employee_dashboard_api.employees.models.UpdateEmployeeRequest;
import com.eminyber.employee_dashboard_api.jobtitles.mappers.JobTitleMapper;
import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitle;
import com.eminyber.employee_dashboard_api.projects.mappers.ProjectMapper;
import com.eminyber.employee_dashboard_api.projects.models.Project;

@Mapper(componentModel = "spring", uses = {JobTitleMapper.class, ProjectMapper.class})
public interface EmployeeMapper {
    EmployeeResponse toResponse(Employee employee);

    List<EmployeeResponse> toResponseList(List<Employee> employees);

    @Mapping(target = "data", expression = "java(toResponseList(page.getContent()))")
    @Mapping(target = "currentPage", expression = "java(page.getNumber() + 1)")
    @Mapping(target = "totalPages", source = "page.totalPages")
    @Mapping(target = "totalItems", source = "page.totalElements")
    @Mapping(target = "pageSize", source = "page.size")
    PaginatedResponse<EmployeeResponse> toPaginatedResponse(Page<Employee> page);

    @Mapping(target = "jobTitle", source = "jobTitle")
    @Mapping(target = "projects", source = "projects")
    Employee toEmployee(CreateEmployeeRequest request, JobTitle jobTitle, Set<Project> projects);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "jobTitle", source = "jobTitle")
    @Mapping(target = "projects", source = "projects")
    void updateEmployee(UpdateEmployeeRequest request, @MappingTarget Employee employee, 
                            JobTitle jobTitle, Set<Project> projects);

    HiresPerMonthResponse toHiresPerMonthData(Integer monthIndex, Long hireCount);
}