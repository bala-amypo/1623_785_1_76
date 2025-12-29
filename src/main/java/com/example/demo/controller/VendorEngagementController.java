// package com.example.demo.controller;

// import com.example.demo.model.VendorEngagementRecord;
// import com.example.demo.service.VendorEngagementService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/engagements")
// public class VendorEngagementController {
//     private final VendorEngagementService service;

//     public VendorEngagementController(VendorEngagementService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public VendorEngagementRecord create(@RequestBody VendorEngagementRecord record) {
//         return service.addEngagement(record);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engagements")
public class VendorEngagementController {

    private final VendorEngagementService service;

    public VendorEngagementController(VendorEngagementService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public ResponseEntity<VendorEngagementRecord> create(
            @RequestBody VendorEngagementRecord record) {
        return ResponseEntity.ok(service.addEngagement(record));
    }

    // GET by employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<VendorEngagementRecord>> getByEmployee(
            @PathVariable Long employeeId) {
        return ResponseEntity.ok(service.getEngagementsByEmployee(employeeId));
    }

    // GET by vendor
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<VendorEngagementRecord>> getByVendor(
            @PathVariable Long vendorId) {
        return ResponseEntity.ok(service.getEngagementsByVendor(vendorId));
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<VendorEngagementRecord>> getAll() {
        return ResponseEntity.ok(service.getAllEngagements());
    }
}

