package com.spring.employee_service.service;

import com.spring.employee_service.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080" ,value = "DEPARTMENT-SERVICE")
public interface APIClient {
    
    @GetMapping("api/v1/department/get-by-code/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable(value = "code") String code );
    
   
}
