package ru.udisondev.eventservice.service.exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ru.udisondev.eventservice.entity.Event;
import ru.udisondev.eventservice.persistence.EventRepository;
import ru.udisondev.eventservice.service.EventCommandService;
import ru.udisondev.eventservice.service.EventCommandServiceImpl;
import ru.udisondev.eventservice.service.command.CreateCommand;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class EventCommandServiceTest {

    private final EventRepository repository = Mockito.mock(EventRepository.class);
    private final EventCommandService service = new EventCommandServiceImpl(repository);

    @Test
    void givenNullCreateCommand_whenCreate_thenThrowIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> service.create(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenCreate_thenCallSave() {
        CreateCommand command = Mockito.mock(CreateCommand.class);

        when(command.getDescription()).thenReturn("This is small description but I think that enough");
        when(command.getTitle()).thenReturn("Title");
        when(command.getCustomerId()).thenReturn(UUID.randomUUID());
        when(command.getTypeId()).thenReturn(UUID.randomUUID());
        when(command.getPlace()).thenReturn("Place");
        when(command.getCity()).thenReturn("City");
        when(command.getStartDate()).thenReturn(LocalDate.now().plusDays(1));
        when(command.getStartTime()).thenReturn(LocalTime.now());
        when(command.getEndDate()).thenReturn(LocalDate.now().plusDays(1));
        when(command.getEndTime()).thenReturn(LocalTime.now());

        service.create(command);
        verify(repository).save(Mockito.any());
    }

    @Test
    void whenCreate_thenSaveEventWithTheSameValuesAsTheCommand() {
        CreateCommand command = Mockito.mock(CreateCommand.class);

        when(command.getDescription()).thenReturn("This is small description but I think that enough");
        when(command.getTitle()).thenReturn("Title");
        when(command.getCustomerId()).thenReturn(UUID.randomUUID());
        when(command.getTypeId()).thenReturn(UUID.randomUUID());
        when(command.getPlace()).thenReturn("Place");
        when(command.getCity()).thenReturn("City");
        when(command.getStartDate()).thenReturn(LocalDate.now().plusDays(1));
        when(command.getStartTime()).thenReturn(LocalTime.now());
        when(command.getEndDate()).thenReturn(LocalDate.now().plusDays(1));
        when(command.getEndTime()).thenReturn(LocalTime.now());

        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);

        service.create(command);

        verify(repository).save(captor.capture());


        assertEquals(command, captor.getValue());
    }

    private void assertEquals(CreateCommand actual, Event expected) {
        Assertions.assertThat(actual.getCity()).isEqualTo(expected.getCity());
        Assertions.assertThat(actual.getCustomerId()).isEqualTo(expected.getCustomerId());
        Assertions.assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
        Assertions.assertThat(actual.getEndDate()).isEqualTo(expected.getEndDate());
        Assertions.assertThat(actual.getPlace()).isEqualTo(expected.getPlace());
        Assertions.assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        Assertions.assertThat(actual.getStartDate()).isEqualTo(expected.getStartDate());
        Assertions.assertThat(actual.getStartTime()).isEqualTo(expected.getStartTime());
        Assertions.assertThat(actual.getEndTime()).isEqualTo(expected.getEndTime());
        Assertions.assertThat(actual.getTypeId()).isEqualTo(expected.getTypeId());
    }
}