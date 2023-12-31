package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.enums.Gender;
import com.halvorot.demo.javaspringapplication.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class PersonServiceTest {
    
    @Autowired
    private PersonRepository personRepository;

    @Test
    void should_get_persons_by_first_name() {
        // Arrange
        PersonEntity personEntity = new PersonEntity(
            "ssn", 
            "firstName",
            "lastName",
            Gender.MALE
        );
        PersonEntity personEntity2 = new PersonEntity(
            "ssn2", 
            "firstName2",
            "lastName2",
            Gender.FEMALE
        );
        personRepository.save(personEntity);
        personRepository.save(personEntity2);

        PersonService personService = new PersonService(personRepository);

        // Act
        Page<PersonDto> personPage = personService.getPersonByFirstName("firstName", Pageable.unpaged());

        // Assert
        List<PersonDto> personDtos = personPage.getContent();
        assertThat(personDtos).hasSize(1);
        assertThat(personDtos.get(0).ssn()).isEqualTo(personEntity.getSsn());
        assertThat(personDtos.get(0).firstName()).isEqualTo(personEntity.getFirstName());
        assertThat(personDtos.get(0).lastName()).isEqualTo(personEntity.getLastName());
        assertThat(personDtos.get(0).gender()).isEqualTo(personEntity.getGender());

    }

}