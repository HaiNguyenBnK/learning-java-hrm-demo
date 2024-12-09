package com.example.hrm_demo.seeder;

import com.example.hrm_demo.model.Company;
import com.example.hrm_demo.model.Employee;
import com.example.hrm_demo.model.EmployeeRole;
import com.example.hrm_demo.model.User;
import com.example.hrm_demo.repository.CompanyRepository;
import com.example.hrm_demo.repository.EmployeeRepository;
import com.example.hrm_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public void run(String... args) throws Exception {
    if (userRepository.count() == 0 && companyRepository.count() == 0 && employeeRepository.count() == 0) {
      // Seeding Users
      List<User> users = List.of(
              new User(null, "BnK Test", "bnk13032018", "admin"),
              new User(null, "Alice", "alice123", "user"),
              new User(null, "Bob", "bob123", "user")
      );
      users = userRepository.saveAll(users);

      // Seeding Companies
      List<Company> companies = List  .of(
              new Company(null, "Bnk Solution", "Dịch Vọng Hậu, Cầu Giấy, Hà Nội", users.get(0))
      );
      companies = companyRepository.saveAll(companies);

      // Seeding Employees
      List<Employee> employees = List.of(
              new Employee(null, "Thanh", "CEO", 70000, EmployeeRole.MANAGER, users.get(0), companies.get(0)),
              new Employee(null, "Alice", "HR", 25000, EmployeeRole.HR, users.get(1), companies.get(0)),
              new Employee(null, "Teresa", "BU1", 25000, EmployeeRole.EMPLOYEE, users.get(2), companies.get(0))
      );
      employeeRepository.saveAll(employees);

      System.out.println("Database seeded successfully!");
    } else {
      System.out.println("Database already seeded, skipping seeding process...");
    }
  }
}
