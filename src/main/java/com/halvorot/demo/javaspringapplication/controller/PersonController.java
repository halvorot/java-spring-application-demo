package com.halvorot.demo.javaspringapplication.controller;

import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.service.PersonService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<Page<PersonDto>> getData(
        @RequestParam String firstName,
        @RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "15") Integer pageSize
    ) {
        Page<PersonDto> persons = personService.getPersonByFirstName(
            firstName,
            PageRequest.of(pageNo, pageSize, Sort.by("lastName").ascending())
        );
        return ResponseEntity.ok(persons);
    }

    @PostMapping("/persons/insert/random")
    public ResponseEntity<PersonEntity> createPerson() {
        return ResponseEntity.ok(personService.createPerson());
    }

}
