package org.example;

import org.example.Enum.Recurring;
import org.example.entity.Event;
import org.example.entity.User;
import org.example.service.CalendarService;
import org.example.service.UserService;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        CalendarService calendarService = new CalendarService(userService);

        // Add users
        userService.addUser(new User(1L, "John Doe", "password123"));
        userService.addUser(new User(2L, "Jane Smith", "securePass"));

        // Login attempts
        if(userService.login(1L, "password123")){
            System.out.println("User 1 logged in successfully.");
        } else {
            System.out.println("User 1 login failed.");
        }
        if(userService.login(2L, "wrongPass")){
            System.out.println("User 2 logged in successfully.");
        } else {
            System.out.println("User 2 login failed.");
        }
        //add events to user 1
        userService.getCalendar(1L).addEvent(new Event.Builder(1L)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusHours(2))
                .host(userService.getUser(1L))
                .recurrance(Recurring.DAILY)
                .build());
        // Get events for user 1
        System.out.println("Events for User 1:" + calendarService.getEventsByUserID(1L));
        //create event with userid host;



    }
}