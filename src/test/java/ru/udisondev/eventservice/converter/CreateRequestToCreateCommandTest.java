package ru.udisondev.eventservice.converter;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.core.convert.converter.Converter;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.web.dto.CreateRequest;

import java.util.UUID;

import static org.mockito.Mockito.when;

class CreateRequestToCreateCommandTest {
    private final Converter<CreateRequest, CreateCommand> converter = new CreateRequestToCreateCommand();
    private CreateRequest request;

    @BeforeEach
    void init() {
        request = Mockito.mock(CreateRequest.class);
        when(request.getCity()).thenReturn("City");
        when(request.getCustomerId()).thenReturn(UUID.randomUUID());
        when(request.getTypeId()).thenReturn(UUID.randomUUID());
        when(request.getDescription()).thenReturn("I try to make a normal description. I hope that is OK!");
        when(request.getTitle()).thenReturn("Title");
    }



}