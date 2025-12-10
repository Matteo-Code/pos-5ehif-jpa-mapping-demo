package dev.mozgan.session1.dtos;

import dev.mozgan.session1.domain.InformationEvent;
import dev.mozgan.session1.domain.InformationEventType;
import jakarta.validation.constraints.NotNull;

public record InformationEventDto(InformationEventType eventType,
                                  String name,
                                  String roomInfo,
                                  int seats) {
}
