package dev.mozgan.session1;

import dev.mozgan.session1.domain.*;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Date;

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

    public static EventTimeSlot eventTimeSlot(){
        return EventTimeSlot.builder()
                .day(new Date())
                .startTime(new Time(System.currentTimeMillis()))
                .endTime(new Time(System.currentTimeMillis() + 1000))
                .slotTitle("Test")
                .slotDescription("Test description")
                .build();
    }

    public static Person person(){
        return Person.builder()
                .firstName("Test")
                .lastName("Schmidt")
                .dateOfBirth(new Date()).build();
    }

    public static Student student(){
        return Student.builder()
                .person(person())
                .studentIdentifier(new StudentIdentifier("test"))
                .build();
    }

    public static Teacher teacher(){
        return Teacher.builder()
                .person(person())
                .teacherIdentifier(new TeacherIdentifier("test"))
                .build();
    }

    public static PersonRole personRole(){
        return PersonRole.builder()
                .person(person())
                .build();
    }

}
