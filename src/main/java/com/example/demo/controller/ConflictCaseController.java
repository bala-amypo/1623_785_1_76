// package com.example.demo.controller;

// import com.example.demo.model.ConflictCase;
// import com.example.demo.service.ConflictCaseService;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import java.util.List;
// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/api/conflict-cases")
// public class ConflictCaseController {

//     private final ConflictCaseService caseService;

//     public ConflictCaseController(ConflictCaseService caseService) {
//         this.caseService = caseService;
//     }

//     @PostMapping
//     public ConflictCase create(@Valid @RequestBody ConflictCase conflictCase) {
//         return caseService.createCase(conflictCase);
//     }

//     @PutMapping("/{id}/status")
//     public ConflictCase updateStatus(@PathVariable Long id, @RequestParam String status) {
//         return caseService.updateCaseStatus(id, status);
//     }

//     @GetMapping("/person/{personId}")
//     public List<ConflictCase> getByPerson(@PathVariable Long personId) {
//         return caseService.getCasesByPerson(personId);
//     }

//     @GetMapping("/{id}")
//     public ConflictCase getById(@PathVariable Long id) {
//         return caseService.getCaseById(id);
//     }
// }