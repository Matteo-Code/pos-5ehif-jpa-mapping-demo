package dev.mozgan.session1.domain;

import lombok.Builder;

public class MakerSpaceRoom extends Room {

    private String specialEquipment;

    @Builder(builderMethodName = "makerSpaceRoomBuilder")
    public MakerSpaceRoom(String building,
                        String level,
                        String roomNo,
                        String description,
                        int numberOfDesks,
                        int numberOfSeats,
                          String specialEquipment) {
        super(building, level, roomNo, description, numberOfDesks, numberOfSeats);
        this.specialEquipment = specialEquipment;
    }


}
