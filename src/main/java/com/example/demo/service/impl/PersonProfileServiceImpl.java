package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {
    private final PersonProfileRepository repository;

    public PersonProfileServiceImpl(PersonProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {
        if (person.getEmail() == null || person.getEmail().trim().isEmpty()) {
            throw new ApiException("Email is required");
        }
        if (repository.findByEmail(person.getEmail()).isPresent()) {
            throw new ApiException("Email already exists");
        }
        if (repository.findByReferenceId(person.getReferenceId()).isPresent()) {
            throw new ApiException("Reference ID already exists");
        }
        return repository.save(person);
    }

    @Override
    public PersonProfile getPersonById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ApiException("Person not found"));
    }

    @Override
    public PersonProfile updateRelationshipDeclared(Long id, Boolean declared) {
        PersonProfile person = getPersonById(id);
        person.setRelationshipDeclared(declared);
        return repository.save(person);
    }

    @Override
    public List<PersonProfile> getAllPersons() {
        return repository.findAll();
    }

    @Override
    public Optional<PersonProfile> findByReferenceId(String referenceId) {
        return repository.findByReferenceId(referenceId);
    }
}


