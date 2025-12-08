package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.InformationEventType;
import dev.mozgan.session1.domain.StudentIdentifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class StudentIdentifierConverterTest {

    private StudentIdentifierConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new StudentIdentifierConverter();
    }

    @Test
    public void convertToDatabaseColumn() {
        assertThat(converter.convertToDatabaseColumn(new StudentIdentifier("moz210568"))).isEqualTo("moz210568");
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    public void convertToEntityAttribute() {
        assertThat(converter.convertToEntityAttribute("moz210568")).isEqualTo(new StudentIdentifier("moz210568"));
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }

    @Test
    public void throwsInvalidCharacter() {
        assertThatThrownBy(() -> converter.convertToDatabaseColumn(new StudentIdentifier(null)))
                .hasMessageStartingWith("Identifier cannot be null")
                .isInstanceOf(IllegalArgumentException.class);
    }
}
