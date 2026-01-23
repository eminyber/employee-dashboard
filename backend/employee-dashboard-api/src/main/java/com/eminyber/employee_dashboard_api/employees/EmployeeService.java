package com.eminyber.employee_dashboard_api.employees;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceAlreadyExistsException;
import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceNotFoundException;
import com.eminyber.employee_dashboard_api.common.models.PaginatedResponse;
import com.eminyber.employee_dashboard_api.employees.mappers.EmployeeMapper;
import com.eminyber.employee_dashboard_api.employees.models.CreateEmployeeRequest;
import com.eminyber.employee_dashboard_api.employees.models.Employee;
import com.eminyber.employee_dashboard_api.employees.models.EmployeeResponse;
import com.eminyber.employee_dashboard_api.employees.models.HiresPerMonthResponse;
import com.eminyber.employee_dashboard_api.employees.models.UpdateEmployeeProjectsRequest;
import com.eminyber.employee_dashboard_api.employees.models.UpdateEmployeeRequest;
import com.eminyber.employee_dashboard_api.employees.specifications.EmployeeSpecification;
import com.eminyber.employee_dashboard_api.jobtitles.JobTitleRepository;
import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitle;
import com.eminyber.employee_dashboard_api.projects.ProjectRepository;
import com.eminyber.employee_dashboard_api.projects.models.Project;
import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    private final JobTitleRepository titleRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, JobTitleRepository titleRepository, 
                            ProjectRepository projectRepository, EmployeeMapper employeeMapper){
        this.employeeRepository = employeeRepository;
        this.titleRepository = titleRepository;
        this.projectRepository = projectRepository;
        this.employeeMapper = employeeMapper;
    }

    public PaginatedResponse<EmployeeResponse> getAllEmployees(
        Pageable page,
        List<String> searchWords,
        List<Integer> jobTitleIds,
        LocalDate startDate,
        LocalDate endDate
    ){
        //Should probably create some form of builder class here to make it cleaner. However, ommited due to time
        Specification<Employee> spec = Specification.where(EmployeeSpecification.fullNameSearch(searchWords).and(
                                                           EmployeeSpecification.hasJobTitleId(jobTitleIds)).and(
                                                           EmployeeSpecification.hiredBetween(startDate, endDate)));

        Page<Employee> employeePage = employeeRepository.findAll(spec, page);
        
        return employeeMapper.toPaginatedResponse(employeePage);
    }

    public EmployeeResponse getEmployee(long id){
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        return employeeMapper.toResponse(employee);
    }

    @Transactional
    public EmployeeResponse createEmployee(CreateEmployeeRequest request){
        if(employeeRepository.existsByEmail(request.email())){
            throw new ResourceAlreadyExistsException("Employee", "email", request.email());
        }

        JobTitle jobTitle = titleRepository.findById(request.jobTitleId())
            .orElseThrow(() -> new ResourceNotFoundException("JobTitle", "id", request.jobTitleId()));
        
        Set<Project> projects = getProjectsOrThrowOnNotFound(request.projectIds());

        Employee newEmployee = employeeMapper.toEmployee(request, jobTitle, projects);
        return employeeMapper.toResponse(employeeRepository.save(newEmployee));
    }

    @Transactional
    public EmployeeResponse updateEmployee(long id, UpdateEmployeeRequest request){
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        
        if(employeeRepository.existsByEmailAndIdNot(request.email(), id)){
            throw new ResourceAlreadyExistsException("Employee", "email", request.email());
        }

        JobTitle jobTitle = titleRepository.findById(request.jobTitleId())
            .orElseThrow(() -> new ResourceNotFoundException("JobTitle", "id", request.jobTitleId()));
        
        Set<Project> projects = getProjectsOrThrowOnNotFound(request.projectIds());

        employeeMapper.updateEmployee(request, employee, jobTitle, projects);
        return employeeMapper.toResponse(employeeRepository.save(employee));
    }

    @Transactional
    public void deleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        
        employeeRepository.delete(employee);
    }

    @Transactional
    public EmployeeResponse updateEmployeeProjects(Long id, UpdateEmployeeProjectsRequest request){
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        Set<Project> projects = getProjectsOrThrowOnNotFound(request.projectIds());
        
        employee.setProjects(projects);
        return employeeMapper.toResponse(employeeRepository.save(employee));
    }

    public List<HiresPerMonthResponse> getYearlyHiredCount(int year){
        List<Object[]> hireData = employeeRepository.countEmployeesHiredPerMonth(year);

        //Should probably create the whole and cleaner mapping function inside the employeeMapper class. 
        //Will do if time permits
        List<HiresPerMonthResponse> hireDataResponse = new ArrayList<>();
        for (Object[] object :  hireData) {
            hireDataResponse.add(employeeMapper.toHiresPerMonthData((Integer) object[0], (Long) object[1]));
        }

        return hireDataResponse;
    }

    private Set<Project> getProjectsOrThrowOnNotFound(Set<Long> projectIds) {
        List<Project> projectsList = projectRepository.findAllById(projectIds);
        if (projectsList.size() != projectIds.size()) {
            var foundIds = projectsList.stream().map(Project::getId).toList();
            var missingIds = projectIds.stream()
                .filter(id -> !foundIds.contains(id))
                .toList();
            throw new ResourceNotFoundException("The following Project IDs were not found: " + missingIds.toString());
        }

        return new HashSet<>(projectsList);
    }
}
