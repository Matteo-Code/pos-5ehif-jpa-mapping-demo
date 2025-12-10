package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.PersonRole;
import dev.mozgan.session1.domain.Student;
import dev.mozgan.session1.domain.Teacher;
import dev.mozgan.session1.domain.TeacherIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, PersonRole.PersonRoleId> {

    Optional<Teacher> findByTeacherIdentifier(TeacherIdentifier teacherIdentifier);
}
