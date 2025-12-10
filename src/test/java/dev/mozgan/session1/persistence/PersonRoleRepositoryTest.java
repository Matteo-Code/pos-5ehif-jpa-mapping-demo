package dev.mozgan.session1.persistence;

import dev.mozgan.session1.Fixtures;
import dev.mozgan.session1.domain.Person;
import dev.mozgan.session1.domain.PersonRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonRoleRepositoryTest {

    @Autowired
    private PersonRoleRepository personRoleRepository;

    @Test
    public void canSaveAndFindPerson() {
        PersonRole saved = personRoleRepository.save(Fixtures.personRole());

        assertThat(saved).isNotNull();
        assertThat(saved.getPersonRoleId()).isNotNull();

        List<PersonRole> found = personRoleRepository.findAll();

        assertThat(found.size()).isEqualTo(1);
        assertThat(found.get(0).getPerson().getFirstName()).isEqualTo(Fixtures.person().getFirstName());

    }

}
