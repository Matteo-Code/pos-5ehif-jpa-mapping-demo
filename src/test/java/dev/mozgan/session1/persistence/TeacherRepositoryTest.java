package dev.mozgan.session1.persistence;

import dev.mozgan.session1.Fixtures;
import dev.mozgan.session1.domain.Student;
import dev.mozgan.session1.domain.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void canSaveAndFindStudent() {
        Teacher saved = teacherRepository.save(Fixtures.teacher());

        assertThat(saved).isNotNull();
        assertThat(saved.getPerson()).isNotNull();

        Optional<Teacher> found = teacherRepository.findByTeacherIdentifier(Fixtures.teacher().getTeacherIdentifier());

        assertThat(found.get()).isNotNull();
        assertThat(found.get().getPerson().getFirstName()).isEqualTo(Fixtures.person().getFirstName());

    }

}
