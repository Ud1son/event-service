package ru.udisondev.eventservice.service.command;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UpdateCommand {

    //@formatter:off
    @NotNull private final UUID id;
    @NotNull private final String title;
    private final UUID typeId;
    private final String city;
    private final String description;
    private final String place;
    private final LocalDateTime startTs;
    private final LocalDateTime endTs;
    //@formatter:on
}
