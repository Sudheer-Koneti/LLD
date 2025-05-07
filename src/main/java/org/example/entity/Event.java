package org.example.entity;

import org.example.Enum.Recurring;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {

    private final Long eventId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private User host;
    private List<User> participants;
    private Recurring recurrance;

    private Event(Builder builder) {
        this.eventId = builder.eventId;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.host = builder.host;
        this.participants = builder.participants;
        this.recurrance = builder.recurrance;
    }

    public static class Builder {
        private final Long eventId;
        private LocalDateTime startTime;
        private LocalDateTime endTime;
        private User host;
        private List<User> participants = new ArrayList<>();
        private Recurring recurrance;

        public Builder(Long eventId) {
            this.eventId = eventId;
        }

        public Builder startTime(LocalDateTime startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder endTime(LocalDateTime endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder host(User host) {
            this.host = host;
            return this;
        }

        public Builder participants(List<User> participants) {
            this.participants = participants;
            return this;
        }

        public Builder recurrance(Recurring recurrance) {
            this.recurrance = recurrance;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}