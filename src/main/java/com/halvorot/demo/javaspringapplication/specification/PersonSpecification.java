package com.halvorot.demo.javaspringapplication.specification;

import com.halvorot.demo.javaspringapplication.entity.PersonEntity;
import com.halvorot.demo.javaspringapplication.enums.Gender;
import jakarta.annotation.Nullable;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PersonSpecification {

    private PersonSpecification() {
        // Hide default constructor
    }

    public static Specification<PersonEntity> filterByProperties(
        @Nullable final String ssn,
        @Nullable final String firstName,
        @Nullable final String lastName,
        @Nullable final Gender gender
    ) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (ssn != null) {
                predicates.add(builder.equal(root.get("ssn"), ssn));
            }
            if (firstName != null) {
                predicates.add(builder.equal(root.get("firstName"), firstName));
            }
            if (lastName != null) {
                predicates.add(builder.equal(root.get("lastName"), lastName));
            }
            if (gender != null) {
                predicates.add(builder.equal(root.get("gender"), gender));
            }
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
