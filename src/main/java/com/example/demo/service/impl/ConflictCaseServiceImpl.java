package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {
    private final ConflictCaseRepository repository;
    private final ConflictFlagRepository flagRepository;

    public ConflictCaseServiceImpl(ConflictCaseRepository repository, ConflictFlagRepository flagRepository) {
        this.repository = repository;
        this.flagRepository = flagRepository;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        if (conflictCase.getStatus() == null) {
            conflictCase.setStatus("OPEN");
        }
        return repository.save(conflictCase);
    }

    @Override
    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase conflictCase = repository.findById(id)
            .orElseThrow(() -> new ApiException("Case not found"));
        conflictCase.setStatus(status);
        return repository.save(conflictCase);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repository.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repository.findAll();
    }

    @Override
    public Optional<ConflictCase> getCaseById(Long id) {
        return repository.findById(id);
    }
}



// package com.example.demo.service.impl;

// import com.example.demo.exception.ApiException;
// import com.example.demo.model.ConflictCase;
// import com.example.demo.repository.ConflictCaseRepository;
// import com.example.demo.repository.PersonProfileRepository;
// import com.example.demo.service.ConflictCaseService;
// import org.springframework.stereotype.Service;
// import java.util.List;

// @Service
// public class ConflictCaseServiceImpl implements ConflictCaseService {

//     private final ConflictCaseRepository caseRepo;
//     private final PersonProfileRepository personRepo;

//     public ConflictCaseServiceImpl(ConflictCaseRepository caseRepo, PersonProfileRepository personRepo) {
//         this.caseRepo = caseRepo;
//         this.personRepo = personRepo;
//     }

//     @Override
//     public ConflictCase createCase(ConflictCase conflictCase) {
//         if (!personRepo.existsById(conflictCase.getPrimaryPersonId())) {
//             throw new ApiException("primary person not found");
//         }
//         return caseRepo.save(conflictCase);
//     }

//     @Override
//     public ConflictCase updateCaseStatus(Long caseId, String status) {
//         ConflictCase c = getCaseById(caseId);
//         c.setStatus(status);
//         return caseRepo.save(c);
//     }

//     @Override
//     public List<ConflictCase> getCasesByPerson(Long personId) {
//         return caseRepo.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
//     }

//     @Override
//     public ConflictCase getCaseById(Long id) {
//         return caseRepo.findById(id)
//                 .orElseThrow(() -> new ApiException("case not found"));
//     }

//     @Override
//     public List<ConflictCase> getAllCases() {
//         return caseRepo.findAll();
//     }
// }