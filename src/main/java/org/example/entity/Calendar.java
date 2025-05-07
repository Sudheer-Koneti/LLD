package org.example.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calendar {
    private User owner;
    private HashMap<Long, Event> eventData;

    public Calendar(User user) {
        this.owner = user;
        this.eventData = new HashMap<>();
    }

    public void addEvent(Event event) {
        eventData.put(event.getEventId(), event);
    }
    public void removeEvent(Long eventId) {
        eventData.remove(eventId);
    }
    public void UpdateEvent(Long eventId, Event updatedEvent) {
        if (eventData.containsKey(eventId)) {
            eventData.put(eventId, updatedEvent);
        }
    }

}
