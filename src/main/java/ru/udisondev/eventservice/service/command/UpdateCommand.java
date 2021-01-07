package ru.udisondev.eventservice.service.command;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
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
    private final LocalDateTime startTs;
    private final LocalDateTime endTs;
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
        private LocalDateTime startTs;
        private LocalDateTime endTs;

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

        public UpdateCommandBuilder withStartTs(LocalDateTime startTs) {
            this.startTs = startTs;
            return this;
        }

        public UpdateCommandBuilder withEndTs(LocalDateTime endTs) {
            this.endTs = endTs;
            return this;
        }

        /**
         * @return new instance of UpdateCommand.
         * @throws IllegalStateException if {@code id} or {@code customerId} is null.
         */
        public UpdateCommand build() {
            if (this.id == null) throw new IllegalStateException("id must not be null!");
            if (this.customerId == null) throw new IllegalStateException("customerId must not be null!");

            return new UpdateCommand(
                    id,
                    customerId,
                    title,
                    typeId,
                    city,
                    description,
                    place,
                    startTs,
                    endTs);
        }
    }
}
