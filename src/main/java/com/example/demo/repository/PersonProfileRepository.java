package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.PersonProfile;
import java.util.Optional;

public interface PersonProfileRepository 
        extends JpaRepository<PersonProfile, Long> {

    Optional<PersonProfile> findByEmail(String email);

    Optional<PersonProfile> findByReferenceId(String referenceId);
}
