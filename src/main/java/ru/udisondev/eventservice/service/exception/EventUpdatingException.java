package ru.udisondev.eventservice.service.exception;

public class EventUpdatingException extends RuntimeException {

    public EventUpdatingException(String message) {
        super(message);
    }

    public EventUpdatingException(String message, Throwable cause) {
        super(message, cause);
    }
}
