package dev.mozgan.session1.domain;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
public class EventTimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    private String slotTitle;

    private String slotDescription;

    private Date day;

    private Time startTime;

    private Time endTime;

    @OneToMany
    @JoinTable(name = "time_slots_students",
            foreignKey = @ForeignKey(name = "FK_time_slot_2_student"),
            inverseForeignKey = @ForeignKey(name = "FK_student_2_time_slot"),
            joinColumns = @JoinColumn(name = "time_slot_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;

    @OneToMany
    @JoinTable(name = "time_slots_teachers",
            foreignKey = @ForeignKey(name = "FK_time_slot_2_teacher"),
            inverseForeignKey = @ForeignKey(name = "FK_teacher_2_time_slot"),
            joinColumns = @JoinColumn(name = "time_slot_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher")
    )
    private Set<Teacher> teachers;
}
