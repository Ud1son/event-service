package ru.udisondev.eventservice.service.dto;

import com.sun.istack.Nullable;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ImmutableEvent {

    @NotNull private final UUID id;
    @NotNull private final UUID customerId;
    @NotNull private final String title;
    @NotNull private final UUID typeId;
    @NotNull private final String city;
    @NotNull private final LocalDateTime createTs;
    @Nullable private final String place;
    @Nullable private final String description;
    @Nullable private final LocalDateTime startTs;
    @Nullable private final LocalDateTime endTs;
}
