package dev.mozgan.session1.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Room {

    private String building;

    private String level;

    private String roomNo;

    private String description;

    private int numberOfDesks;

    private int numberOfSeats;

}
