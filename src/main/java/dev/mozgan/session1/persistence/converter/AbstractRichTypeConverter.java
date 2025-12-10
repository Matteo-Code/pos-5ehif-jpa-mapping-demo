package dev.mozgan.session1.persistence.converter;

import dev.mozgan.session1.domain.RichType;
import jakarta.persistence.AttributeConverter;

import java.util.function.Function;

public abstract class AbstractRichTypeConverter<R extends RichType<T>, T> implements AttributeConverter<R, T> {

    private final Function<T,R> constructor;

    protected AbstractRichTypeConverter(Function<T,R> constructor) {this.constructor = constructor;}

    @Override
    public T convertToDatabaseColumn(R attribute) {
        return attribute != null ? attribute.value() : null;
    }

    @Override
    public R convertToEntityAttribute(T attribute) {
        return attribute != null ? constructor.apply(attribute) : null;
    }

}
