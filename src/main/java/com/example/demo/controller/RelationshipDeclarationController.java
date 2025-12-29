// package com.example.demo.controller;

// import com.example.demo.model.RelationshipDeclaration;
// import com.example.demo.service.RelationshipDeclarationService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/relationships")
// public class RelationshipDeclarationController {
//     private final RelationshipDeclarationService service;

//     public RelationshipDeclarationController(RelationshipDeclarationService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public RelationshipDeclaration create(@RequestBody RelationshipDeclaration declaration) {
//         return service.declareRelationship(declaration);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(RelationshipDeclarationService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public ResponseEntity<RelationshipDeclaration> create(
            @RequestBody RelationshipDeclaration declaration) {
        return ResponseEntity.ok(service.declareRelationship(declaration));
    }

    // PUT (verify)
    @PutMapping("/{id}/verify")
    public ResponseEntity<RelationshipDeclaration> verify(@PathVariable Long id,
                                                          @RequestParam Boolean verified) {
        return ResponseEntity.ok(service.verifyDeclaration(id, verified));
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<RelationshipDeclaration>> getAll() {
        return ResponseEntity.ok(service.getAllDeclarations());
    }
}

