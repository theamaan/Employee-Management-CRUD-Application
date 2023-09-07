package com.example.crudapp.repository;

import com.example.crudapp.model.EmployeeEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest

class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    EmployeeEntity employee;
    @BeforeEach
    void setUp() {
        employee = new EmployeeEntity(1,"Amaan","Ullah",450000);
        employeeRepository.save(employee);
    }

    @AfterEach
    void tearDown() {
        employee = null;
        employeeRepository.deleteAll();
    }

    //test Case for Success Scenario
    @Test
    void findByFirstName_Found() {
        List<EmployeeEntity> employeeList = employeeRepository.findByfirstName("Amaan");
        assertThat(employeeList.get(0).getId()).isEqualTo(employee.getId());
        assertThat(employeeList.get(0).getFirstName()).isEqualTo(employee.getFirstName());
        assertThat(employeeList.get(0).getLastName()).isEqualTo(employee.getLastName());
        assertThat(employeeList.get(0).getSalary()).isEqualTo(employee.getSalary());
    }
}