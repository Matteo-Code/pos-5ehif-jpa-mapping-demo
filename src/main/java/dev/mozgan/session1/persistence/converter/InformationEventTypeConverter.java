package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.InformationEventType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class InformationEventTypeConverter implements AttributeConverter<InformationEventType, Character> {

    @Override
    public Character convertToDatabaseColumn(InformationEventType attribute) {
        return switch (attribute) {
            case GUIDED_TOUR -> 'G';
            case MAKER_SPACE -> 'M';
            case PRESENTATION -> 'P';
            case null -> null;
        };
    }

    @Override
    public InformationEventType convertToEntityAttribute(Character dbData) {
        return switch (dbData) {
            case 'G' -> InformationEventType.GUIDED_TOUR;
            case 'M' -> InformationEventType.MAKER_SPACE;
            case 'P' -> InformationEventType.PRESENTATION;
            case null -> null;
            default -> throw new IllegalArgumentException("Unknown information event type: '%c'".formatted(dbData));
        };
    }

}
