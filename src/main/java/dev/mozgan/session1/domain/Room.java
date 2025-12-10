package dev.mozgan.session1.domain;

import jakarta.persistence.Column;
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

    @Column(nullable = false)
    private String building;

    @Column(nullable = false)
    private String level;

    @Column(nullable = false)
    private String roomNo;

    private String description;

    @Column(nullable = false)
    private int numberOfDesks;

    @Column(nullable = false)
    private int numberOfSeats;

}
