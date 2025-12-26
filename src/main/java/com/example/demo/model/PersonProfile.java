package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "person_profiles")
public class PersonProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = true, nullable = false)
    private String referenceId;
    
    @Column(nullable = false)
    private String personType;
    
    private String fullName;
    private String department;
    private Boolean relationshipDeclared = false;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getReferenceId() { return referenceId; }
    public void setReferenceId(String referenceId) { this.referenceId = referenceId; }
    
    public String getPersonType() { return personType; }
    public void setPersonType(String personType) { this.personType = personType; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public Boolean getRelationshipDeclared() { return relationshipDeclared; }
    public void setRelationshipDeclared(Boolean relationshipDeclared) { this.relationshipDeclared = relationshipDeclared; }
}

// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.PreUpdate;
// import jakarta.validation.constraints.Email;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import java.time.LocalDateTime;

// @Entity
// @Data @AllArgsConstructor @NoArgsConstructor
// public class PersonProfile {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotBlank(message = "Reference ID is mandatory")
//     private String referenceId;

//     @NotBlank(message = "Full name is required")
//     @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
//     private String fullName;

//     @Email(message = "Email format is invalid")
//     @NotBlank(message = "Email is required")
//     private String email;

//     private boolean relationshipDeclared = false;

//     private LocalDateTime createdAt;
//     private LocalDateTime updatedAt;

//     @PrePersist
//     public void onCreate() {
//         this.createdAt = LocalDateTime.now();
//         this.updatedAt = LocalDateTime.now();
//     }

//     @PreUpdate
//     public void onUpdate() {
//         this.updatedAt = LocalDateTime.now();
//     }
// }