package ru.udisondev.eventservice.service.command;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

/**
 * This class encapsulate information about updating event for next working of {@code EventService}
 */
@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateCommand {

    //@formatter:off
    @NotNull private final UUID id;
    @NotNull private final UUID customerId;
    private final String title;
    private final UUID typeId;
    private final String city;
    private final String description;
    private final String place;
    private final LocalDate startDate;
    private final LocalTime startTime;
    private final LocalDate endDate;
    private final LocalTime endTime;
    //@formatter:on

    /**
     * The method is implementation of Builder pattern.
     * @return
     */
    public static UpdateCommandBuilder newUpdateCommand() {
        return new UpdateCommandBuilder();
    }


    /**
     * The builder for UpdateCommand has private constructor.
     * Use {@code newUpdateCommand} for creation instance of the builder
     * Use {@code build()} for creation instance of the UpdateCommand.
     */
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class UpdateCommandBuilder {

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

        public UpdateCommandBuilder withId(UUID id) {
            this.id = id;
            return this;
        }

        public UpdateCommandBuilder withCustomerId(UUID customerId) {
            this.customerId = customerId;
            return this;
        }

        public UpdateCommandBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public UpdateCommandBuilder withTypeId(UUID typeId) {
            this.typeId = typeId;
            return this;
        }

        public UpdateCommandBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public UpdateCommandBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateCommandBuilder withPlace(String place) {
            this.place = place;
            return this;
        }

        public UpdateCommandBuilder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public UpdateCommandBuilder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public UpdateCommandBuilder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public UpdateCommandBuilder withEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        /**
         * @return new instance of UpdateCommand.
         * @throws IllegalStateException if {@code id} or {@code customerId} is null.
         */
        public UpdateCommand build() {
            if (id == null) throw new IllegalStateException("id must not be null!");
            if (customerId == null) throw new IllegalStateException("customerId must not be null!");
            if (title != null) {
                if (title.length() < 2) throw new IllegalStateException("title must be greater than 2 characters");
                if (title.length() > 64) throw new IllegalStateException("title must be less than 64 characters");
            }
            if (description != null) {
                if (description.length() < 20) throw new IllegalStateException("description must be greater than 20 characters");
                if (description.length() > 10000) throw new IllegalStateException("description must be less than 10000 characters");
            }
            if (city != null) {
                if (city.isBlank()) throw new IllegalStateException("city must not be blank");
                if (city.length() < 2) throw new IllegalStateException("city's length must be greater than 2 characters");
                if (city.length() > 64) throw new IllegalStateException("city's length must be less than 64 characters");
            }
            if (startDate != null) {
                if (startDate.isBefore(LocalDate.now())) throw new IllegalStateException("startDate must be in future");
                if (startDate.isEqual(LocalDate.now())) throw new IllegalStateException("startDate must be in future");
            }
            if (endDate != null) {
                if (endDate.isBefore(LocalDate.now())) throw new IllegalStateException("endDate must be in future");
                if (endDate.isEqual(LocalDate.now())) throw new IllegalStateException("endDate must be in future");
            }

            return new UpdateCommand(
                    id,
                    customerId,
                    title,
                    typeId,
                    city,
                    description,
                    place,
                    startDate,
                    startTime,
                    endDate,
                    endTime);
        }
    }
}
