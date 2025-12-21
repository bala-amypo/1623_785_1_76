package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/conflict-flags")
public class ConflictFlagController {

    private final ConflictFlagService flagService;

    public ConflictFlagController(ConflictFlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping
    public ConflictFlag add(@RequestBody ConflictFlag flag) {
        return flagService.addFlag(flag);
    }

    @GetMapping("/case/{caseId}")
    public List<ConflictFlag> getByCase(@PathVariable Long caseId) {
        return flagService.getFlagsByCase(caseId);
    }

    @GetMapping("/{id}")
    public ConflictFlag getById(@PathVariable Long id) {
        return flagService.getFlagById(id);
    }
}