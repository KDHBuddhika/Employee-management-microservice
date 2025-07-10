package com.spring.employee_service.service.impl;


import com.spring.employee_service.dto.ApiResponseDto;
import com.spring.employee_service.dto.DepartmentDto;
import com.spring.employee_service.dto.EmployeeDto;
import com.spring.employee_service.entity.Employee;
import com.spring.employee_service.repository.EmployeeRepo;
import com.spring.employee_service.service.APIClient;
import com.spring.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    
    @Autowired
    private EmployeeRepo employeeRepo;
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private APIClient apiClient;
    
    @Autowired
    private WebClient webClient;
    
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
        Employee savedEmployee =   employeeRepo.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );
        return savedEmployeeDto;
    }
    
    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepo.findById(id).get();
        if(employee == null){
            System.out.println("notfound");
        }
    // -------------------- Communication with rest template------------------------
    
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/get-by-code/"+ employee.getDepartmentCode(),
//                DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
    
    
    //-----------------communication with web client-----------------------------------
    
//        DepartmentDto departmentDto =   webClient.get()
//                .uri("http://localhost:8080/api/v1/department/get-by-code/"+employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();   // meka use karahama asyncronus communication ekk
    
    
        
    //------------------ Communicate with open feign client ------------------------------------
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
        
        
        EmployeeDto employeeDto =new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
    
        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
       
    }
}
