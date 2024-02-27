package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.enums.Gender;
import com.halvorot.demo.javaspringapplication.mappers.MapEntityToDto;
import com.halvorot.demo.javaspringapplication.repository.PersonRepository;
import com.halvorot.demo.javaspringapplication.specification.PersonSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<PersonDto> getAll(final Pageable pageable) {
        return personRepository
            .findAll(pageable)
            .map(MapEntityToDto::map);
    }

    public PersonDto getPersonBySsn(final String ssn) {
        PersonEntity personEntity = personRepository
            .findBySsn(ssn)
            .orElse(null);
        return MapEntityToDto.map(personEntity);
    }

    public Page<PersonDto> getPersonsByProperties(final String ssn, final String firstName, final String lastName, final Gender gender, final Pageable pageable) {
        return personRepository
            .findAll(
                PersonSpecification.filterByProperties(ssn, firstName, lastName, gender),
                pageable
            )
            .map(MapEntityToDto::map);
    }

    public PersonDto createRandomPerson() {
        Random random = new Random();
        PersonEntity personEntity = personRepository.save(
            new PersonEntity(
                String.format("%d", random.nextInt(100)),
                String.format("%d", random.nextInt(100)),
                String.format("%d", random.nextInt(100)),
                random.nextBoolean() ? Gender.FEMALE : Gender.MALE
            )
        );
        return MapEntityToDto.map(personEntity);
    }

}
