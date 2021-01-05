package ru.udisondev.eventservice.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import ru.udisondev.eventservice.AbstractTest;
import ru.udisondev.eventservice.persistence.EventRepository;
import ru.udisondev.eventservice.service.dto.EventDetails;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EventServiceTest extends AbstractTest {

    @Mock
    private EventRepository repository;
    @Autowired
    private EventService service;

    @Test
    public void givenNull_whenCreate_thenThrowIllegalArgumentException() {
        assertThatThrownBy(() -> service.create(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void givenValidDetailsToCreation_whenCreate_thenReturnInstanceOfImmutableCopy() {
        EventDetails details = EventDetails.builder()
                .id(UUID.randomUUID())
                .customerId(UUID.randomUUID())
                .typeId(UUID.randomUUID())
                .title("title")
                .city("city")
                .build();

        ImmutableEvent immutableEvent = service.create(details);

        Assertions.assertThat(isEquals(details, immutableEvent)).isTrue();


    }

    private static boolean isEquals(EventDetails actual, ImmutableEvent expected) {
        if (actual == null || expected == null) return false;
        if (!actual.getCity().equals(expected.getCity())) return false;
        if (!actual.getId().equals(expected.getId())) return false;
        if (!actual.getTypeId().equals(expected.getTypeId())) return false;
        if (!actual.getCustomerId().equals(expected.getTypeId())) return false;
        if (!actual.getTitle().equals(expected.getTitle())) return false;
        if (!actual.getDescription().equals(expected.getDescription())) return false;
        if (!actual.getStartTs().equals(expected.getStartTs())) return false;
        if (!actual.getEndTs().equals(expected.getEndTs())) return false;
        if (!actual.getPlace().equals(expected.getPlace())) return false;

        return true;

    }


}