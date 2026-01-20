package com.eminyber.employee_dashboard_api.projects;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eminyber.employee_dashboard_api.projects.models.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
} 