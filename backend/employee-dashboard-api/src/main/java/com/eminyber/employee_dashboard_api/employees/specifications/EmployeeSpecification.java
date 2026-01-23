package com.eminyber.employee_dashboard_api.employees.specifications;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.eminyber.employee_dashboard_api.employees.models.Employee;

public class EmployeeSpecification {
    public static Specification<Employee> firstNameContains(String firstName) {
        return (root, query, cb) -> {
            if (firstName == null || firstName.isBlank()) {
                return cb.conjunction();
            }

            return cb.like(root.get("firstName"), "%" + firstName + "%");
        };
    }

    public static Specification<Employee> lastNameContains(String lastName) {
        return (root, query, cb) -> {
            if (lastName == null || lastName.isBlank()) {
                return cb.conjunction();
            }

            return cb.like(root.get("lastName"), "%" + lastName + "%");
        };
    }

    public static Specification<Employee> fullNameSearch(List<String> searchWords){
        return (root, query, cb) -> {
        if (searchWords == null || searchWords.isEmpty()) {
            return cb.conjunction();
        }

        if (searchWords.size() == 1){
            return firstNameContains(searchWords.get(0)).or(lastNameContains(searchWords.get(0))).toPredicate(root, query, cb);
        }

        // Simplified the search: Exact match for Firstname + Lastname in that order is required for the search to work right now. 
        if (searchWords.size() > 1){
            System.out.println(searchWords);
            return firstNameContains(searchWords.get(0)).and(lastNameContains(searchWords.get(1))).toPredicate(root, query, cb);
        }

        return cb.conjunction();
    };
    }

    public static Specification<Employee> hasJobTitleId(List<Integer> jobTitleIds) {
        return (root, query, cb) -> {
            if (jobTitleIds == null || jobTitleIds.isEmpty()) {
                return cb.conjunction();
            }

        return root.get("jobTitle").get("id").in(jobTitleIds);
    };
}

    public static Specification<Employee> hasProjectId(int projectId) {
        return (root, query, cb) -> {
            if (projectId <= 0){
                return cb.conjunction();
            }

            return cb.equal(root.get("projects").get("id"), projectId);
        };
    }

    public static Specification<Employee> hiredBetween(LocalDate startDate, LocalDate endDate) {
        return (root, query, cb) -> {

            if (startDate == null && endDate == null) {
                return cb.conjunction();
            }

            if (startDate != null && endDate != null) {
                return cb.between(root.get("employedDate"), startDate, endDate);
            }

            if (startDate != null) {
                return cb.greaterThanOrEqualTo(root.get("employedDate"), startDate);
            }

            return cb.lessThanOrEqualTo(root.get("employedDate"), endDate);
        };
    }   
}
