package dev.mozgan.session1.persistence;

import dev.mozgan.session1.Fixtures;
import dev.mozgan.session1.domain.EventTimeSlot;
import dev.mozgan.session1.domain.InformationEvent;
import dev.mozgan.session1.domain.PresentationRoom;
import dev.mozgan.session1.dtos.InformationEventDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EventTimeSlotRepositoryTest {

    @Autowired
    private EventTimeSlotRepository eventTimeSlotRepository;

    @Test
    public void canSaveAndFindTimeSlot() {
        EventTimeSlot saved = eventTimeSlotRepository.save(Fixtures.eventTimeSlot());

        assertThat(saved).isNotNull();
        assertThat(saved.getSlotTitle()).isEqualTo(Fixtures.eventTimeSlot().getSlotTitle());
    }

}
