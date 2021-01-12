package ru.udisondev.eventservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.udisondev.eventservice.entity.Event;
import ru.udisondev.eventservice.persistence.EventRepository;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.service.command.UpdateCommand;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;
import ru.udisondev.eventservice.service.exception.EventCreationException;
import ru.udisondev.eventservice.service.exception.EventUpdatingException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventCommandServiceImpl implements EventCommandService {

    private final EventRepository repository;

    @Override
    public ImmutableEvent create(CreateCommand command) {
        Assert.notNull(command, "command must not be null");
        Event event = Event.newEvent()
                .withEndTime(command.getEndTime())
                .withEndDate(command.getEndDate())
                .withStartTime(command.getStartTime())
                .withId(UUID.randomUUID())
                .withCity(command.getCity())
                .withCustomerId(command.getCustomerId())
                .withTypeId(command.getTypeId())
                .withDescription(command.getDescription())
                .withTitle(command.getTitle())
                .withPlace(command.getPlace())
                .withStartDate(command.getStartDate())
                .build();

        try {
            repository.save(event);

            return ImmutableEvent.newInstance(event);
        } catch (Exception e) {
            throw new EventCreationException("Error occurred while creation event!", e);
        }

    }

    @Override
    public ImmutableEvent update(UpdateCommand command) {
        Assert.notNull(command, "command must not be null");
        Event event = Event.newEvent()
                .withStartTime(command.getStartTime())
                .withStartDate(command.getStartDate())
                .withPlace(command.getPlace())
                .withTitle(command.getTitle())
                .withDescription(command.getDescription())
                .withTypeId(command.getTypeId())
                .withCustomerId(command.getCustomerId())
                .withCity(command.getCity())
                .withId(command.getId())
                .withEndDate(command.getEndDate())
                .withEndTime(command.getEndTime())
                .build();
        try {
            repository.save(event);
        } catch (Exception e) {
            throw new EventUpdatingException("Error occurred while updating event!", e);
        }

        return ImmutableEvent.newInstance(event);
    }

    @Override
    public void remove(UUID id) {
        Assert.notNull(id, "id must not be null");
        repository.deleteById(id);
    }
}
