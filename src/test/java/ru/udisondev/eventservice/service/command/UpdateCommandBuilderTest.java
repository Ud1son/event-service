package ru.udisondev.eventservice.service.command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UpdateCommandBuilderTest {

    @Test
    void givenNullId_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> UpdateCommand.newUpdateCommand()
                    .withId(null)
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be null");
        //@formatter:on
    }

    @Test
    void givenNullCustomerId_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> UpdateCommand.newUpdateCommand()
                    .withId(UUID.randomUUID())
                    .withCustomerId(null)
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be null");
        //@formatter:on
    }
}