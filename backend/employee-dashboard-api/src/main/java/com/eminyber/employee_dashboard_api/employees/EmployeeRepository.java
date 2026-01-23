package com.eminyber.employee_dashboard_api.employees;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.eminyber.employee_dashboard_api.employees.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
    boolean existsByJobTitle_Id(Long id);
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, Long id);

    @Query(value = """
    SELECT MONTH(employed_date) AS month, COUNT(*) AS totalHired
    FROM employees
    WHERE YEAR(employed_date) = :year
    GROUP BY MONTH(employed_date)
    ORDER BY month
    """, nativeQuery = true)
    List<Object[]> countEmployeesHiredPerMonth(@Param("year") int year);
}