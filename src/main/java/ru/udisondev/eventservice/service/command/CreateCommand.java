package ru.udisondev.eventservice.service.command;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
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
    @Nullable private final LocalDateTime startTs;
    @Nullable private final LocalDateTime endTs;
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
        private LocalDateTime startTs;
        private LocalDateTime endTs;

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

        public CreateCommandBuilder withStartTs(LocalDateTime startTs) {
            this.startTs = startTs;
            return this;
        }

        public CreateCommandBuilder withEndTs(LocalDateTime endTs) {
            this.endTs = endTs;
            return this;
        }

        public CreateCommand build() {
            if (this.title == null) throw new IllegalStateException("title must not be null");
            if (this.description == null) throw new IllegalStateException("description must not be null");
            if (this.city == null) throw new IllegalStateException("city must not be null");
            if (this.customerId == null) throw new IllegalStateException("customerId must not be null");
            if (this.typeId == null) throw new IllegalStateException("typeId must not be null");
            if (this.title.length() < 2) throw new IllegalStateException("title's length must be greater than 2 characters");
            if (this.title.length() > 64) throw new IllegalStateException("title's length must be less than 64 characters");
            if (this.description.length() < 20) throw new IllegalStateException("description's length must be greater than 20 characters");
            if (this.description.length() > 10000) throw new IllegalStateException("description's length must be less than 10000 characters");
            if (this.city.isBlank()) throw new IllegalStateException("city must not be blank");
            if (this.city.length() < 2) throw new IllegalStateException("city's length must be greater than 2 characters");
            if (this.city.length() > 64) throw new IllegalStateException("city's length must be less than 64 characters");
            return new CreateCommand(customerId, title, typeId, city, description, place, startTs, endTs);
        }
    }
}
