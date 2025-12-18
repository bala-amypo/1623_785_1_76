package com.example.demo.model;


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