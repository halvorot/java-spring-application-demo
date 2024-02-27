package com.halvorot.demo.javaspringapplication.entity;

import com.halvorot.demo.javaspringapplication.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "PERSON")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SSN", nullable = false, unique = true)
    private String ssn;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "GENDER")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public PersonEntity(
        final String ssn,
        final String firstName,
        final String lastName,
        final Gender gender
    ) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

}