package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.Person;
import dev.mozgan.session1.domain.PersonRole;
import dev.mozgan.session1.domain.Student;
import dev.mozgan.session1.domain.StudentIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, PersonRole.PersonRoleId> {

    Optional<Student> findByStudentIdentifier(StudentIdentifier studentIdentifier);
}
