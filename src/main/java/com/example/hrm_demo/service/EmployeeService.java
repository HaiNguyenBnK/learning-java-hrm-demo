package com.example.hrm_demo.service;

import com.example.hrm_demo.model.Company;
import com.example.hrm_demo.model.Employee;
import com.example.hrm_demo.model.EmployeeRole;
import com.example.hrm_demo.model.User;
import com.example.hrm_demo.repository.CompanyRepository;
import com.example.hrm_demo.repository.EmployeeRepository;
import com.example.hrm_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CompanyRepository companyRepository;

  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("Employee not found with id: " + id));
  }

  public Employee saveEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }
}
