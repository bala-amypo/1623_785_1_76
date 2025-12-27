package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.service.VendorEngagementService;

import java.util.List;
@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    private final VendorEngagementRecordRepository engagementRepo;
    private final PersonProfileRepository personRepo;

    public VendorEngagementServiceImpl(
            VendorEngagementRecordRepository engagementRepo,
            PersonProfileRepository personRepo) {
        this.engagementRepo = engagementRepo;
        this.personRepo = personRepo;
    }

    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {

        if (record == null) {
            throw new ApiException("Engagement record is required");
        }

        // Validate employee
        PersonProfile employee = personRepo.findById(record.getEmployeeId())
                .orElseThrow(() -> new ApiException("Employee not found"));

        if (!"EMPLOYEE".equalsIgnoreCase(employee.getPersonType())) {
            throw new ApiException("Person is not an employee");
        }

        // Validate vendor
        PersonProfile vendor = personRepo.findById(record.getVendorId())
                .orElseThrow(() -> new ApiException("Vendor not found"));

        if (!"VENDOR".equalsIgnoreCase(vendor.getPersonType())) {
            throw new ApiException("Person is not a vendor");
        }

        return engagementRepo.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
        return engagementRepo.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
        return engagementRepo.findByVendorId(vendorId);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return engagementRepo.findAll();
    }
}
