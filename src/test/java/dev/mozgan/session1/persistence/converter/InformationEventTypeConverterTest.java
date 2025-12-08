package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.InformationEventType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
public class InformationEventTypeConverterTest {

    private InformationEventTypeConverter converter;

    @BeforeEach
    public void setUp() {
        converter = new InformationEventTypeConverter();
    }

    @Test
    public void convertToDatabaseColumn() {
        assertThat(converter.convertToDatabaseColumn(InformationEventType.PRESENTATION)).isEqualTo('P');
        assertThat(converter.convertToDatabaseColumn(InformationEventType.GUIDED_TOUR)).isEqualTo('G');
        assertThat(converter.convertToDatabaseColumn(InformationEventType.MAKER_SPACE)).isEqualTo('M');
        assertThat(converter.convertToDatabaseColumn(null)).isNull();
    }

    @Test
    public void convertToEntityAttribute() {
        assertThat(converter.convertToEntityAttribute('P')).isEqualTo(InformationEventType.PRESENTATION);
        assertThat(converter.convertToEntityAttribute('G')).isEqualTo(InformationEventType.GUIDED_TOUR);
        assertThat(converter.convertToEntityAttribute('M')).isEqualTo(InformationEventType.MAKER_SPACE);
        assertThat(converter.convertToEntityAttribute(null)).isNull();
    }

    @Test
    public void throwsInvalidCharacter() {
        assertThatThrownBy(() -> converter.convertToEntityAttribute('X'))
                .hasMessage("Unknown information event type: 'X'");
    }
}
