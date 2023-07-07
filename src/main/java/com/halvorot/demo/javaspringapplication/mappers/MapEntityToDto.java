package com.halvorot.demo.javaspringapplication.mappers;

import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.dto.PersonDto;


public class MapEntityToDto {
    
    private MapEntityToDto() {
        // Hide default constructor
    }

    public static PersonDto map(final PersonEntity personEntity) {
        return new PersonDto(
            personEntity.getSsn(),
            personEntity.getFirstName(),
            personEntity.getLastName(),
            personEntity.getGender()
        );
    }
}
