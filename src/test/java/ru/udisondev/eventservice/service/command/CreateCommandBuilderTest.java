package ru.udisondev.eventservice.service.command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

class CreateCommandBuilderTest {

    @Test
    void givenNullArg_whenConvert_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand().build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenNullTitle_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle(null)
                    .withDescription("This is small description but I think that enough")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("City")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be null");
        //@formatter:on
    }

    @Test
    void givenNullDescription_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription(null)
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("City")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be null");
        //@formatter:on
    }

    @Test
    void givenNullCity_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity(null)
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be null");
        //@formatter:on
    }

    @Test
    void givenNullCustomerId_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("City")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(null)
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be null");
        //@formatter:on
    }

    @Test
    void givenNullTypeId_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("City")
                    .withTypeId(null)
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be null");
        //@formatter:on
    }

    @Test
    void givenTitleLengthLessThan2_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                .withTitle("T")
                .withDescription("This is small description but I think that enough")
                .withStartTs(LocalDateTime.MIN)
                .withEndTs(LocalDateTime.MIN)
                .withPlace("Place")
                .withCity("City")
                .withTypeId(UUID.randomUUID())
                .withCustomerId(UUID.randomUUID())
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("greater than 2");
        //@formatter:on
    }

    @Test
    void givenTitleLengthGreaterThan64_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle(getLongString())
                    .withDescription("This is small description but I think that enough")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("City")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("less than 64");
        //@formatter:on
    }

    @Test
    void givenDescriptionLengthLessThan20_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("Short")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("City")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("greater than 20");
        //@formatter:on
    }

    @Test
    void givenDescriptionLengthGreaterThan10000_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription(getLongString())
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("City")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("less than 10000");
        //@formatter:on
    }

    @Test
    void givenCityIsBlank_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("   ")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be blank");
        //@formatter:on
    }

    @Test
    void givenCityLengthLessThan2_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity("C")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("greater than 2");
        //@formatter:on
    }

    @Test
    void givenCityLengthGreaterThan64_whenConvert_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartTs(LocalDateTime.MIN)
                    .withEndTs(LocalDateTime.MIN)
                    .withPlace("Place")
                    .withCity(getLongString())
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("less than 64");
        //@formatter:on
    }

    private String getLongString() {
        StringBuilder longString = new StringBuilder();

        for (int i = 0; i < 501; i++) {
            longString.append("Long long long text ");
        }

        return longString.toString();
    }

}