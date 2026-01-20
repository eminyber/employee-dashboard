package com.eminyber.employee_dashboard_api.jobtitles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eminyber.employee_dashboard_api.jobtitles.models.JobTitle;

@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {
    boolean existsByTitle(String title);
    boolean existsByTitleAndIdNot(String title, Long id);
} 