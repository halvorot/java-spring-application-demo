package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.enums.Gender;
import com.halvorot.demo.javaspringapplication.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class DemoServiceTest {
    
    @Mock
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
        Page<PersonDto> personDto = personService.getPersonByFirstName("firstName", Pageable.unpaged());

        // Assert
        assertThat(personDto.ssn()).isEqualTo(personEntity.getSsn());
        assertThat(personDto.firstName()).isEqualTo(personEntity.getFirstName());
        assertThat(personDto.lastName()).isEqualTo(personEntity.getLastName());
        assertThat(personDto.gender()).isEqualTo(personEntity.getGender());

    }

}