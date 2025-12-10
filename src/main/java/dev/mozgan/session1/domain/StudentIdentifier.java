package dev.mozgan.session1.domain;

import jakarta.validation.constraints.NotNull;

public record StudentIdentifier(@NotNull String value) implements RichType<String> {

    public StudentIdentifier {
        if(value == null) throw new IllegalArgumentException("Identifier cannot be null");
    }

}
