// package com.example.demo.service.impl;

// import com.example.demo.exception.ApiException;
// import com.example.demo.model.RelationshipDeclaration;
// import com.example.demo.repository.PersonProfileRepository;
// import com.example.demo.repository.RelationshipDeclarationRepository;
// import com.example.demo.service.RelationshipDeclarationService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService {

//     private final RelationshipDeclarationRepository relRepo;
//     private final PersonProfileRepository personRepo;

//     public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository relRepo, 
//                                              PersonProfileRepository personRepo) {
//         this.relRepo = relRepo;
//         this.personRepo = personRepo;
//     }

//     @Override
//     public RelationshipDeclaration declareRelationship(RelationshipDeclaration declaration) {
//         personRepo.findById(declaration.getPersonId())
//                 .orElseThrow(() -> new ApiException("person missing for declaration"));
//         return relRepo.save(declaration);
//     }

//     @Override
//     public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
//         return relRepo.findAll(); 
//     }

//     @Override
//     public RelationshipDeclaration verifyDeclaration(Long declarationId, boolean verified) {
//         RelationshipDeclaration decl = relRepo.findById(declarationId)
//                 .orElseThrow(() -> new ApiException("declaration not found"));
//         decl.setVerified(verified);
//         return relRepo.save(decl);
//     }

//     @Override
//     public List<RelationshipDeclaration> getAllDeclarations() {
//         return relRepo.findAll();
//     }
// }