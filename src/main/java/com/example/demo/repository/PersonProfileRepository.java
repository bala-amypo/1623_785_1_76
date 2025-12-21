package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonProfileRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personType;

    @Column(unique = true, nullable = false)
    private String referenceId;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    private String department;

    private Boolean relationshipDeclared = false;

    private LocalDateTime createdAt;
}
