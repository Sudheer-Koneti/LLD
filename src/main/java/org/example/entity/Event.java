package org.example.entity;

import org.example.Enum.Recurring;

import java.time.LocalDateTime;
import java.util.List;

public class Event {

    private String eventId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private User Host;
    private List<User> participants;
    private Recurring recurrance;

}
