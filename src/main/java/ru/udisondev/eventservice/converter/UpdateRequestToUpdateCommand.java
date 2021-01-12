package ru.udisondev.eventservice.converter;

import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;
import ru.udisondev.eventservice.service.command.UpdateCommand;
import ru.udisondev.eventservice.web.dto.UpdateRequest;

public class UpdateRequestToUpdateCommand implements Converter<UpdateRequest, UpdateCommand> {

    @Override
    public UpdateCommand convert(@NotNull UpdateRequest source) {
        Assert.notNull(source, "UpdateRequest must not be null");

        return UpdateCommand.newUpdateCommand()
                .withId(source.getId())
                .withCity(source.getCity())
                .withCustomerId(source.getCustomerId())
                .withDescription(source.getDescription())
                .withTitle(source.getTitle())
                .withTypeId(source.getTypeId())
                .withPlace(source.getPlace())
                .withStartDate(source.getStartDate())
                .withStartTime(source.getStartTime())
                .withEndDate(source.getEndDate())
                .withEndTime(source.getEndTime())
                .build();
    }

}
