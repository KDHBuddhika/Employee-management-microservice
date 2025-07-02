package com.spring.department_service.service.impl;

import com.spring.department_service.dto.DepartmentDto;
import com.spring.department_service.entity.Department;
import com.spring.department_service.repository.DepartmentRepo;
import com.spring.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    
    
    private DepartmentRepo departmentRepo;
    
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
    
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
        Department savedDepartment1 = departmentRepo.save(department);
        
        DepartmentDto savedDepartmentDto = new DepartmentDto(
                savedDepartment1.getId(),
                savedDepartment1.getDepartmentName(),
                savedDepartment1.getDepartmentDescription(),
                savedDepartment1.getDepartmentCode()
        );
        
        return savedDepartmentDto;
    }
    
    
    
    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepo.findByDepartmentCode(code);
        if(department == null){
            System.out.println("notfound");
        }
        DepartmentDto departmentDto =new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDto;
    }
}
