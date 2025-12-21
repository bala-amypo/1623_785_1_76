package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

// 2.2 RelationshipDeclaration
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RelationshipDeclaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long personId;
    private String relatedPersonName;
    private String relationshipType;
    private String description;
    private LocalDateTime declaredAt;
    private Boolean isVerified = false;
}

// 2.3 VendorEngagementRecord
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class VendorEngagementRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private Long vendorId;
    private String engagementType;
    private Double amount;
    private LocalDate engagementDate;
    private String notes;
}

// 2.4 ConflictCase
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ConflictCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long primaryPersonId;
    private Long secondaryPersonId;
    private String triggerSource;
    private String riskLevel;
    private String details;
    private String status = "OPEN";
    private LocalDateTime detectedAt;
}

// 2.5 ConflictFlag
@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ConflictFlag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long caseId;
    private String flagType;
    private String description;
    private String severity;
    private LocalDateTime flaggedAt;
}