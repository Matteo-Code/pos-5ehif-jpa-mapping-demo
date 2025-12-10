package dev.mozgan.session1.domain;

import jakarta.validation.constraints.NotNull;

public record TeacherIdentifier(@NotNull String value) implements RichType<String> {

    public TeacherIdentifier {
        if(value == null) throw new IllegalArgumentException("Identifier cannot be null");
    }

}
