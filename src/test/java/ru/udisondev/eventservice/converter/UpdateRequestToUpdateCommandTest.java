package ru.udisondev.eventservice.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.convert.converter.Converter;
import ru.udisondev.eventservice.service.command.UpdateCommand;
import ru.udisondev.eventservice.web.dto.UpdateRequest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class UpdateRequestToUpdateCommandTest {

    private final Converter<UpdateRequest, UpdateCommand> converter = new UpdateRequestToUpdateCommand();
    private final UpdateRequest request = Mockito.mock(UpdateRequest.class);

    @Test
    void givenNullArgument_whenConvert_thenThrownIllegalArgumentException() {
        Assertions.assertThatThrownBy(() -> converter.convert(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenValidCreateRequest_whenConvert_thenReturnCreateCommandWithTHeSameValues() {
        when(request.getId()).thenReturn(UUID.randomUUID());
        when(request.getDescription()).thenReturn("This is small description but I think that enough");
        when(request.getTitle()).thenReturn("Title");
        when(request.getCustomerId()).thenReturn(UUID.randomUUID());
        when(request.getTypeId()).thenReturn(UUID.randomUUID());
        when(request.getPlace()).thenReturn("Place");
        when(request.getCity()).thenReturn("City");
        when(request.getStartDate()).thenReturn(LocalDate.now().plusDays(1));
        when(request.getStartTime()).thenReturn(LocalTime.now());
        when(request.getEndDate()).thenReturn(LocalDate.now().plusDays(1));
        when(request.getStartTime()).thenReturn(LocalTime.now());

        UpdateCommand updateCommand = converter.convert(request);

        assertEquals(request, updateCommand);


    }

    private void assertEquals(UpdateRequest request, UpdateCommand updateCommand) {
        assertThat(request.getId()).isEqualTo(updateCommand.getId());
        assertThat(request.getCity()).isEqualTo(updateCommand.getCity());
        assertThat(request.getStartDate()).isEqualTo(updateCommand.getStartDate());
        assertThat(request.getStartTime()).isEqualTo(updateCommand.getStartTime());
        assertThat(request.getEndDate()).isEqualTo(updateCommand.getEndDate());
        assertThat(request.getEndTime()).isEqualTo(updateCommand.getEndTime());
        assertThat(request.getTitle()).isEqualTo(updateCommand.getTitle());
        assertThat(request.getDescription()).isEqualTo(updateCommand.getDescription());
        assertThat(request.getPlace()).isEqualTo(updateCommand.getPlace());
        assertThat(request.getTypeId()).isEqualTo(updateCommand.getTypeId());
        assertThat(request.getCustomerId()).isEqualTo(updateCommand.getCustomerId());
    }

}