package ru.udisondev.eventservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.web.dto.CreateRequest;

public class CreateRequestToCreateCommand implements Converter<CreateRequest, CreateCommand> {

    @Override
    public CreateCommand convert(CreateRequest source) {
        Assert.notNull(source, "CreateRequest must not be null");

        return CreateCommand.newCreateCommand()
                .withTitle(source.getTitle())
                .withDescription(source.getDescription())
                .withCustomerId(source.getCustomerId())
                .withTypeId(source.getTypeId())
                .withCity(source.getCity())
                .withPlace(source.getPlace())
                .withStartTs(source.getStartTs())
                .withEndTs(source.getEndTs())
                .build();
    }

}
