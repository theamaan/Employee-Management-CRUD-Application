package com.example.crudapp.repository;

import com.example.crudapp.model.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
   List<EmployeeEntity> findByfirstName(String firstName);
}
