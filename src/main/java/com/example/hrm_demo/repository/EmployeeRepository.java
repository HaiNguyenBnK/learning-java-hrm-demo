package com.example.hrm_demo.repository;

import com.example.hrm_demo.model.Employee;
import com.example.hrm_demo.model.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
  // Custom query methods can be added here (if needed)
  List<Employee> findByRole(EmployeeRole role);
}
