package dev.mozgan.session1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class EventTimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    private String slotTitle;

    private String slotDescription;

    @Column(name = "slot_day", nullable = false)
    private Date day;

    @Column(nullable = false)
    private Time startTime;

    @Column(nullable = false)
    private Time endTime;

    @OneToMany(cascade =  {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "time_slots_students",
            foreignKey = @ForeignKey(name = "FK_time_slot_2_student"),
            inverseForeignKey = @ForeignKey(name = "FK_student_2_time_slot"),
            joinColumns = @JoinColumn(name = "time_slot_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;

    @OneToMany(cascade =  {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "time_slots_teachers",
            foreignKey = @ForeignKey(name = "FK_time_slot_2_teacher"),
            inverseForeignKey = @ForeignKey(name = "FK_teacher_2_time_slot"),
            joinColumns = @JoinColumn(name = "time_slot_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher")
    )
    private Set<Teacher> teachers;
}
