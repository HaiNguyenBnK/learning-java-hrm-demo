package com.example.hrm_demo.controller;

import com.example.hrm_demo.model.Employee;
import com.example.hrm_demo.model.EmployeeRole;
import com.example.hrm_demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public String listEmployees(Model model) {
    List<Employee> employees = employeeService.getAllEmployees();
    model.addAttribute("employees", employees);
    return "employee/list";
  }

  @GetMapping("/new")
  public String showCreateForm(Model model) {
    model.addAttribute("employee", new Employee());
    model.addAttribute("roles", EmployeeRole.values());
    model.addAttribute("users", employeeService.getAllUsers());
    model.addAttribute("companies", employeeService.getAllCompanies());
    return "employee/form";
  }

  @PostMapping
  public String saveEmployee(@ModelAttribute Employee employee) {
    employeeService.saveEmployee(employee);
    return "redirect:/employees";
  }

  @GetMapping("/edit/{id}")
  public String showEditForm(@PathVariable Long id, Model model) {
    Employee employee = employeeService.getEmployeeById(id);
    model.addAttribute("employee", employee);
    model.addAttribute("roles", EmployeeRole.values());
    model.addAttribute("users", employeeService.getAllUsers());
    model.addAttribute("companies", employeeService.getAllCompanies());
    return "employee/form";
  }

  @GetMapping("/delete/{id}")
  public String deleteEmployee(@PathVariable Long id) {
    employeeService.deleteEmployee(id);
    return "redirect:/employees";
  }
}
