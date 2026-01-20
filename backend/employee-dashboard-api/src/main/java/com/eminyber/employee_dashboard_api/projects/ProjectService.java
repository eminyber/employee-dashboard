package com.eminyber.employee_dashboard_api.projects;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceAlreadyExistsException;
import com.eminyber.employee_dashboard_api.common.exceptions.types.ResourceNotFoundException;
import com.eminyber.employee_dashboard_api.projects.mappers.ProjectMapper;
import com.eminyber.employee_dashboard_api.projects.models.ProjectResponse;
import com.eminyber.employee_dashboard_api.projects.models.UpdateProjectRequest;

import jakarta.transaction.Transactional;

import com.eminyber.employee_dashboard_api.projects.models.CreateProjectRequest;
import com.eminyber.employee_dashboard_api.projects.models.Project;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper){
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    public List<ProjectResponse> getAllProjects(){
        return projectMapper.toResponseList(projectRepository.findAll());
    }

    public ProjectResponse getProject(long id){
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        return projectMapper.toResponse(project);   
    }

    @Transactional
    public ProjectResponse createProject(CreateProjectRequest request){
        if (projectRepository.existsByName(request.name())){
            throw new ResourceAlreadyExistsException("Project", "name", request.name());
        }

        Project newProject = projectMapper.toProject(request);
        return projectMapper.toResponse(projectRepository.save(newProject));
    }

    @Transactional
    public ProjectResponse updateProject(Long id, UpdateProjectRequest request){
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        
        if (Objects.equals(request.name(), project.getName())){
            return projectMapper.toResponse(project);
        }

        if(projectRepository.existsByNameAndIdNot(request.name(), id)){
            throw new ResourceAlreadyExistsException("Project", "name", request.name());
        }

        projectMapper.updateProject(request, project);
        return projectMapper.toResponse(projectRepository.save(project));
    }

    @Transactional
    public void deleteProject(Long id){
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        
        projectRepository.delete(project);
    }
}