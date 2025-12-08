package dev.mozgan.session1.domain;

import lombok.Builder;

public class PresentationRoom extends Room {

    @Builder(builderMethodName = "presentationRoomBuilder")
    public PresentationRoom(String building,
                        String level,
                        String roomNo,
                        String description,
                        int numberOfDesks,
                        int numberOfSeats) {
        super(building, level, roomNo, description, numberOfDesks, numberOfSeats);
    }


}
