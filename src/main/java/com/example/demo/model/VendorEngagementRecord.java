package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vendor_engagements")
public class VendorEngagementRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long employeeId;

    @Column(nullable = false)
    private Long vendorId;

    private String engagementType;

    private Double amount;

    private LocalDate engagementDate;

    // -------- getters / setters --------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getEngagementType() {
        return engagementType;
    }

    public void setEngagementType(String engagementType) {
        this.engagementType = engagementType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getEngagementDate() {
        return engagementDate;
    }

    public void setEngagementDate(LocalDate engagementDate) {
        this.engagementDate = engagementDate;
    }
}


// package com.example.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import lombok.Getter;
// import lombok.Setter;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;
// import java.time.LocalDate;

// @Entity
// @Getter @Setter @NoArgsConstructor @AllArgsConstructor
// public class VendorEngagementRecord {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private Long employeeId;
//     private Long vendorId;
//     private String engagementType;
//     private Double amount;
//     private LocalDate engagementDate;
//     private String notes;
// }