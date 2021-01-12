package ru.udisondev.eventservice.service;

import ru.udisondev.eventservice.entity.Event;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.service.command.UpdateCommand;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;
import ru.udisondev.eventservice.service.exception.EventCreationException;
import ru.udisondev.eventservice.service.exception.EventNotFoundException;
import ru.udisondev.eventservice.service.exception.EventRemovingException;
import ru.udisondev.eventservice.service.exception.EventUpdatingException;

import java.util.UUID;

public interface EventCommandService {

    /**
     * Creates {@link Event} based on the passed command sets id and save into database.
     * @param command contains information to creation an {@link Event}.
     * @return immutable copy of created event.
     * @throws IllegalArgumentException if passed argument is null.
     * @throws IllegalStateException if {@link CreateCommand} has no contain required attributes.
     * @throws EventCreationException if something goes wrong during creation process.
     */
    ImmutableEvent create(CreateCommand command);

    /**
     * Updates {@link Event} based on the passed command.
     * @param command contains information to updating an {@link Event}.
     * @return immutable copy of updated event.
     * @throws IllegalArgumentException if passed argument is null.
     * @throws IllegalStateException if {@link UpdateCommand} has no contain required attributes.
     * @throws EventUpdatingException if something goes wrong during updating process.
     * @throws EventNotFoundException if the event was not found by the passed ID.
     */
    ImmutableEvent update(UpdateCommand command);

    /**
     * The plain method for removing the {@link Event} by passed ID.
     * @param id unique identifier of the {@link Event}.
     * @throws IllegalArgumentException if passed argument is null.
     * @throws EventRemovingException if something goes wrong during updating process.
     * @throws EventNotFoundException if no event with passed id was found.
     */
    void remove(UUID id);
}
