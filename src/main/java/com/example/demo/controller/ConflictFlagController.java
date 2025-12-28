package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flags")
public class ConflictFlagController {
    private final ConflictFlagService service;

    public ConflictFlagController(ConflictFlagService service) {
        this.service = service;
    }

    @PostMapping
    public ConflictFlag create(@RequestBody ConflictFlag flag) {
        return service.addFlag(flag);
    }
}


