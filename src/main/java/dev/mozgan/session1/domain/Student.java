package dev.mozgan.session1.domain;

import dev.mozgan.session1.persistence.converter.StudentIdentifierConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class Student extends PersonRole{

    @Column(unique = true, nullable = false)
    @Convert(converter = StudentIdentifierConverter.class)
    private StudentIdentifier studentIdentifier;

}
