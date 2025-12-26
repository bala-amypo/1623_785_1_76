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
    private final PersonProfileRepository personRepository;

    public VendorEngagementServiceImpl(VendorEngagementRecordRepository repository, PersonProfileRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord record) {
        if (!personRepository.existsById(record.getEmployeeId())) {
            throw new ApiException("Employee not found");
        }
        if (!personRepository.existsById(record.getVendorId())) {
            throw new ApiException("Vendor not found");
        }
        if (engagement.getAmount() == null) {
    throw new ApiException("amount required");
}

if (engagement.getPerson() == null || engagement.getPerson().getId() == null) {
    throw new ApiException("person required");
}

if (engagement.getVendor() == null || engagement.getVendor().getId() == null) {
    throw new ApiException("vendor required");
}
if (repo.existsByPersonIdAndVendorId(
        engagement.getPerson().getId(),
        engagement.getVendor().getId())) {
    throw new ApiException("duplicate engagement");
}

        return repository.save(record);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(Long vendorId) {
        return repository.findByVendorId(vendorId);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return repository.findAll();
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