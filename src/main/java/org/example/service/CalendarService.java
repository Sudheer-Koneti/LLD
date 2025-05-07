package org.example.service;

import org.example.entity.User;

import java.util.HashMap;
import java.util.Map;

public class CalendarService {

    private Map<Long, User> userData = new HashMap<>();

    User  user1 = new User("1", "John Doe", "password123");
}
