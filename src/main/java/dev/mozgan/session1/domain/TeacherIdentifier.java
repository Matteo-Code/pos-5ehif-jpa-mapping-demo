package dev.mozgan.session1.domain;

import jakarta.validation.constraints.NotNull;

public record TeacherIdentifier(@NotNull String identifier) {

    public TeacherIdentifier {
        if(identifier == null) throw new IllegalArgumentException("Identifier cannot be null");
    }

}
