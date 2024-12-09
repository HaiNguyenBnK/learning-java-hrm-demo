package com.example.hrm_demo.model;

import jakarta.persistence.*;   // For JPA annotations
import lombok.*;              // For Lombok annotations

@Entity   // Marks this class as an entity to be mapped to a database table
@Table(name = "employees")   // Optional: Defines the name of the table in the database
@Data     // Lombok annotation for generating getters, setters, toString(), equals(), hashcode()
@NoArgsConstructor  // Lombok annotation to generate a no-args constructor
@AllArgsConstructor // Lombok annotation to generate an all-args constructor
@Builder            // Lombok annotation to implement the builder pattern
public class Employee {

  @Id  // Marks this field as the primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates a unique ID
  private Long id;

  @Column(nullable = false)  // Makes the 'name' field non-nullable in the database
  private String name;

  @Column(nullable = false)
  private String department;

  @Column(nullable = false)
  private double salary;

  @Column(nullable = false)
  private EmployeeRole role; // company role

  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "company_id", nullable = false)
  private Company company;

}
