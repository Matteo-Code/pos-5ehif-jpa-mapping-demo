package dev.mozgan.session1.dtos;

import dev.mozgan.session1.domain.InformationEventType;

public record InformationEventDto(InformationEventType eventType,
                                  String name,
                                  String roomInfo,
                                  int seats) {
}
