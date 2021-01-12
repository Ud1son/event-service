package ru.udisondev.eventservice.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EventBuilderTest {

    @Test
    void whenBuildWithoutArgs_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> Event.newEvent().build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenNullTitle_whenBuild_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                .withTitle(null)
                .build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenNullDescription_whenBuild_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                .withDescription(null)
                .build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenNullId_whenBuild_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                .withId(null)
                .build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenNullCity_whenBuild_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                .withCity(null)
                .build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenNullCustomerId_whenBuild_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                .withCustomerId(null)
                .build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenNullTypeId_whenBuild_thenThrowIllegalStateException() {
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                .withTypeId(null)
                .build()).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void givenTitleLengthLessThan2_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                    .withTitle("t")
                    .withDescription("This is very very simple description")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .withCity("City")
                    .withId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("greater than 2");
        //@formatter:on
    }

    @Test
    void givenTitleLengthGreaterThan64_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                    .withTitle("I've forgot how many characters I should to use then I just will try make this bullshit")
                    .withDescription("This is very very simple description")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .withCity("City")
                    .withId(UUID.randomUUID())
                .build()).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("less than 64");
        //@formatter:on
    }

    @Test
    void givenDescriptionLengthLessThan20_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                    .withTitle("Title")
                    .withDescription("Simple")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .withCity("City")
                    .withId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("greater than 20");
        //@formatter:on
    }

    @Test
    void givenDescriptionLengthGreaterThan10000_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                    .withTitle("Title")
                    .withDescription(getLongString())
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .withCity("City")
                    .withId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("less than 10000");
        //@formatter:on
    }

    @Test
    void givenCityIsBlank_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                    .withTitle("Title")
                    .withDescription("I think that it normal description")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .withCity("   ")
                    .withId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("not be blank");
        //@formatter:on
    }

    @Test
    void givenCityLengthLessThan2_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                    .withTitle("Title")
                    .withDescription("I think that it normal description")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .withCity("C")
                    .withId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("greater than 2");
        //@formatter:off
    }

    @Test
    void givenCityLengthGreaterThan64_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        Assertions.assertThatThrownBy(() -> Event.newEvent()
                    .withTitle("Title")
                    .withDescription("I think that it normal description")
                    .withTypeId(UUID.randomUUID())
                    .withCustomerId(UUID.randomUUID())
                    .withCity("I will try to think up city's name which greater than 64 characters.")
                    .withId(UUID.randomUUID())
                    .build())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("less than 64");
        //@formatter:off
    }

    @Test
    void givenStartDateInPast_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> Event.newEvent()
                .withId(UUID.randomUUID())
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
    void givenStartDateInPresent_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> Event.newEvent()
                .withId(UUID.randomUUID())
                .withTitle("Title")
                .withDescription("This is small description but I think that enough")
                .withStartDate(LocalDate.now())
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
        assertThatThrownBy(() -> Event.newEvent()
                .withId(UUID.randomUUID())
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
    void givenEndDateInPresent_whenBuild_thenThrowIllegalStateException() {
        //@formatter:off
        assertThatThrownBy(() -> Event.newEvent()
                .withId(UUID.randomUUID())
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