package com.halvorot.demo.javaspringapplication.service;

import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.enums.Gender;
import com.halvorot.demo.javaspringapplication.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PersonServiceTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void should_get_all_persons() {

        // Arrange
        PersonEntity personEntity1 = new PersonEntity(
            "ssn",
            "firstName",
            "lastName",
            Gender.MALE,
            20
        );
        PersonEntity personEntity2 = new PersonEntity(
            "ssn2",
            "firstName2",
            "lastName2",
            Gender.FEMALE,
            30
        );
        personRepository.save(personEntity1);
        personRepository.save(personEntity2);

        PersonService personService = new PersonService(personRepository);

        // Act
        Page<PersonDto> allPersonsPage = personService.getAll(Pageable.unpaged());

        // Assert
        List<PersonDto> allPersons = allPersonsPage.getContent();
        assertThat(allPersons)
            .hasSize(2)
            .anySatisfy(personDto -> {
                    assertThat(personDto.ssn()).isEqualTo("ssn");
                    assertThat(personDto.firstName()).isEqualTo("firstName");
                    assertThat(personDto.lastName()).isEqualTo("lastName");
                    assertThat(personDto.gender()).isEqualTo(Gender.MALE);
                }
            )
            .anySatisfy(personDto -> {
                    assertThat(personDto.ssn()).isEqualTo("ssn2");
                    assertThat(personDto.firstName()).isEqualTo("firstName2");
                    assertThat(personDto.lastName()).isEqualTo("lastName2");
                    assertThat(personDto.gender()).isEqualTo(Gender.FEMALE);
                }
            );

    }

    @Test
    public void should_return_person_dto_with_valid_ssn() {

        // Arrange
        String ssn = "123456789";
        PersonEntity personEntity = new PersonEntity(ssn, "firstName", "lastName", Gender.MALE, 20);
        personRepository.save(personEntity);

        PersonService personService = new PersonService(personRepository);

        // Act
        PersonDto result = personService.getPersonBySsn(ssn);

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.ssn()).isEqualTo(ssn);
        assertThat(result.firstName()).isEqualTo("firstName");
        assertThat(result.lastName()).isEqualTo("lastName");
        assertThat(result.gender()).isEqualTo(Gender.MALE);

    }

    @Test
    public void should_return_null_when_no_persons_in_db() {

        // Arrange
        PersonService personService = new PersonService(personRepository);

        // Act
        PersonDto result = personService.getPersonBySsn("ssn");

        // Assert
        assertThat(result).isNull();

    }

}