package ru.udisondev.eventservice.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.util.Assert;
import ru.udisondev.eventservice.entity.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ImmutableEvent {

    //@formatter:off
    @NotNull private final UUID id;
    @NotNull private final UUID customerId;
    @NotNull private final String title;
    @NotNull private final UUID typeId;
    @NotNull private final String city;
    @NotNull private final LocalDateTime createTs;
    @NotNull private final String description;
    @Nullable private final String place;
    @Nullable private final LocalDate startDate;
    @Nullable private final LocalTime startTime;
    @Nullable private final LocalDate endDate;
    @Nullable private final LocalTime endTime;
    //@formatter:on

    public static ImmutableEvent newInstance(Event event) {
        Assert.notNull(event, "Event must not be null");

        return new ImmutableEvent(
                event.getId(),
                event.getCustomerId(),
                event.getTitle(),
                event.getTypeId(),
                event.getCity(),
                event.getCreateTs(),
                event.getDescription(),
                event.getPlace(),
                event.getStartDate(),
                event.getStartTime(),
                event.getEndDate(),
                event.getEndTime());
    }
}
