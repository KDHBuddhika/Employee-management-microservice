package com.spring.department_service.controller;

import com.spring.department_service.dto.DepartmentDto;
import com.spring.department_service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @PostMapping("/add-department")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        System.out.println(1);
        System.out.println(departmentDto);
        DepartmentDto departmentDto1 = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto, HttpStatus.CREATED);
    }
}
