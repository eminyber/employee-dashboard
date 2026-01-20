package com.eminyber.employee_dashboard_api.jobtitles;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceAlreadyExistsException;
import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceInUseException;
import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceNotFoundException;
import com.eminyber.employee_dashboard_api.employees.EmployeeRepository;
import com.eminyber.employee_dashboard_api.jobtitles.mappers.JobTitleMapper;
import com.eminyber.employee_dashboard_api.jobtitles.models.CreateJobTitleRequest;
import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitle;
import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitleResponse;
import com.eminyber.employee_dashboard_api.jobtitles.models.UpdateJobTitleRequest;

@Service
public class JobTitleService {

    private final JobTitleRepository titleRepository;
    private final EmployeeRepository employeeRepository;
    private final JobTitleMapper titleMapper;

    public JobTitleService(JobTitleRepository titleRepository, EmployeeRepository employeeRepository, JobTitleMapper titleMapper){
        this.titleRepository = titleRepository;
        this.employeeRepository = employeeRepository;
        this.titleMapper = titleMapper;
    }

    public List<JobTitleResponse> getAllJobTitles() {
        return titleMapper.toResponseList(titleRepository.findAll());
    }

    public JobTitleResponse getJobTitle(Long id) {
        JobTitle jobTitle = titleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobTitle", "id", id));
        return titleMapper.toResponse(jobTitle);
    }

    @Transactional
    public JobTitleResponse createJobTitle(CreateJobTitleRequest request) {
        if (titleRepository.existsByTitle(request.title())){
            throw new ResourceAlreadyExistsException("JobTitle", "title", request.title());
        }

        JobTitle newJobTitle = titleMapper.toJobTitle(request);
        return titleMapper.toResponse(titleRepository.save(newJobTitle));
    }

    @Transactional
    public JobTitleResponse updateJobTitle(Long id, UpdateJobTitleRequest request){
        JobTitle jobTitle = titleRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("JobTitle", "id", id));

        if (Objects.equals(jobTitle.getTitle(), request.title())) {
            return titleMapper.toResponse(jobTitle);
        }

        if (titleRepository.existsByTitleAndIdNot(request.title(), id)) {
            throw new ResourceAlreadyExistsException("JobTitle", "title", request.title());
        }

        titleMapper.updateJobTitle(request, jobTitle);
        return titleMapper.toResponse(titleRepository.save(jobTitle));
    }

    @Transactional
    public void deleteJobTitle(Long id){
        JobTitle jobTitle = titleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("JobTitle", "id", id));

        if (employeeRepository.existsByJobTitle_Id(id)) {
            throw new ResourceInUseException("JobTitle", "id", id, "employees");
        }

        titleRepository.delete(jobTitle);
    }
}
