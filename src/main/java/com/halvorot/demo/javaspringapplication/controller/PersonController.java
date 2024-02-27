package com.halvorot.demo.javaspringapplication.controller;

import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.enums.Gender;
import com.halvorot.demo.javaspringapplication.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private final PersonService personService;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<Page<PersonDto>> getPersonsByProperties(
        @RequestParam(required = false) String ssn,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) Gender gender,
        @RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "15") Integer pageSize,
        @RequestParam(defaultValue = "lastName") String sortBy
    ) {
        Page<PersonDto> persons = personService.getPersonsByProperties(
            ssn,
            firstName,
            lastName,
            gender,
            PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending())
        );
        return ResponseEntity.ok(persons);
    }

    @PostMapping("/persons/create-random")
    public ResponseEntity<PersonDto> createPerson() {
        return ResponseEntity.ok(personService.createRandomPerson());
    }

}
