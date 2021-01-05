package ru.udisondev.eventservice.service.dto;

import com.sun.istack.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ImmutableEvent {

    @NonNull private final UUID id;
    @NonNull private final UUID customerId;
    @NonNull private final String title;
    @NonNull private final UUID typeId;
    @NonNull private final String city;
    @NonNull private final LocalDateTime createTs;
    @NonNull private final String description;
    @Nullable private final String place;
    @Nullable private final LocalDateTime startTs;
    @Nullable private final LocalDateTime endTs;
}
