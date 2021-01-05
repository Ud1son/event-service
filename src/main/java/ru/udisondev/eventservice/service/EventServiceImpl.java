package ru.udisondev.eventservice.service;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.udisondev.eventservice.service.dto.EventDetails;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;

import java.util.List;
import java.util.UUID;

@Service
public class EventServiceImpl implements EventService {
    @Override
    public ImmutableEvent create(EventDetails details) {
        Assert.notNull(details, "Details must not be null");

        return null;
    }

    @Override
    public ImmutableEvent update(EventDetails details) {
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
    public List<ImmutableEvent> findByCriteria(EventDetails details) {
        return null;
    }

    @Override
    public List<ImmutableEvent> findAll() {
        return null;
    }
}
