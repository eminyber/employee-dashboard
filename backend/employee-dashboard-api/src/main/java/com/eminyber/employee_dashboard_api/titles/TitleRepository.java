package com.eminyber.employee_dashboard_api.titles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eminyber.employee_dashboard_api.titles.models.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {} 