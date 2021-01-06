package ru.udisondev.eventservice.service.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.udisondev.eventservice.entity.Event;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.springframework.util.Assert.notNull;

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
    @Nullable private final LocalDateTime startTs;
    @Nullable private final LocalDateTime endTs;
    //@formatter:on

    public static ImmutableEvent newInstance(Event event) {
        notNull(event, "event must not be null");
        notNull(event.getId(), "id must not be null");
        notNull(event.getCustomerId(), "customerId must not be null");
        notNull(event.getTitle(), "title must not be null");
        notNull(event.getTypeId(), "typeId must not be null");
        notNull(event.getCity(), "city must not be null");
        notNull(event.getCreateTs(), "createTs must not be null");
        notNull(event.getDescription(), "description must not be null");

        return new ImmutableEvent(
                event.getId(),
                event.getCustomerId(),
                event.getTitle(),
                event.getTypeId(),
                event.getCity(),
                event.getCreateTs(),
                event.getDescription(),
                event.getPlace(),
                event.getStartTs(),
                event.getEndTs());
    }
}
