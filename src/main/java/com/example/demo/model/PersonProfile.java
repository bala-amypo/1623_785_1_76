package com.example.demo.model;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class PersonProfile{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String personType;
    private String referenceId;
    private String fullName;
    private String department;
    private Boolean relationshipDeclared;
    private LocalDateTime createdAt;
}
