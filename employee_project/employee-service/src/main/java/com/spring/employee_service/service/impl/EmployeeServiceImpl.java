package com.spring.employee_service.service.impl;


import com.spring.employee_service.dto.EmployeeDto;
import com.spring.employee_service.entity.Employee;
import com.spring.employee_service.repository.EmployeeRepo;
import com.spring.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    
    @Autowired
    private EmployeeRepo employeeRepo;
    
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
        Employee savedEmployee =   employeeRepo.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );
        return savedEmployeeDto;
    }
    
    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id).get();
        if(employee == null){
            System.out.println("notfound");
        }
        EmployeeDto employeeDto =new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
        return employeeDto;
       
    }
}
