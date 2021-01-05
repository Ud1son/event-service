package ru.udisondev.eventservice.entity;

import com.sun.istack.Nullable;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
public class Event {

    @Id
    private UUID id;

    @NonNull
    @Column(length = 64,
            nullable = false,
            unique = true)
    private UUID customerId;

    @NonNull
    @Column(length = 64,
            nullable = false)
    private String title;

    @NonNull
    @Column(length = 64,
            nullable = false)
    private UUID typeId;

    @NonNull
    @Column(length = 64,
            nullable = false)
    private String city;

    @Nullable
    @Column
    private String place;

    @NonNull
    @Column(length = 1024)
    private String description;

    @Nullable
    private LocalDateTime startTs;

    @Nullable
    private LocalDateTime endTs;

    private final LocalDateTime createTs = LocalDateTime.now();

}
