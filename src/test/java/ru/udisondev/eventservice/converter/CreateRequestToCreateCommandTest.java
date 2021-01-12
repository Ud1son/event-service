package ru.udisondev.eventservice.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.convert.converter.Converter;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.web.dto.CreateRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class CreateRequestToCreateCommandTest {

    private final Converter<CreateRequest, CreateCommand> converter = new CreateRequestToCreateCommand();
    private final CreateRequest request = Mockito.mock(CreateRequest.class);

    @Test
    void givenNullArgument_whenConvert_thenThrownIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> converter.convert(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenValidCreateRequest_whenConvert_thenReturnCreateCommandWithTHeSameValues() {
        when(request.getDescription()).thenReturn("This is small description but I think that enough");
        when(request.getTitle()).thenReturn("Title");
        when(request.getCustomerId()).thenReturn(UUID.randomUUID());
        when(request.getTypeId()).thenReturn(UUID.randomUUID());
        when(request.getPlace()).thenReturn("Place");
        when(request.getCity()).thenReturn("City");
        when(request.getStartDate()).thenReturn(LocalDate.now().plusDays(1));
        when(request.getStartTime()).thenReturn(LocalTime.now());
        when(request.getEndDate()).thenReturn(LocalDate.now().plusDays(1));
        when(request.getEndTime()).thenReturn(LocalTime.now());

        CreateCommand createCommand = converter.convert(request);

        assertEquals(request, createCommand);


    }

    private void assertEquals(CreateRequest request, CreateCommand createCommand) {
        assertThat(request.getCity()).isEqualTo(createCommand.getCity());
        assertThat(request.getStartDate()).isEqualTo(createCommand.getStartDate());
        assertThat(request.getStartTime()).isEqualTo(createCommand.getStartTime());
        assertThat(request.getEndDate()).isEqualTo(createCommand.getEndDate());
        assertThat(request.getEndTime()).isEqualTo(createCommand.getEndTime());
        assertThat(request.getTitle()).isEqualTo(createCommand.getTitle());
        assertThat(request.getDescription()).isEqualTo(createCommand.getDescription());
        assertThat(request.getPlace()).isEqualTo(createCommand.getPlace());
        assertThat(request.getTypeId()).isEqualTo(createCommand.getTypeId());
        assertThat(request.getCustomerId()).isEqualTo(createCommand.getCustomerId());
    }

}