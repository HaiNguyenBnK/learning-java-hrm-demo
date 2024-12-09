package com.example.hrm_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home(Model model) {
    model.addAttribute("message", "This is the HRM Dashboard.");
    return "index"; // Resolves to WEB-INF/views/index.jsp
  }
}
