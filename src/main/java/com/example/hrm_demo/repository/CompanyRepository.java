package com.example.hrm_demo.repository;

import com.example.hrm_demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
  Company findByName(String name);
}
