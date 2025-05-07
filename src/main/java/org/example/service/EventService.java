package org.example.service;

import org.example.entity.Event;
import org.example.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EventService {

    private CalendarService calendarService;

    public EventService(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    public List<Event> getEventsForDay(Long userId) {
        LocalDateTime now = LocalDateTime.now();
        List<Event> userEvents = getUserEvents(userId);
        return userEvents.stream()
                .filter(event -> isSameDay(event.getStartTime(), now))
                .collect(Collectors.toList());
    }

    public List<Event> getEventsForWeek(Long userId) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfWeek = now.with(java.time.DayOfWeek.MONDAY);
        LocalDateTime endOfWeek = startOfWeek.plusDays(6);
        List<Event> userEvents = getUserEvents(userId);
        return userEvents.stream()
                .filter(event -> isWithinRange(event.getStartTime(), startOfWeek, endOfWeek))
                .collect(Collectors.toList());
    }

    public List<Event> getEventsForMonth(Long userId) {
        LocalDateTime now = LocalDateTime.now();
        int month = now.getMonthValue();
        int year = now.getYear();
        List<Event> userEvents = getUserEvents(userId);
        return userEvents.stream()
                .filter(event -> event.getStartTime().getMonthValue() == month &&
                        event.getStartTime().getYear() == year)
                .collect(Collectors.toList());
    }

    private List<Event> getUserEvents(Long userId) {
        User user = calendarService.getUserById(userId);
        return user != null ? user.getCalendar() : List.of();
    }

    private boolean isSameDay(LocalDateTime eventDate, LocalDateTime targetDate) {
        return eventDate.toLocalDate().equals(targetDate.toLocalDate());
    }

    private boolean isWithinRange(LocalDateTime eventDate, LocalDateTime start, LocalDateTime end) {
        return (eventDate.isEqual(start) || eventDate.isAfter(start)) &&
                (eventDate.isEqual(end) || eventDate.isBefore(end));
    }
}