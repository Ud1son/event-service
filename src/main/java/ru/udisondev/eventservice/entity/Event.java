package ru.udisondev.eventservice.entity;

import com.sun.istack.Nullable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class Event {

    @Id
    private UUID id;

    @NotNull
    @Column(length = 64,
            nullable = false,
            unique = true)
    private UUID customerId;

    @NotNull
    @Column(length = 64,
            nullable = false)
    private String title;

    @NotNull
    @Column(length = 64,
            nullable = false)
    private UUID typeId;

    @NotNull
    @Column(length = 64,
            nullable = false)
    private String city;

    @Nullable
    @Column
    private String place;

    @Nullable
    @Column(length = 1024)
    private String description;

    @Nullable
    private LocalDateTime startTs;

    @Nullable
    private LocalDateTime endTs;

    private LocalDateTime createTs;

}
