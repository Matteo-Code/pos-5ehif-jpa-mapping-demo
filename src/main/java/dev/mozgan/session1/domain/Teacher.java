package dev.mozgan.session1.domain;

import dev.mozgan.session1.persistence.converter.TeacherIdentifierConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Teacher extends PersonRole{

    @Column(unique = true, nullable = false)
    @Convert(converter = TeacherIdentifierConverter.class)
    private TeacherIdentifier teacherIdentifier;

}
