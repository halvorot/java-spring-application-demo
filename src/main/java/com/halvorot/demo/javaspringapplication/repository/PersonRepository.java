package com.halvorot.demo.javaspringapplication.repository;

import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long>, JpaSpecificationExecutor<PersonEntity> {

    Optional<PersonEntity> findBySsn(final String ssn);

}
