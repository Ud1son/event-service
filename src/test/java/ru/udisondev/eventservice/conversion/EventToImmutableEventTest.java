package ru.udisondev.eventservice.conversion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;
import ru.udisondev.eventservice.AbstractTest;
import ru.udisondev.eventservice.entity.Event;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;

import java.time.LocalDateTime;
import java.util.UUID;

class EventToImmutableEventTest extends AbstractTest {

    private final Converter<Event, ImmutableEvent> converter = new EventToImmutableEvent();

    @Test
    public void givenValidEvent_whenConvert_thenReturnImmutableEventWithTheSameValues() {
        Event actual = Event.builder()
                .id(UUID.randomUUID())
                .description("description")
                .title("title")
                .city("city")
                .customerId(UUID.randomUUID())
                .typeId(UUID.randomUUID())
                .startTs(LocalDateTime.now())
                .endTs(LocalDateTime.now())
                .place("place")
                .build();

        ImmutableEvent expected = converter.convert(actual);

        Assertions.assertThat(isEquals(actual, expected)).isTrue();

    }

    private static boolean isEquals(Event actual, ImmutableEvent expected) {

        if (actual == null && expected == null) return true;

        if (actual == null || expected == null) return false;

        if (actual.getCity() != null) {
            if (!actual.getCity().equals(expected.getCity()))return false;
        }
        if (actual.getId() != null) {
            if (!actual.getId().equals(expected.getId())) return false;
        }
        if (actual.getTypeId() != null) {
            if (!actual.getTypeId().equals(expected.getTypeId())) return false;
        }
        if (actual.getCustomerId() != null) {
            if (!actual.getCustomerId().equals(expected.getCustomerId())) return false;
        }
        if (actual.getTitle() != null) {
            if (!actual.getTitle().equals(expected.getTitle())) return false;
        }
        if (actual.getDescription() != null) {
            if (!actual.getDescription().equals(expected.getDescription())) return false;
        }
        if (actual.getStartTs() != null) {
            if (!actual.getStartTs().equals(expected.getStartTs())) return false;
        }
        if (actual.getEndTs() != null) {
            if (!actual.getEndTs().equals(expected.getEndTs())) return false;
        }
        if (actual.getPlace() != null) {
            if (!actual.getPlace().equals(expected.getPlace())) return false;
        }

        return true;

    }

}