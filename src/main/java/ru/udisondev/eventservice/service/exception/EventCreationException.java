package ru.udisondev.eventservice.service.exception;

public class EventCreationException extends RuntimeException {

    public EventCreationException(String message) {
        super(message);
    }

    public EventCreationException(Throwable cause) {
        super(cause);
    }

    public EventCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
