package com.example.crudapp.service;

import com.example.crudapp.model.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    String createEmployee(EmployeeEntity employee);
    List<EmployeeEntity> getEmployee();
    String getEmployeeById(int id);
    String updateEmployee(EmployeeEntity updatedEmployee, int id);
    String deleteEmployee(int id);
    List<EmployeeEntity>getEmployeeByFirstName(String firstName);
}
