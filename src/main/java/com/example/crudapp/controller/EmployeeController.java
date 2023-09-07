package com.example.crudapp.controller;


import com.example.crudapp.model.EmployeeEntity;
import com.example.crudapp.service.EmployeeServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeServiceimpl employeeService;

    @PostMapping("/employee")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeEntity employee){
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeEntity>> getEmployee(){
        List<EmployeeEntity> response = employeeService.getEmployee();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<String> getEmployeeById(@PathVariable int id){
        String response = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @GetMapping("/employee/{fName}")
    public ResponseEntity<List<EmployeeEntity>> getEmployeeById(@PathVariable String fName){
        List<EmployeeEntity> response = employeeService.getEmployeeByFirstName(fName);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeEntity updatedEmployee, @PathVariable int id){
        String response = employeeService.updateEmployee(updatedEmployee,id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        String response = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
