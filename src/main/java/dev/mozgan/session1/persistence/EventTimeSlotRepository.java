package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.EventTimeSlot;
import dev.mozgan.session1.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTimeSlotRepository extends JpaRepository<EventTimeSlot, Long> {

}
