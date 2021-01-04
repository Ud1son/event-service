package ru.udisondev.eventservice.service.dto;

import com.sun.istack.Nullable;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class EventDetails {

    @NotNull private UUID customerId;
    @Nullable private UUID id;
    @Nullable private String title;
    @Nullable private UUID typeId;
    @Nullable private String city;
    @Nullable private String place;
    @Nullable private String description;
    @Nullable private LocalDateTime startTs;
    @Nullable private LocalDateTime endTs;
}
