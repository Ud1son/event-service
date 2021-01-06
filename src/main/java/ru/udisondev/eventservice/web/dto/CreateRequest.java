package ru.udisondev.eventservice.web.dto;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CreateRequest {

    //@formatter:off
    @NotNull private final UUID id;
    @NotNull private final UUID customerId;
    @Size(min = 2, max = 64, message = "title's length must be between 2 and 64 characters")
    @NotNull private final String title;
    @NotNull private final UUID typeId;
    @Size(min = 2, max = 64, message = "city's length must be between 2 and 64 characters")
    @NotNull private final String city;
    @NotNull private final LocalDateTime createTs;
    @Size(min = 20, max = 10000, message = "description's length must be between 20 and 100000 characters")
    @NotNull private final String description;
    private final String place;
    @FutureOrPresent(message = "startTs must not be in past")
    private final LocalDateTime startTs;
    @Future(message = "endTs must be in future")
    private final LocalDateTime endTs;
    //@formatter:on
}
