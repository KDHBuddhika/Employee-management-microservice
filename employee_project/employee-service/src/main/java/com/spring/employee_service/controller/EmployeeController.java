package com.spring.employee_service.controller;


import com.spring.employee_service.dto.ApiResponseDto;
import com.spring.employee_service.dto.EmployeeDto;
import com.spring.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("save-emp")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(employeeDto, HttpStatus.CREATED);
    }
    
    
    @GetMapping("/get-emp/{id}")
    public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable Long id){
        System.out.println(id);
        ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
        return  new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
    
    
}
