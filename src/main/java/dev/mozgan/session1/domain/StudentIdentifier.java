package dev.mozgan.session1.domain;

import jakarta.validation.constraints.NotNull;

public record StudentIdentifier(@NotNull String identifier) {

    public StudentIdentifier {
        if(identifier == null) throw new IllegalArgumentException("Identifier cannot be null");
    }

}
