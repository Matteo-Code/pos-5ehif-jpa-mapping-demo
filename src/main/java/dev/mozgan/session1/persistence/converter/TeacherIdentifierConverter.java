package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.TeacherIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TeacherIdentifierConverter implements AttributeConverter<TeacherIdentifier, String> {


    @Override
    public String convertToDatabaseColumn(TeacherIdentifier teacherIdentifier) {
        return teacherIdentifier != null ? teacherIdentifier.identifier() : null;
    }

    @Override
    public TeacherIdentifier convertToEntityAttribute(String s) {
        return s != null ? new TeacherIdentifier(s) : null;
    }
}
