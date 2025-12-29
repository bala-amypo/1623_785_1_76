// package com.example.demo.controller;

// import com.example.demo.model.ConflictCase;
// import com.example.demo.service.ConflictCaseService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/cases")
// public class ConflictCaseController {
//     private final ConflictCaseService service;

//     public ConflictCaseController(ConflictCaseService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ConflictCase create(@RequestBody ConflictCase conflictCase) {
//         return service.createCase(conflictCase);
//     }
// }

package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cases")
public class ConflictCaseController {

    private final ConflictCaseService service;

    public ConflictCaseController(ConflictCaseService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public ResponseEntity<ConflictCase> create(@RequestBody ConflictCase conflictCase) {
        return ResponseEntity.ok(service.createCase(conflictCase));
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<ConflictCase> getById(@PathVariable Long id) {
        Optional<ConflictCase> data = service.getCaseById(id);
        return data.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<ConflictCase>> getAll() {
        return ResponseEntity.ok(service.getAllCases());
    }

    // PUT (update status)
    @PutMapping("/{id}/status")
    public ResponseEntity<ConflictCase> updateStatus(@PathVariable Long id,
                                                     @RequestParam String status) {
        return ResponseEntity.ok(service.updateCaseStatus(id, status));
    }

    // GET by person
    @GetMapping("/person/{personId}")
    public ResponseEntity<List<ConflictCase>> getByPerson(@PathVariable Long personId) {
        return ResponseEntity.ok(service.getCasesByPerson(personId));
    }
}




