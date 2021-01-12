package ru.udisondev.eventservice.service;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.udisondev.eventservice.entity.Event;
import ru.udisondev.eventservice.persistence.EventRepository;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.service.command.UpdateCommand;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;
import ru.udisondev.eventservice.service.exception.EventCreationException;
import ru.udisondev.eventservice.service.exception.EventUpdatingException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class EventCommandServiceTest {
    private EventRepository repository = Mockito.mock(EventRepository.class);
    private final EventCommandService service = new EventCommandServiceImpl(repository);

    @Test
    void givenNullArg_whenCreate_thenThrowIllegalArgumentException() {
        assertThatThrownBy(() -> service.create(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenValidCommand_whenCreate_thenSetID() {
        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);
        CreateCommand command = getCreateCommand();
        service.create(command);
        verify(repository).save(captor.capture());

        Event event = captor.getValue();

        assertThat(event.getId()).isNotNull();
    }

    @Test
    void givenValidCommand_whenCreate_thenCallRepositorySave() {
        CreateCommand command = getCreateCommand();
        service.create(command);
        verify(repository).save(any());
    }

    @Test
    void givenValidCommand_whenCreate_thenPassToSaveTheEventWithTheSameValuesAsCommand() {
        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);
        CreateCommand command = getCreateCommand();
        service.create(command);
        verify(repository).save(captor.capture());

        Event event = captor.getValue();
        assertEquals(command, event);
    }


    @Test
    void givenValidCommand_whenCreate_thenReturnImmutableCopyWithTheSameValuesAsCommand() {
        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);
        ImmutableEvent immutableEvent = service.create(getCreateCommand());
        verify(repository).save(captor.capture());

        Event event = captor.getValue();

        assertEquals(event, immutableEvent);
    }

    @Test
    void givenRepositoryThrowSomeException_whenCreate_thenThrowEventCreationException() {
        when(repository.save(any())).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> service.create(getCreateCommand()))
                .isInstanceOf(EventCreationException.class)
                .hasMessageContaining("Error occurred while creation");
    }


    @Test
    void givenNullArg_whenUpdate_thenThrowIllegalArgumentException() {
        assertThatThrownBy(() -> service.update(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenValidCommand_whenUpdate_thenPassToSaveTheEventWithTheSameValuesAsCommand() {
        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);
        UpdateCommand command = getUpdateCommand();
        service.update(command);

        verify(repository).save(captor.capture());
        Event event = captor.getValue();
        assertEquals(command, event);
    }

    @Test
    void givenValidCommand_whenUpdate_thenReturnImmutableCopyWithTheSameValuesAsCommand() {
        ArgumentCaptor<Event> captor = ArgumentCaptor.forClass(Event.class);
        ImmutableEvent immutableEvent = service.update(getUpdateCommand());
        verify(repository).save(captor.capture());

        Event event = captor.getValue();

        assertEquals(event, immutableEvent);
    }

    @Test
    void givenRepositoryThrowSomeException_whenUpdate_thenThrowEventCreationException() {
        when(repository.save(any())).thenThrow(RuntimeException.class);
        assertThatThrownBy(() -> service.update(getUpdateCommand()))
                .isInstanceOf(EventUpdatingException.class)
                .hasMessageContaining("Error occurred while updating");
    }

    @Test
    void givenNullArg_whenRemove_thenThrowIllegalArgumentException() {
        assertThatThrownBy(() -> service.remove(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not be null");
    }

    @Test
    void givenValidUUID_whenRemove_thenCallRepositoryDeleteById() {
        service.remove(UUID.randomUUID());
        verify(repository).deleteById(any());
    }

    @Test
    void givenValidUUID_whenRemove_thenPassCurrentUUIDToSave() {
        ArgumentCaptor<UUID> captor = ArgumentCaptor.forClass(UUID.class);
        UUID actualUUID = UUID.randomUUID();
        service.remove(actualUUID);

        verify(repository).deleteById(captor.capture());
        UUID expectedUUID = captor.getValue();

        assertThat(actualUUID).isEqualTo(expectedUUID);

    }

    private UpdateCommand getUpdateCommand() {
        UpdateCommand command = mock(UpdateCommand.class);

        when(command.getId()).thenReturn(UUID.randomUUID());
        when(command.getDescription()).thenReturn("This is small description but I think that enough");
        when(command.getTitle()).thenReturn("Title");
        when(command.getCustomerId()).thenReturn(UUID.randomUUID());
        when(command.getTypeId()).thenReturn(UUID.randomUUID());
        when(command.getPlace()).thenReturn("Place");
        when(command.getCity()).thenReturn("City");
        when(command.getStartDate()).thenReturn(LocalDate.now().plusDays(1));
        when(command.getStartTime()).thenReturn(LocalTime.now());
        when(command.getEndDate()).thenReturn(LocalDate.now().plusDays(1));
        when(command.getStartTime()).thenReturn(LocalTime.now());

        return command;
    }

    @NotNull
    private CreateCommand getCreateCommand() {
        CreateCommand command = mock(CreateCommand.class);
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
        return command;
    }

    private void assertEquals(CreateCommand actual, Event expected) {
        assertThat(actual.getCity()).isEqualTo(expected.getCity());
        assertThat(actual.getStartDate()).isEqualTo(expected.getStartDate());
        assertThat(actual.getStartTime()).isEqualTo(expected.getStartTime());
        assertThat(actual.getEndDate()).isEqualTo(expected.getEndDate());
        assertThat(actual.getEndTime()).isEqualTo(expected.getEndTime());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
        assertThat(actual.getPlace()).isEqualTo(expected.getPlace());
        assertThat(actual.getTypeId()).isEqualTo(expected.getTypeId());
        assertThat(actual.getCustomerId()).isEqualTo(expected.getCustomerId());
    }

    private void assertEquals(Event actual, ImmutableEvent expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getCity()).isEqualTo(expected.getCity());
        assertThat(actual.getStartDate()).isEqualTo(expected.getStartDate());
        assertThat(actual.getStartTime()).isEqualTo(expected.getStartTime());
        assertThat(actual.getEndDate()).isEqualTo(expected.getEndDate());
        assertThat(actual.getEndTime()).isEqualTo(expected.getEndTime());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
        assertThat(actual.getPlace()).isEqualTo(expected.getPlace());
        assertThat(actual.getTypeId()).isEqualTo(expected.getTypeId());
        assertThat(actual.getCustomerId()).isEqualTo(expected.getCustomerId());
        assertThat(actual.getCreateTs()).isEqualTo(expected.getCreateTs());
    }

    private void assertEquals(UpdateCommand actual, Event expected) {
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getCity()).isEqualTo(expected.getCity());
        assertThat(actual.getStartDate()).isEqualTo(expected.getStartDate());
        assertThat(actual.getStartTime()).isEqualTo(expected.getStartTime());
        assertThat(actual.getEndDate()).isEqualTo(expected.getEndDate());
        assertThat(actual.getEndTime()).isEqualTo(expected.getEndTime());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
        assertThat(actual.getDescription()).isEqualTo(expected.getDescription());
        assertThat(actual.getPlace()).isEqualTo(expected.getPlace());
        assertThat(actual.getTypeId()).isEqualTo(expected.getTypeId());
        assertThat(actual.getCustomerId()).isEqualTo(expected.getCustomerId());
    }

}