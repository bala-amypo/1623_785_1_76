package com.example.demo.repository;

import com.example.demo.model.VendorEngagementRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface VendorEngagementRecordRepository extends JpaRepository<VendorEngagementRecord, Long> {
    // List<VendorEngagementRecord> findByEmployeeId(Long employeeId);
    // List<VendorEngagementRecord> findByVendorId(Long vendorId);



    VendorEngagementRecord save(VendorEngagementRecord record);

    List<VendorEngagementRecord> findByEmployeeId(Long employeeId);

    List<VendorEngagementRecord> findByVendorId(Long vendorId);

    List<VendorEngagementRecord> findAll();
}



// package com.example.demo.repository;

// import com.example.demo.model.VendorEngagementRecord;
// import org.springframework.data.jpa.repository.JpaRepository;
// import java.util.List;

// public interface VendorEngagementRecordRepository extends JpaRepository<VendorEngagementRecord, Long> {

//     List<VendorEngagementRecord> findByEmployeeId(Long id);

//     List<VendorEngagementRecord> findByVendorId(Long id);
// }