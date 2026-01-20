package com.eminyber.employee_dashboard_api.employees.specifications;

import java.time.LocalDate;

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

    public static Specification<Employee> emailContains(String email) {
        return (root, query, cb) -> {
            if (email == null || email.isBlank()) {
                return cb.conjunction();
            }

            return cb.like(root.get("email"), "%" + email + "%");
        };
    }

    public static Specification<Employee> hasJobTitleId(int jobTitleId) {
         return (root, query, cb) -> {
            if (jobTitleId <= 0){
                return cb.conjunction();
            }

            return cb.equal(root.get("jobTitle").get("id"), jobTitleId);
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
