package ru.udisondev.eventservice.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.Assert;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.web.dto.CreateRequest;

public class CreateRequestToCreateCommand implements Converter<CreateRequest, CreateCommand> {

    @Override
    public CreateCommand convert(CreateRequest source) {
        Assert.notNull(source, "CreateRequest must not be null");
        checkSource(source);
        return new CreateCommand(
                source.getCustomerId(),
                source.getTitle(),
                source.getTypeId(),
                source.getCity(),
                source.getDescription(),
                source.getPlace(),
                source.getStartTs(),
                source.getEndTs()
        );
    }

    private void checkSource(CreateRequest source) {
        if (source.getTitle() == null) throw new IllegalArgumentException("title must not be null");
        if (source.getDescription() == null) throw new IllegalArgumentException("description must not be null");
        if (source.getId() == null) throw new IllegalArgumentException("id must not be null");
        if (source.getCity() == null) throw new IllegalArgumentException("city must not be null");
        if (source.getCustomerId() == null) throw new IllegalArgumentException("customerId must not be null");
        if (source.getTypeId() == null) throw new IllegalArgumentException("typeId must not be null");
        if (source.getTitle().length() < 2) throw new IllegalArgumentException("title's length must be greater than 2 characters");
        if (source.getTitle().length() > 64) throw new IllegalArgumentException("title's length must be less than 64 characters");
        if (source.getDescription().length() < 20) throw new IllegalArgumentException("description's length must be greater than 20 characters");
        if (source.getDescription().length() > 10000) throw new IllegalArgumentException("description's length must be less than 10000 characters");
        if (source.getCity().isBlank()) throw new IllegalArgumentException("city must not be blank");
        if (source.getCity().length() < 2) throw new IllegalArgumentException("city's length must be greater than 2 characters");
        if (source.getCity().length() > 64) throw new IllegalArgumentException("city's length must be less than 64 characters");
    }
}
