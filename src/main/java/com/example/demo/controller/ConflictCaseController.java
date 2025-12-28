package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cases")
public class ConflictCaseController {
    private final ConflictCaseService service;

    public ConflictCaseController(ConflictCaseService service) {
        this.service = service;
    }

    @PostMapping
    public ConflictCase create(@RequestBody ConflictCase conflictCase) {
        return service.createCase(conflictCase);
    }
}





