package ru.udisondev.eventservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;
import ru.udisondev.eventservice.service.command.UpdateCommand;
import ru.udisondev.eventservice.web.dto.UpdateRequest;

public class UpdateRequestToUpdateCommand implements Converter<UpdateRequest, UpdateCommand> {

    @Override
    public UpdateCommand convert(UpdateRequest source) {
        Assert.notNull(source, "UpdateRequest must not be null");

        return UpdateCommand.newUpdateCommand()
                .withId(source.getId())
                .withCity(source.getCity())
                .withCustomerId(source.getCustomerId())
                .withDescription(source.getDescription())
                .withTitle(source.getTitle())
                .withTypeId(source.getTypeId())
                .withStartTs(source.getStartTs())
                .withEndTs(source.getEndTs())
                .withPlace(source.getPlace())
                .build();
    }

}
