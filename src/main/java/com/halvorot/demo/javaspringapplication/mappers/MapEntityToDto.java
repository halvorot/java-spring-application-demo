package com.halvorot.demo.javaspringapplication.mappers;

import com.halvorot.demo.javaspringapplication.dto.PersonDto;
import com.halvorot.demo.javaspringapplication.entity.PersonEntity;


public class MapEntityToDto {

    private MapEntityToDto() {
        // Hide default constructor
    }

    public static PersonDto map(final PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }
        return new PersonDto(
            personEntity.getSsn(),
            personEntity.getFirstName(),
            personEntity.getLastName(),
            personEntity.getGender()
        );
    }
}
