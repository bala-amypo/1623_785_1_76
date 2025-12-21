package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import com.example.demo.exception.ApiException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    // Constructor Injection (Mandatory for the test suite)
    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {
        if (person.getEmail() == null) {
            throw new ApiException("email is required");
        }
        if (person.getReferenceId() == null) {
            throw new ApiException("reference is required");
        }
        if (repo.findByEmail(person.getEmail()).isPresent()) {
            throw new ApiException("duplicate email");
        }
        if (repo.findByReferenceId(person.getReferenceId()).isPresent()) {
            throw new ApiException("duplicate reference");
        }

        person.setCreatedAt(LocalDateTime.now());
        person.setRelationshipDeclared(false);
        return repo.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("person not found"));
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repo.findAll();
    }

    @Override
    public PersonProfile findByReferenceId(String referenceId) {
        return repo.findByReferenceId(referenceId)
                .orElseThrow(() -> new ApiException("reference not found"));
    }

    @Override
    public PersonProfile updateRelationshipDeclared(Long id, boolean declared) {
        PersonProfile person = getPersonById(id);
        person.setRelationshipDeclared(declared);
        return repo.save(person);
    }
}