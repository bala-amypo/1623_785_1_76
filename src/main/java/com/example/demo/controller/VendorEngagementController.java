package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/engagements")
public class VendorEngagementController {
    private final VendorEngagementService service;

    public VendorEngagementController(VendorEngagementService service) {
        this.service = service;
    }

    @PostMapping
    public VendorEngagementRecord create(@RequestBody VendorEngagementRecord record) {
        return service.addEngagement(record);
    }
}



