package com.eminyber.employee_dashboard_api.jobtitles;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.eminyber.employee_dashboard_api.jobtitles.models.CreateJobTitleRequest;
import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitleResponse;
import com.eminyber.employee_dashboard_api.jobtitles.models.UpdateJobTitleRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/jobtitles")
public class JobTitleController {

    private final JobTitleService titleService;

    public JobTitleController(JobTitleService titleService){
        this.titleService = titleService;
    }

    @GetMapping
    public ResponseEntity<List<JobTitleResponse>> getJobTitles() {
        List<JobTitleResponse> retrievedJobTitles = titleService.getAllJobTitles();
        return ResponseEntity.ok(retrievedJobTitles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobTitleResponse> getJobTitle(@PathVariable @Positive Long id){
        JobTitleResponse retrievedJobTitle = titleService.getJobTitle(id);
        return ResponseEntity.ok(retrievedJobTitle);
    }

    @PostMapping
    public ResponseEntity<JobTitleResponse> createJobTitle(
        @Valid @RequestBody CreateJobTitleRequest request, 
        UriComponentsBuilder uriBuilder
    ){
        JobTitleResponse createdJobTitle = titleService.createJobTitle(request);
        var uri = uriBuilder.path("/api/v1/jobtitles/{id}").buildAndExpand(createdJobTitle.id()).toUri();

        return ResponseEntity.created(uri).body(createdJobTitle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobTitleResponse> updateJobTitle(
        @PathVariable @Positive Long id,
        @Valid @RequestBody UpdateJobTitleRequest request
    ){
        JobTitleResponse updatedJobTitle = titleService.updateJobTitle(id, request);
        return ResponseEntity.ok(updatedJobTitle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobTitle(@PathVariable @Positive Long id){
        titleService.deleteJobTitle(id);
        return ResponseEntity.noContent().build();
    }
}