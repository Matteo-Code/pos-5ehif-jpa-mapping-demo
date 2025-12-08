package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Student, Long> {

}
