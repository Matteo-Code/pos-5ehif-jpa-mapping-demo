package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.TeacherIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.function.Function;

@Converter(autoApply = true)
public class TeacherIdentifierConverter extends AbstractRichTypeConverter<TeacherIdentifier, String> {

    protected TeacherIdentifierConverter() {
        super(TeacherIdentifier::new);
    }
}
