package ru.udisondev.eventservice.service;

import ru.udisondev.eventservice.entity.Event;
import ru.udisondev.eventservice.service.command.CreateCommand;
import ru.udisondev.eventservice.service.command.UpdateCommand;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;
import ru.udisondev.eventservice.service.dto.EventFilter;
import ru.udisondev.eventservice.service.exception.EventCreationException;
import ru.udisondev.eventservice.service.exception.EventNotFoundException;
import ru.udisondev.eventservice.service.exception.EventRemovingException;
import ru.udisondev.eventservice.service.exception.EventSearchingException;
import ru.udisondev.eventservice.service.exception.EventUpdatingException;

import java.util.List;
import java.util.UUID;

public interface EventService {

    /**
     * The method will check required fields then create and save {@link Event} by the passed parameters.
     * @param command contains information to create an {@link Event}.
     * @return an immutable copy of the created event.
     * @throws IllegalArgumentException if passed argument is null.
     * @throws IllegalStateException if customerId in EventDetails instance is null
     * @throws EventCreationException if something goes wrong during creation process.
     */
    ImmutableEvent create(CreateCommand command);

    /**
     * The method will check required fields then update and save {@link Event} by the passed parameters.
     * @param command contains information to update an {@link Event} with passed ID.
     * @return an immutable copy of the updated event.
     * @throws IllegalArgumentException if passed argument is null.
     * @throws IllegalStateException if Id in EventDetails instance is null
     * @throws EventUpdatingException if something goes wrong during updating process.
     * @throws EventNotFoundException if the event was not found by the passed ID.
     */
    ImmutableEvent update(UpdateCommand command);

    /**
     * The plain method for removing the {@link Event} by passed ID.
     * @param id unique identifier of the {@link Event}.
     * @throws IllegalArgumentException if passed argument is null.
     * @throws EventRemovingException if something goes wrong during updating process.
     * @throws EventNotFoundException if the event was not found by the passed ID.
     */
    void removeById(UUID id);

    /**
     * The plain method for searching the {@link Event} by passed ID
     * @param id unique identifier of the {@link Event}.
     * @return an immutable copy of the searched for event.
     * @throws IllegalArgumentException if passed argument is null.
     * @throws EventNotFoundException if the event was not found by the passed ID.
     * @throws EventSearchingException if something goes wrong during searching process.
     */
    ImmutableEvent findById(UUID id);

    /**
     * The method will check all parameters from the passed details and combine them into a summary list based on these criteria.
     * @param filter contains required information to combine needed events.
     * @return a list of immutable copies of events based on the passed criteria.
     * @throws IllegalArgumentException if passed argument is null.
     * @throws IllegalStateException if EventDetails has parameters with invalid values.
     * @throws EventNotFoundException if the event was not found by the passed ID.
     * @throws EventSearchingException if something goes wrong during searching process.
     */
    List<ImmutableEvent> findByCriteria(EventFilter filter);

    /**
     * Simple method for finding all events
     * @return a list of all existing events
     * @throws IllegalArgumentException if passed argument is null.
     * @throws EventSearchingException if something goes wrong during searching process.
     */
    List<ImmutableEvent> findAll();
}
