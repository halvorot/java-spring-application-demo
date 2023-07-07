package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.repository.PersonRepository;
import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.mappers.MapEntityToDto;

import org.springframework.stereotype.Service;
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

}
