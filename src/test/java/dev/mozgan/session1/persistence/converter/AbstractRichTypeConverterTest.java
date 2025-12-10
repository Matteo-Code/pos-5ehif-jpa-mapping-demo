package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.RichType;
import dev.mozgan.session1.domain.StudentIdentifier;
import dev.mozgan.session1.domain.TeacherIdentifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class AbstractRichTypeConverterTest {


    @ParameterizedTest
    @MethodSource("converterConfigs")
    public <R extends RichType<T>, T> void convertToDatabaseColumn(AbstractRichTypeConverter<R,T> converter, T ignore) {
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }

    @ParameterizedTest
    @MethodSource("converterConfigs")
    public <R extends RichType<T>, T> void convertToEntityAttribute(AbstractRichTypeConverter<R,T> converter, T value) {
        var converted = converter.convertToEntityAttribute(value);
        assertThat(converted).isNotNull();
        assertThat(converter.convertToDatabaseColumn(converted)).isEqualTo(value);
    }

    private static Stream<Arguments> converterConfigs() {
        return Stream.of(
                Arguments.of(new StudentIdentifierConverter(), "test"),
                        Arguments.of(new TeacherIdentifierConverter(), "test"));
    }
}
