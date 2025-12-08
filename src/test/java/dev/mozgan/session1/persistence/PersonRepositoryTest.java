package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void canSaveAndFindPerson() {
        Person person = Person.builder()
                .firstName("Test")
                .lastName("Doe")
                .dateOfBirth(new Date()).build();
        Person saved = personRepository.save(person);

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();

        Optional<Person> found = personRepository.findById(saved.getId());

        assertThat(found.get()).isNotNull();
        assertThat(found.get().getFirstName()).isEqualTo(person.getFirstName());

    }

}
