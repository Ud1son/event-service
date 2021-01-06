package ru.udisondev.eventservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.udisondev.eventservice.persistence.EventRepository;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

class EventServiceTest {

    private EventRepository repository;
    private EventService service;

    @BeforeEach
    void init() {
        repository = mock(EventRepository.class);
        service = new EventServiceImpl(repository);
    }

    @Test
    void givenNull_whenCreate_thenThrowsIllegalArgumentException() {
        assertThatThrownBy(() -> service.create(null)).isInstanceOf(IllegalArgumentException.class);
    }

}