package ru.udisondev.eventservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.udisondev.eventservice.persistence.EventRepository;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.service.command.UpdateCommand;
import ru.udisondev.eventservice.service.dto.EventFilter;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;

import java.util.List;
import java.util.UUID;

import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository repository;


    @Override
    public ImmutableEvent create(CreateCommand command) {
        notNull(command, "CreateCommand must not be null");
        return null;
    }


    @Override
    public ImmutableEvent update(UpdateCommand command) {
        return null;
    }

    @Override
    public void removeById(UUID id) {

    }

    @Override
    public ImmutableEvent findById(UUID id) {
        return null;
    }

    @Override
    public List<ImmutableEvent> findByCriteria(EventFilter filter) {
        return null;
    }

    @Override
    public List<ImmutableEvent> findAll() {
        return null;
    }
}
