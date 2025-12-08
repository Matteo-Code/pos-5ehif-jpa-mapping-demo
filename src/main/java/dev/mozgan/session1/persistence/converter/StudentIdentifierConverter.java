package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.StudentIdentifier;
import dev.mozgan.session1.domain.TeacherIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StudentIdentifierConverter implements AttributeConverter<StudentIdentifier, String> {


    @Override
    public String convertToDatabaseColumn(StudentIdentifier studentIdentifier) {
        return studentIdentifier != null ? studentIdentifier.identifier() : null;
    }

    @Override
    public StudentIdentifier convertToEntityAttribute(String s) {
        return s != null ? new StudentIdentifier(s) : null;
    }
}
