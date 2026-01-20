package com.eminyber.employee_dashboard_api.projects;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.eminyber.employee_dashboard_api.projects.models.CreateProjectRequest;
import com.eminyber.employee_dashboard_api.projects.models.ProjectResponse;
import com.eminyber.employee_dashboard_api.projects.models.UpdateProjectRequest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }   

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getProjects() {
        List<ProjectResponse> retrievedProjects = projectService.getAllProjects();
        
        return ResponseEntity.ok(retrievedProjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable @Positive Long id){
        ProjectResponse retrievedProject = projectService.getProject(id);
        
        return ResponseEntity.ok(retrievedProject);
    }

    @PostMapping()
    public ResponseEntity<ProjectResponse> createProject(
        @Valid @RequestBody CreateProjectRequest request,
        UriComponentsBuilder uriBuilder
    ){   
        ProjectResponse createdProject = projectService.createProject(request);
        var uri = uriBuilder.path("/api/v1/projects/{id}").buildAndExpand(createdProject.id()).toUri();

        return ResponseEntity.created(uri).body(createdProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(
        @PathVariable @Positive Long id, 
        @Valid @RequestBody UpdateProjectRequest request
    ){
        ProjectResponse updatedProject = projectService.updateProject(id, request);
        
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable @Positive Long id){
        projectService.deleteProject(id);

        return ResponseEntity.noContent().build();
    }
}