package com.example.crudapp.controller;


import com.example.crudapp.model.EmployeeEntity;
import com.example.crudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee")
    public String createEmployee(@RequestBody EmployeeEntity employee){
        employeeService.createEmployee(employee);
        return "Employee record created with ID :"+employee.getId();
    }

    @GetMapping("/employee")
    public List<EmployeeEntity> getEmployee(){
        return employeeService.getEmployee();
    }
    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/employee/{id}")
    public String updateEmployee(@RequestBody EmployeeEntity updatedEmployee, @PathVariable int id){
        return employeeService.updateEmployee(updatedEmployee,id);
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }
}
