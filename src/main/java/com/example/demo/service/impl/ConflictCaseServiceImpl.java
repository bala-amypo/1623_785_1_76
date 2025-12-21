package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository caseRepo;
    private final PersonProfileRepository personRepo;

    public ConflictCaseServiceImpl(ConflictCaseRepository caseRepo, PersonProfileRepository personRepo) {
        this.caseRepo = caseRepo;
        this.personRepo = personRepo;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        if (!personRepo.existsById(conflictCase.getPrimaryPersonId())) {
            throw new ApiException("primary person not found");
        }
        return caseRepo.save(conflictCase);
    }

    @Override
    public ConflictCase updateCaseStatus(Long caseId, String status) {
        ConflictCase c = getCaseById(caseId);
        c.setStatus(status);
        return caseRepo.save(c);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return caseRepo.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public ConflictCase getCaseById(Long id) {
        return caseRepo.findById(id)
                .orElseThrow(() -> new ApiException("case not found"));
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return caseRepo.findAll();
    }
}