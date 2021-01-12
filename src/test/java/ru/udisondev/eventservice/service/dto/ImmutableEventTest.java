package ru.udisondev.eventservice.service.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.udisondev.eventservice.entity.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class ImmutableEventTest {

    @Test
    void givenNullArgument_whenNewInstance_thenThrowIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> ImmutableEvent.newInstance(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenValidEvent_whenNewInstance_thenReturnImmutableEventWithTheSameValues() {
        Event event = Mockito.mock(Event.class);
        LocalTime now = LocalTime.now();

        when(event.getId()).thenReturn(UUID.randomUUID());
        when(event.getDescription()).thenReturn("This is small description but I think that enough");
        when(event.getTitle()).thenReturn("Title");
        when(event.getCustomerId()).thenReturn(UUID.randomUUID());
        when(event.getTypeId()).thenReturn(UUID.randomUUID());
        when(event.getPlace()).thenReturn("Place");
        when(event.getCity()).thenReturn("City");
        when(event.getStartDate()).thenReturn(LocalDate.now().plusDays(1));
        when(event.getStartTime()).thenReturn(now);
        when(event.getEndDate()).thenReturn(LocalDate.now().plusDays(1));
        when(event.getEndTime()).thenReturn(now);
        when(event.getCreateTs()).thenReturn(LocalDateTime.MIN);

        ImmutableEvent immutableEvent = ImmutableEvent.newInstance(event);

        assertEquals(event, immutableEvent);
    }

    private void assertEquals(Event event, ImmutableEvent immutableEvent) {
        assertThat(event.getId()).isEqualTo(immutableEvent.getId());
        assertThat(event.getCity()).isEqualTo(immutableEvent.getCity());
        assertThat(event.getStartDate()).isEqualTo(immutableEvent.getStartDate());
        assertThat(event.getStartTime()).isEqualTo(immutableEvent.getStartTime());
        assertThat(event.getEndDate()).isEqualTo(immutableEvent.getEndDate());
        assertThat(event.getEndTime()).isEqualTo(immutableEvent.getEndTime());
        assertThat(event.getTitle()).isEqualTo(immutableEvent.getTitle());
        assertThat(event.getDescription()).isEqualTo(immutableEvent.getDescription());
        assertThat(event.getPlace()).isEqualTo(immutableEvent.getPlace());
        assertThat(event.getTypeId()).isEqualTo(immutableEvent.getTypeId());
        assertThat(event.getCustomerId()).isEqualTo(immutableEvent.getCustomerId());
    }

}