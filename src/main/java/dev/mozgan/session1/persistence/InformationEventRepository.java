package dev.mozgan.session1.persistence;

import dev.mozgan.session1.domain.EventTimeSlot;
import dev.mozgan.session1.domain.InformationEvent;
import dev.mozgan.session1.domain.Person;
import dev.mozgan.session1.dtos.InformationEventDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InformationEventRepository extends JpaRepository<InformationEvent, Long> {

    @Query("select i.eventType, i.name, concat(i.room.building, i.room.level, '.', i.room.roomNo) as roomInfo, i.room.numberOfSeats as seats from InformationEvent i")
    List<InformationEventDto> findAllProjected();

    @Query("select i from InformationEvent i where i.room.level = :level")
    List<InformationEvent> findAllByRoomLevel(@Param("level") String level);

}
