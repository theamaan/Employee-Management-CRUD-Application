package com.example.crudapp.service;

import com.example.crudapp.model.EmployeeEntity;
import com.example.crudapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService{
    public EmployeeServiceimpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(EmployeeEntity employee){
        employeeRepository.save(employee);
        return "Employee record created with ID :"+employee.getId();
    }

    public List<EmployeeEntity> getEmployee(){
       return employeeRepository.findAll();
    }

    public String getEmployeeById(int id){
        return "Employee with id :"+id+" is "+employeeRepository.findById(id);
    }

    public String updateEmployee(EmployeeEntity updatedEmployee, int id){
        Optional<EmployeeEntity> existingEmployee = employeeRepository.findById(id);
        if(existingEmployee.isPresent()){
            EmployeeEntity employee = existingEmployee.get();
            employee.setSalary(updatedEmployee.getSalary());
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employeeRepository.save(employee);
            return "Updated Employee record with id :"+id+" is "+employee;
        }else{
            return "Record does not exist";
        }
    }
    public List<EmployeeEntity> getEmployeeByFirstName(String firstName){
        return employeeRepository.findByfirstName(firstName);
    }
    public String deleteEmployee(int id){
        employeeRepository.deleteById(id);
        return "Employee Record with id :"+id+" is deleted";
    }
}
