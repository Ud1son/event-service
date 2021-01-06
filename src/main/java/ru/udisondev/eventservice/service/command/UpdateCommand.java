package ru.udisondev.eventservice.service.command;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UpdateCommand {

    //@formatter:off
    @NotNull private final UUID id;
    @NotNull private final String title;
    @NotNull private final UUID typeId;
    @NotNull private final String city;
    @NotNull private final String description;
    @Nullable private final String place;
    @Nullable private final LocalDateTime startTs;
    @Nullable private final LocalDateTime endTs;
    //@formatter:on
}
