package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ConflictCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Primary Person ID is required")
    private Long primaryPersonId;

    // ADD THIS FIELD - The repository needs it to exist!
    @NotNull(message = "Secondary Person ID is required")
    private Long secondaryPersonId;

    @NotBlank(message = "Risk level must be specified")
    private String riskLevel;

    private String status = "OPEN";

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}