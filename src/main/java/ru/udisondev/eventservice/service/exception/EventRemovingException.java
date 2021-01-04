package ru.udisondev.eventservice.service.exception;

public class EventRemovingException extends RuntimeException {

    public EventRemovingException(String message) {
        super(message);
    }

    public EventRemovingException(String message, Throwable cause) {
        super(message, cause);
    }
}
