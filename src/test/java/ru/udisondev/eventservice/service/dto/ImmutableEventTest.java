package ru.udisondev.eventservice.service.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.udisondev.eventservice.entity.Event;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ImmutableEventTest {

    private Event event;

    @BeforeEach
    void init() {
        event = mock(Event.class);
    }

    @Test
    void givenNullArgument_whenNewInstance_thenThrowIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenEventWithNullId_whenNewInstance_thenThrowIllegalArgumentException() {
        when(event.getId()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(event)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenEventWithNullCustomerId_whenNewInstance_thenThrowIllegalArgumentException() {
        when(event.getCustomerId()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(event)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenEventWithNullTitle_whenNewInstance_thenThrowIllegalArgumentException() {
        when(event.getTitle()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(event)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenEventWithNullDescription_whenNewInstance_thenThrowIllegalArgumentException() {
        when(event.getDescription()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(event)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenEventWithNullCity_whenNewInstance_thenThrowIllegalArgumentException() {
        when(event.getCity()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(event)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenEventWithNullTypeId_whenNewInstance_thenThrowIllegalArgumentException() {
        when(event.getTypeId()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(event)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenEventWithNullCreateTs_whenNewInstance_thenThrowIllegalArgumentException() {
        when(event.getCreateTs()).thenReturn(null);
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(event)).isInstanceOf(IllegalArgumentException.class);
    }

}