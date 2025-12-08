package dev.mozgan.session1;

import dev.mozgan.session1.domain.InformationEvent;
import dev.mozgan.session1.domain.InformationEventType;
import dev.mozgan.session1.domain.PresentationRoom;

public class Fixtures {

    public static PresentationRoom presentationRoom(){
        return  PresentationRoom.presentationRoomBuilder()
                .building("C")
                .level("1")
                .roomNo("14")
                .description("description")
                .numberOfDesks(5)
                .numberOfSeats(10)
                .build();
    }

    public static InformationEvent informationEvent(){
        return InformationEvent.builder()
                .eventType(InformationEventType.PRESENTATION)
                .room(presentationRoom())
                .name("Test")
                .description("description")
                .build();
    }

}
