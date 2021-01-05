package ru.udisondev.eventservice.service.exception;

public class EventSearchingException extends RuntimeException {

    public EventSearchingException(String message) {
        super(message);
    }

    public EventSearchingException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventSearchingException(Throwable cause) {
        super(cause);
    }
}
