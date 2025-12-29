// package com.example.demo.controller;

// import com.example.demo.model.ConflictFlag;
// import com.example.demo.service.ConflictFlagService;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/flags")
// public class ConflictFlagController {
//     private final ConflictFlagService service;

//     public ConflictFlagController(ConflictFlagService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public ConflictFlag create(@RequestBody ConflictFlag flag) {
//         return service.addFlag(flag);
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.ConflictFlagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flags")
public class ConflictFlagController {

    private final ConflictFlagService service;

    public ConflictFlagController(ConflictFlagService service) {
        this.service = service;
    }

    // POST
    @PostMapping
    public ResponseEntity<ConflictFlag> create(@RequestBody ConflictFlag flag) {
        return ResponseEntity.ok(service.addFlag(flag));
    }

    // GET by ID
    @GetMapping("/{id}")
    public ResponseEntity<ConflictFlag> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getFlagById(id));
    }

    // GET by case
    @GetMapping("/case/{caseId}")
    public ResponseEntity<List<ConflictFlag>> getByCase(@PathVariable Long caseId) {
        return ResponseEntity.ok(service.getFlagsByCase(caseId));
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<ConflictFlag>> getAll() {
        return ResponseEntity.ok(service.getAllFlags());
    }
}
