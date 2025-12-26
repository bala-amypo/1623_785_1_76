package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "conflict_cases")
public class ConflictCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long primaryPersonId;
    private Long secondaryPersonId;
    private String triggerSource;
    private String riskLevel;
    private String status = "OPEN";

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPrimaryPersonId() { return primaryPersonId; }
    public void setPrimaryPersonId(Long primaryPersonId) { this.primaryPersonId = primaryPersonId; }
    
    public Long getSecondaryPersonId() { return secondaryPersonId; }
    public void setSecondaryPersonId(Long secondaryPersonId) { this.secondaryPersonId = secondaryPersonId; }
    
    public String getTriggerSource() { return triggerSource; }
    public void setTriggerSource(String triggerSource) { this.triggerSource = triggerSource; }
    
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
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
// public class ConflictCase {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @NotNull(message = "Primary Person ID is required")
//     private Long primaryPersonId;

//     @NotNull(message = "Secondary Person ID is required")
//     private Long secondaryPersonId;

//     @NotBlank(message = "Risk level must be specified")
//     private String riskLevel;

//     private String status = "OPEN";

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