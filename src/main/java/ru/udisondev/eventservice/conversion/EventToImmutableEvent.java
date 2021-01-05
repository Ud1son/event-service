package ru.udisondev.eventservice.conversion;

import org.springframework.core.convert.converter.Converter;
import ru.udisondev.eventservice.entity.Event;
import ru.udisondev.eventservice.service.dto.ImmutableEvent;

public class EventToImmutableEvent implements Converter<Event, ImmutableEvent> {

    @Override
    public ImmutableEvent convert(Event source) {
        return ImmutableEvent.builder()
                .id(source.getId())
                .city(source.getCity())
                .createTs(source.getCreateTs())
                .customerId(source.getCustomerId())
                .description(source.getDescription())
                .endTs(source.getEndTs())
                .place(source.getPlace())
                .startTs(source.getStartTs())
                .title(source.getTitle())
                .typeId(source.getTypeId())
                .build();
    }
}
