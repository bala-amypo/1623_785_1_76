package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import java.util.List;
import jakarta.validation.Valid;

@RestController
public class PersonProfileController {

    private final PersonProfileService service;

    // Constructor Injection
    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    @PostMapping("/person")
    public PersonProfile createPerson(@Valid @RequestBody PersonProfile person) {
        return service.createPerson(person);
    }

    @GetMapping("/person/{id}")
    public PersonProfile getPerson(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @GetMapping("/persons")
    public List<PersonProfile> getAllPersons() {
        return service.getAllPersons();
    }

    @PutMapping("/person/{id}/relationship")
    public PersonProfile updateRelationship(
            @PathVariable Long id,
            @RequestParam boolean declared) {
        return service.updateRelationshipDeclared(id, declared);
    }
}