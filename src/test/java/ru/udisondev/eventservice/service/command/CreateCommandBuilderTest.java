package ru.udisondev.eventservice.service.command;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CreateCommandBuilderTest {

    @Test
    void givenNullArg_whenBuild_thenThrowIllegalStateException() {
        assertThatThrownBy(() -> CreateCommand.newCreateCommand().build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenNullTitle_whenBuild_thenThrowIllegalStateException() {
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle(null)
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenNullDescription_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription(null)
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenNullCity_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenNullCustomerId_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenNullTypeId_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenTitleLengthLessThan2_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                .withTitle("T")
                .withDescription("This is small description but I think that enough")
                .withStartDate(LocalDate.MIN)
                .withEndDate(LocalDate.MIN)
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
    void givenTitleLengthGreaterThan64_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle(getLongString())
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenDescriptionLengthLessThan20_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("Short")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenDescriptionLengthGreaterThan10000_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription(getLongString())
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenCityIsBlank_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenCityLengthLessThan2_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
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
    void givenCityLengthGreaterThan64_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
                    .withPlace("Place")
                    .withCity(getLongString())
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("less than 64");
        //@formatter:on
    }

    @Test
    void givenStartDateInPast_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                    .withTitle("Title")
                    .withDescription("This is small description but I think that enough")
                    .withStartDate(LocalDate.MIN)
                    .withEndDate(LocalDate.MIN)
                    .withPlace("Place")
                    .withCity("City")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("be in future");
        //@formatter:on
    }

    @Test
    void givenEndDateInPast_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                .withTitle("Title")
                .withDescription("This is small description but I think that enough")
                .withStartDate(LocalDate.now().plusDays(1))
                .withEndDate(LocalDate.MIN)
                .withPlace("Place")
                .withCity("City")
                .withTypeId(UUID.randomUUID())
                .withCustomerId(UUID.randomUUID())
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("be in future");
        //@formatter:on
    }

    @Test
    void givenStartDateInPresent_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                .withTitle("Title")
                .withDescription("This is small description but I think that enough")
                .withStartDate(LocalDate.now())
                .withEndDate(LocalDate.now().plusDays(1))
                .withPlace("Place")
                .withCity("City")
                .withTypeId(UUID.randomUUID())
                .withCustomerId(UUID.randomUUID())
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("be in future");
        //@formatter:on
    }

    @Test
    void givenEndDateInPresent_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> CreateCommand.newCreateCommand()
                .withTitle("Title")
                .withDescription("This is small description but I think that enough")
                .withStartDate(LocalDate.now().plusDays(1))
                .withEndDate(LocalDate.now())
                .withPlace("Place")
                .withCity("City")
                .withTypeId(UUID.randomUUID())
                .withCustomerId(UUID.randomUUID())
                .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("be in future");
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