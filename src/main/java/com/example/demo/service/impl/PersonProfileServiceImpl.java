package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.model.PersonProfile;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.service.PersonProfileService;
import com.example.demo.exception.ApiException;
import java.util.List;

@Service
public class PersonProfileServiceImpl implements PersonProfileService {

    private final PersonProfileRepository repo;

    public PersonProfileServiceImpl(PersonProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public PersonProfile createPerson(PersonProfile person) {
        if (repo.existsByEmail(person.getEmail())) {
            throw new ApiException("duplicate email");
        }
        if (repo.existsByReferenceId(person.getReferenceId())) {
            throw new ApiException("duplicate reference");
        }
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