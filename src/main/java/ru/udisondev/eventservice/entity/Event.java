package ru.udisondev.eventservice.entity;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@Entity
public class Event {

    //@formatter:off
    @Id
    @NotNull private final UUID id;
    @Column(length = 36, nullable = false)
    @NotNull private final UUID customerId;
    @Column(length = 64, nullable = false)
    @NotNull private final String title;
    @Column(length = 36, nullable = false)
    @NotNull private final UUID typeId;
    @Column(length = 64, nullable = false)
    @NotNull private final String city;
    @Column(length = 10000, nullable = false)
    @NotNull private final String description;
    @Column(updatable = false)
    @NotNull private final LocalDateTime createTs;
    @Column(length = 64)
    @Nullable private final String place;
    @Column @Nullable private final LocalDate startDate;
    @Column @Nullable private final LocalTime startTime;
    @Column @Nullable private final LocalDate endDate;
    @Column @Nullable private final LocalTime endTime;
    //@formatter:on

    public static EventBuilder newEvent() {
        return new EventBuilder();
    }


    public static class EventBuilder {
        private UUID id;
        private UUID customerId;
        private String title;
        private UUID typeId;
        private String city;
        private String description;
        private String place;
        private LocalDate startDate;
        private LocalTime startTime;
        private LocalDate endDate;
        private LocalTime endTime;

        private EventBuilder() {
        }

        public EventBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public EventBuilder withCustomerId(UUID customerId) {
            this.customerId = customerId;
            return this;
        }

        public EventBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public EventBuilder withTypeId(UUID typeId) {
            this.typeId = typeId;
            return this;
        }

        public EventBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public EventBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public EventBuilder withPlace(String place) {
            this.place = place;
            return this;
        }

        public EventBuilder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public EventBuilder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public EventBuilder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public EventBuilder withEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Event build() {
            //@formatter:off
            if (title == null) throw new IllegalStateException("title must not be null");
            if (description == null) throw new IllegalStateException("description must not be null");
            if (id == null) throw new IllegalStateException("id must not be null");
            if (city == null) throw new IllegalStateException("city must not be null");
            if (customerId == null) throw new IllegalStateException("customerId must not be null");
            if (typeId == null) throw new IllegalStateException("typeId must not be null");
            if (title.length() < 2) throw new IllegalStateException("title's length must be greater than 2 characters");
            if (title.length() > 64) throw new IllegalStateException("title's length must be less than 64 characters");
            if (description.length() < 20) throw new IllegalStateException("description's length must be greater than 20 characters");
            if (description.length() > 10000) throw new IllegalStateException("description's length must be less than 10000 characters");
            if (city.isBlank()) throw new IllegalStateException("city must not be blank");
            if (city.length() < 2) throw new IllegalStateException("city's length must be greater than 2 characters");
            if (city.length() > 64) throw new IllegalStateException("city's length must be less than 64 characters");
            if (startDate != null) {
                if (startDate.isBefore(LocalDate.now())) throw new IllegalStateException("startDate must be in future");
                if (startDate.isEqual(LocalDate.now())) throw new IllegalStateException("startDate must be in future");
            }
            if (endDate != null) {
                if (endDate.isBefore(LocalDate.now())) throw new IllegalStateException("endDate must be in future");
                if (endDate.isEqual(LocalDate.now())) throw new IllegalStateException("endDate must be in future");
            }
            //@formatter:on

            return new Event(
                    id,
                    customerId,
                    title,
                    typeId,
                    city,
                    description,
                    LocalDateTime.now(),
                    place,
                    startDate,
                    startTime,
                    endDate,
                    endTime);
        }
    }
}
