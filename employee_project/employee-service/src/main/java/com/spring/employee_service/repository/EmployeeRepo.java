package com.spring.employee_service.repository;

import com.spring.employee_service.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee ,Long> {
}
