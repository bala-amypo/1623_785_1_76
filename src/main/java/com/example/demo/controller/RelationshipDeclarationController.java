package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService relService;

    public RelationshipDeclarationController(RelationshipDeclarationService relService) {
        this.relService = relService;
    }

    @PostMapping
    public RelationshipDeclaration declare(@RequestBody RelationshipDeclaration declaration) {
        return relService.declareRelationship(declaration);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> getByPerson(@PathVariable Long personId) {
        return relService.getDeclarationsByPerson(personId);
    }

    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verify(@PathVariable Long id, @RequestParam boolean verified) {
        return relService.verifyDeclaration(id, verified);
    }
}