package com.halvorot.demo.javaspringapplication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.halvorot.demo.javaspringapplication.entity.PersonEntity;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

    Page<PersonEntity> findByFirstName(final String firstName, final Pageable pageable);

    Optional<PersonEntity> findBySsn(final String ssn);

}
