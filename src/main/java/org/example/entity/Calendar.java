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
    public List<Event> getEventsofToday() {
        List<Event> todayEvents = new ArrayList<>();
        for (Event event : eventData.values()) {
            if (event.isToday()) {
                todayEvents.add(event);
            }
        }
        return todayEvents;
    }
    public List<Event> getEventsOfWeek() {
        List<Event> weekEvents = new ArrayList<>();
        for (Event event : eventData.values()) {
            if (event.isThisWeek()) {
                weekEvents.add(event);
            }
        }
        return weekEvents;
    }

}
