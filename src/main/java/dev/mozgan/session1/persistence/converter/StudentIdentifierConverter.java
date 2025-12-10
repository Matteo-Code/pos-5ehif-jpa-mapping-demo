package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.StudentIdentifier;
import dev.mozgan.session1.domain.TeacherIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.function.Function;

@Converter(autoApply = true)
public class StudentIdentifierConverter extends AbstractRichTypeConverter<StudentIdentifier, String> {

    protected StudentIdentifierConverter() {
        super(StudentIdentifier::new);
    }
}
