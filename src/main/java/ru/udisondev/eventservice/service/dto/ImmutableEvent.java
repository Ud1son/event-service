package ru.udisondev.eventservice.service.dto;

import com.sun.istack.Nullable;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ImmutableEvent {

    @NotNull private final UUID id;
    @NotNull private final UUID customerId;
    @NotNull private String title;
    @NotNull private UUID typeId;
    @NotNull private String city;
    @Nullable private String place;
    @Nullable private String description;
    @Nullable private LocalDateTime startTs;
    @Nullable private LocalDateTime endTs;
}
