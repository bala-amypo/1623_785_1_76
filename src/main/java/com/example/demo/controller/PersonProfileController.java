package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PersonProfile;
import com.example.demo.service.PersonProfileService;

import java.util.List;

@RestController
public class PersonProfileController {

    @Autowired
    PersonProfileService service;

    @PostMapping("/person")
    public PersonProfile createPerson(@RequestBody PersonProfile person) {
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
