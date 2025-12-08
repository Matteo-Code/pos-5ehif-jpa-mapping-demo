package dev.mozgan.session1.domain;

import lombok.Builder;

public class Meetingpoint extends Room {

    @Builder(builderMethodName = "meetingpointBuilder")
    public Meetingpoint(String building,
                        String level,
                        String roomNo,
                        String description,
                        int numberOfDesks,
                        int numberOfSeats) {
        super(building, level, roomNo, description, numberOfDesks, numberOfSeats);
    }

}
