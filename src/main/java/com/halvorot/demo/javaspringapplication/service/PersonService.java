package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.enums.Gender;
import com.halvorot.demo.javaspringapplication.mappers.MapEntityToDto;
import com.halvorot.demo.javaspringapplication.repository.PersonRepository;
import com.halvorot.demo.javaspringapplication.specification.PersonSpecification;
import com.halvorot.demo.javaspringapplication.utils.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final Random random;

    public PersonService(final PersonRepository personRepository, final Random random) {
        this.personRepository = personRepository;
        this.random = random;
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
        PersonEntity personEntity = personRepository.save(
            new PersonEntity(
                String.format("%d", random.nextLong(999999999)),
                StringUtils.generateRandomString(6, random),
                StringUtils.generateRandomString(10, random),
                random.nextBoolean() ? Gender.FEMALE : Gender.MALE,
                random.nextInt(100)
            )
        );
        return MapEntityToDto.map(personEntity);
    }

}
