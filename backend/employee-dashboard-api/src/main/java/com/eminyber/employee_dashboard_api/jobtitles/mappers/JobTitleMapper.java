package com.eminyber.employee_dashboard_api.jobtitles.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.eminyber.employee_dashboard_api.jobtitles.models.CreateJobTitleRequest;
import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitle;
import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitleResponse;
import com.eminyber.employee_dashboard_api.jobtitles.models.UpdateJobTitleRequest;

@Mapper(componentModel = "spring")
public interface JobTitleMapper {
    JobTitleResponse toResponse(JobTitle title);
    List<JobTitleResponse> toResponseList(List<JobTitle> titles);

    @Mapping(target = "id", ignore = true)
    JobTitle toJobTitle(CreateJobTitleRequest jobTitleRequest);

    @Mapping(target = "id", ignore = true)
    void updateJobTitle(UpdateJobTitleRequest jobTitleRequest, @MappingTarget JobTitle jobTitle);
}