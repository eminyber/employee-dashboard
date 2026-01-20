package com.eminyber.employee_dashboard_api.projects.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.eminyber.employee_dashboard_api.projects.models.CreateProjectRequest;
import com.eminyber.employee_dashboard_api.projects.models.Project;
import com.eminyber.employee_dashboard_api.projects.models.ProjectResponse;
import com.eminyber.employee_dashboard_api.projects.models.UpdateProjectRequest;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectResponse toResponse(Project project);
    List<ProjectResponse> toResponseList(List<Project> projects);

    @Mapping(target = "id", ignore = true)
    Project toProject(CreateProjectRequest projectRequest);

    @Mapping(target = "id", ignore = true)
    void updateProject(UpdateProjectRequest projectRequest, @MappingTarget Project project);
}
