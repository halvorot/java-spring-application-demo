package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.repository.PersonRepository;
import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.enums.Gender;
import com.halvorot.demo.javaspringapplication.mappers.MapEntityToDto;

import org.springframework.stereotype.Service;

import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<PersonDto> getPersonByFirstName(final String firstName, final Pageable pageable) {
        return personRepository
            .findByFirstName(firstName, pageable)
            .map(MapEntityToDto::map);
    }

    public PersonEntity createPerson() {
        Random random = new Random();
        return personRepository.save(
            new PersonEntity(
                String.format("%d", random.nextInt(100)),
                String.format("%d", random.nextInt(100)),
                String.format("%d", random.nextInt(100)),
                random.nextBoolean() ? Gender.FEMALE : Gender.MALE
            )
        );
    }

}
