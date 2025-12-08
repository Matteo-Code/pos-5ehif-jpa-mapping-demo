package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.Person;
import dev.mozgan.session1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
