package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.Person;
import org.springframework.data.jpa.domain.Specification;

public class PersonSpecifications {

    public static Specification<Person> hasFirstName(String name) {
        return (person, cq, cb) -> cb.equal(person.get("firstName"), name);
    }
}
