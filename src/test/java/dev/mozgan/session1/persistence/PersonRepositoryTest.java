package dev.mozgan.session1.persistence;

import dev.mozgan.session1.Fixtures;
import dev.mozgan.session1.domain.Person;
import dev.mozgan.session1.persistence.converter.PersonSpecifications;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void canSaveAndFindPerson() {
        Person saved = personRepository.save(Fixtures.person());

        assertThat(saved).isNotNull();
        assertThat(saved.getPersonId()).isNotNull();

        Optional<Person> found = personRepository.findByPersonId(saved.getPersonId());

        assertThat(found.get()).isNotNull();
        assertThat(found.get().getFirstName()).isEqualTo(Fixtures.person().getFirstName());

    }

    @Test
    public void canFindPersonWithLastNameSchmidt() {
        personRepository.save(Fixtures.person());

        List<Person> schmidts = personRepository.findSchmidts();

        assertThat(schmidts.size()).isEqualTo(1);
        assertThat(schmidts.get(0).getLastName()).isEqualTo("Schmidt");
    }

    @Test
    void canFindPersonWithFirstNameBySpecification(){
        personRepository.save(Fixtures.person());

        List<Person> found = personRepository.findAll(PersonSpecifications.hasFirstName("Test"));

        assertThat(found.size()).isEqualTo(1);
    }

}
