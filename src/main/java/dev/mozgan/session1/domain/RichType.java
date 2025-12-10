package dev.mozgan.session1.domain;

public interface RichType<T> {

    T value();

    default T value(T defaultValue) {
        return value();
    }
}
