package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.service.VendorEngagementService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VendorEngagementServiceImpl implements VendorEngagementService {

    private final VendorEngagementRecordRepository repository;

    public VendorEngagementServiceImpl(VendorEngagementRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public VendorEngagementRecord addVendorEngagement(VendorEngagementRecord vendorEngagement) {

        // 🔽 PUT ALL VALIDATIONS HERE (INSIDE THIS METHOD)

        if (vendorEngagement.getAmount() == null) {
            throw new ApiException("amount required");
        }

        if (vendorEngagement.getPerson() == null ||
            vendorEngagement.getPerson().getId() == null) {
            throw new ApiException("person required");
        }

        if (vendorEngagement.getVendor() == null ||
            vendorEngagement.getVendor().getId() == null) {
            throw new ApiException("vendor required");
        }

        if (repository.existsByPersonIdAndVendorId(
                vendorEngagement.getPerson().getId(),
                vendorEngagement.getVendor().getId())) {
            throw new ApiException("duplicate engagement");
        }

        // 🔽 SAVE AT THE END
        return repository.save(vendorEngagement);
    }
}



// package com.example.demo.service.impl;

// import com.example.demo.exception.ApiException;
// import com.example.demo.model.VendorEngagementRecord;
// import com.example.demo.repository.PersonProfileRepository;
// import com.example.demo.repository.VendorEngagementRecordRepository;
// import com.example.demo.service.VendorEngagementService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class VendorEngagementServiceImpl implements VendorEngagementService {

//     private final VendorEngagementRecordRepository engagementRepo;
//     private final PersonProfileRepository personRepo;

//     public VendorEngagementServiceImpl(VendorEngagementRecordRepository engagementRepo, 
//                                        PersonProfileRepository personRepo) {
//         this.engagementRepo = engagementRepo;
//         this.personRepo = personRepo;
//     }

//     @Override
//     public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {
//         if (!personRepo.existsById(record.getEmployeeId()) || !personRepo.existsById(record.getVendorId())) {
//             throw new ApiException("person not found for engagement");
//         }
//         return engagementRepo.save(record);
//     }

//     @Override
//     public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
//         return engagementRepo.findByEmployeeId(employeeId);
//     }

//     @Override
//     public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
//         return engagementRepo.findByVendorId(vendorId);
//     }

//     @Override
//     public List<VendorEngagementRecord> getAllEngagements() {
//         return engagementRepo.findAll();
//     }
// }