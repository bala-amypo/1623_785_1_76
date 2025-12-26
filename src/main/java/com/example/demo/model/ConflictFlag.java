package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "conflict_flags")
public class ConflictFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long caseId;
    private String flagType;
    private String severity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getCaseId() { return caseId; }
    public void setCaseId(Long caseId) { this.caseId = caseId; }
    
    public String getFlagType() { return flagType; }
    public void setFlagType(String flagType) { this.flagType = flagType; }
    
    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }
}


// package com.example.demo.model;

// import jakarta.persistence.*;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import lombok.Data;
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;
// import java.time.LocalDateTime;

// @Entity
// @Data @AllArgsConstructor @NoArgsConstructor
// public class ConflictFlag {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotNull(message = "Case ID is required")
//     private Long caseId;

//     /*
//     @OneToOne
//     @JoinColumn(name = "case_id", insertable = false, updatable = false)
//     private ConflictCase conflictCase;
//     */

//     @NotBlank(message = "Flag type is mandatory")
//     private String flagType;

//     @NotBlank(message = "Severity is required")
//     private String severity;

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