// package com.example.demo.controller;

// import com.example.demo.model.PersonProfile;
// import com.example.demo.service.PersonProfileService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/persons")
// public class PersonProfileController {
//     private final PersonProfileService service;

//     public PersonProfileController(PersonProfileService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ResponseEntity<PersonProfile> create(@RequestBody PersonProfile person) {
//         PersonProfile created = service.createPerson(person);
//         return ResponseEntity.ok(created);
//     }

//     @GetMapping("/lookup/{referenceId}")
//     public ResponseEntity<PersonProfile> lookup(@PathVariable String referenceId) {
//         Optional<PersonProfile> person = service.findByReferenceId(referenceId);
//         return person.map(ResponseEntity::ok)
//                     .orElse(ResponseEntity.notFound().build());
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public ResponseEntity<PersonProfile> create(@RequestBody PersonProfile person) {
        return ResponseEntity.ok(service.createPerson(person));
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<PersonProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getPersonById(id));
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<PersonProfile>> getAll() {
        return ResponseEntity.ok(service.getAllPersons());
    }

    // PUT (update relationship declared)
    @PutMapping("/{id}/relationship-declared")
    public ResponseEntity<PersonProfile> updateDeclared(@PathVariable Long id,
                                                         @RequestParam Boolean declared) {
        return ResponseEntity.ok(service.updateRelationshipDeclared(id, declared));
    }

    // EXISTING lookup
    @GetMapping("/lookup/{referenceId}")
    public ResponseEntity<PersonProfile> lookup(@PathVariable String referenceId) {
        Optional<PersonProfile> person = service.findByReferenceId(referenceId);
        return person.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
}


