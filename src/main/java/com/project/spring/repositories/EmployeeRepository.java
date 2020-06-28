package com.project.spring.repositories;

import com.project.spring.entities.Employee;
import com.project.spring.entities.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> searchByName(String name);
    List<Employee> searchBySurname(String surname);
}
