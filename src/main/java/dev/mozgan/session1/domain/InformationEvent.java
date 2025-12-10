package dev.mozgan.session1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class InformationEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Column(nullable = false)
    private InformationEventType eventType;

    @Column(nullable = false)
    private String name;

    private String description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "building", column = @Column(name = "room_building")),
            @AttributeOverride(name = "level", column = @Column(name = "room_level")),
            @AttributeOverride(name = "roomNo", column = @Column(name = "room_roomNo")),
            @AttributeOverride(name = "description", column = @Column(name = "room_description")),
            @AttributeOverride(name = "numberOfDesks", column = @Column(name = "room_numDesks")),
            @AttributeOverride(name = "numberOfSeats", column = @Column(name = "room_numSeats")),
    })
    private Room room;

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "information_event_id", foreignKey = @ForeignKey(name = "FK_slot_2_information_event"))
    private Set<EventTimeSlot> eventTimeSlots;

    @OneToMany(cascade =  {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "information_events_students",
            foreignKey = @ForeignKey(name = "FK_information_event_2_student"),
            inverseForeignKey = @ForeignKey(name = "FK_student_2_information_event"),
            joinColumns = @JoinColumn(name = "information_event_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;

    @OneToMany(cascade =  {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "information_events_teachers",
            foreignKey = @ForeignKey(name = "FK_information_event_2_teacher"),
            inverseForeignKey = @ForeignKey(name = "FK_teacher_2_information_event"),
            joinColumns = @JoinColumn(name = "information_event_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers;


}
