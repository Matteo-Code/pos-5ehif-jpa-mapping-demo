package dev.mozgan.session1.persistence;

import dev.mozgan.session1.Fixtures;
import dev.mozgan.session1.domain.Person;
import dev.mozgan.session1.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void canSaveAndFindStudent() {
        Student saved = studentRepository.save(Fixtures.student());

        assertThat(saved).isNotNull();
        assertThat(saved.getPerson()).isNotNull();

        Optional<Student> found = studentRepository.findByStudentIdentifier(Fixtures.student().getStudentIdentifier());

        assertThat(found.get()).isNotNull();
        assertThat(found.get().getPerson().getFirstName()).isEqualTo(Fixtures.person().getFirstName());

    }

}
