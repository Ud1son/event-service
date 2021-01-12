package ru.udisondev.eventservice.web.dto;

import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
public class UpdateRequest {

    //@formatter:off
    @NotNull private final UUID id;
    @NotNull private final UUID customerId;
    @Size(min = 2, max = 64, message = "Title's length must be between 2 and 64 characters")
    private final String title;
    private final UUID typeId;
    @Size(min = 2, max = 64, message = "City's length must be between 2 and 64 characters")
    private final String city;
    @Size(min = 20, max = 10000, message = "Description's length must be between 20 and 100000 characters")
    private final String description;
    private final String place;
    @Future(message = "Start date must be in future")
    private final LocalDate startDate;
    private final LocalTime startTime;
    @Future(message = "End date must be in future")
    private final LocalDate endDate;
    private final LocalTime endTime;
    //@formatter:on

}
