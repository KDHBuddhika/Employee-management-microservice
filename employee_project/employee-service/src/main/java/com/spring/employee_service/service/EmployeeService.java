package com.spring.employee_service.service;

import com.spring.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    
    EmployeeDto getEmployeeById(Long id);
}
