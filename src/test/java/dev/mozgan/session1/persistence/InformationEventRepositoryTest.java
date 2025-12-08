package dev.mozgan.session1.persistence;

import dev.mozgan.session1.Fixtures;
import dev.mozgan.session1.domain.*;
import dev.mozgan.session1.dtos.InformationEventDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class InformationEventRepositoryTest {

    @Autowired
    private InformationEventRepository informationEventRepository;

    @Test
    public void canSaveAndFindPerson() {
        InformationEvent saved = informationEventRepository.save(Fixtures.informationEvent());

        assertThat(saved).isNotNull();
        assertThat(saved.getEventType()).isEqualTo(Fixtures.informationEvent().getEventType());
        assertThat(saved.getRoom()).isInstanceOf(PresentationRoom.class);
        assertThat(saved.getRoom()).isEqualTo(Fixtures.presentationRoom());
    }

    @Test
    public void canFindByLevel() {
        informationEventRepository.save(Fixtures.informationEvent());

        List<InformationEvent> found = informationEventRepository.findAllByRoomLevel("1");
        List<InformationEvent> foundNone = informationEventRepository.findAllByRoomLevel("2");
        assertThat(found).hasSize(1);
        assertThat(foundNone).hasSize(0);
    }

    @Test
    public void canFindProjection() {
        informationEventRepository.save(Fixtures.informationEvent());

        List<InformationEventDto> found = informationEventRepository.findAllProjected();
        assertThat(found).hasSize(1);
        assertThat(found.get(0).seats()).isEqualTo(Fixtures.informationEvent().getRoom().getNumberOfSeats());
        assertThat(found.get(0).roomInfo()).isEqualTo(Fixtures.informationEvent().getRoom().getBuilding() +
                Fixtures.informationEvent().getRoom().getLevel() +
                "." +
                Fixtures.informationEvent().getRoom().getRoomNo());
    }

}
