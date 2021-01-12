package ru.udisondev.eventservice.service.command;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateCommand {

    //@formatter:off
    @NotNull private final UUID customerId;
    @NotNull private final String title;
    @NotNull private final UUID typeId;
    @NotNull private final String city;
    @NotNull private final String description;
    @Nullable private final String place;
    @Nullable private final LocalDate startDate;
    @Nullable private final LocalTime startTime;
    @Nullable private final LocalDate endDate;
    @Nullable private final LocalTime endTime;
    //@formatter:on

    public static CreateCommandBuilder newCreateCommand() {
        return new CreateCommandBuilder();
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class CreateCommandBuilder {
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

        public CreateCommandBuilder withCustomerId(UUID customerId) {
            this.customerId = customerId;
            return this;
        }

        public CreateCommandBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateCommandBuilder withTypeId(UUID typeId) {
            this.typeId = typeId;
            return this;
        }

        public CreateCommandBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public CreateCommandBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateCommandBuilder withPlace(String place) {
            this.place = place;
            return this;
        }

        public CreateCommandBuilder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public CreateCommandBuilder withStartTime(LocalTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public CreateCommandBuilder withEndDate(LocalDate endDate) {
            this.endDate = endDate;
            return this;
        }

        public CreateCommandBuilder withEndTime(LocalTime endTime) {
            this.endTime = endTime;
            return this;
        }

        @NotNull
        public CreateCommand build() {
            if (title == null) throw new IllegalStateException("title must not be null");
            if (description == null) throw new IllegalStateException("description must not be null");
            if (city == null) throw new IllegalStateException("city must not be null");
            if (customerId == null) throw new IllegalStateException("customerId must not be null");
            if (typeId == null) throw new IllegalStateException("typeId must not be null");
            if (title.length() < 2)
                throw new IllegalStateException("title's length must be greater than 2 characters");
            if (title.length() > 64)
                throw new IllegalStateException("title's length must be less than 64 characters");
            if (description.length() < 20)
                throw new IllegalStateException("description's length must be greater than 20 characters");
            if (description.length() > 10000)
                throw new IllegalStateException("description's length must be less than 10000 characters");
            if (city.isBlank()) throw new IllegalStateException("city must not be blank");
            if (city.length() < 2)
                throw new IllegalStateException("city's length must be greater than 2 characters");
            if (this.city.length() > 64)
                throw new IllegalStateException("city's length must be less than 64 characters");
            if (startDate != null) {
                if (startDate.isBefore(LocalDate.now()) || startDate.isEqual(LocalDate.now()))
                    throw new IllegalStateException("startDate must be in future");
            }
            if (endDate != null) {
                if (endDate.isBefore(LocalDate.now()) || endDate.isEqual(LocalDate.now()))
                    throw new IllegalStateException("startDate must be in future");
            }

            return new CreateCommand(
                    customerId,
                    title,
                    typeId,
                    city,
                    description,
                    place,
                    startDate,
                    startTime,
                    endDate,
                    endTime
            );
        }
    }
}
