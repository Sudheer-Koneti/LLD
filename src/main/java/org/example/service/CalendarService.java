package org.example.service;

import org.example.entity.Calendar;
import org.example.entity.Event;
import java.util.Collections;
import java.util.List;

public class CalendarService {

    private final UserService userService ;

    public CalendarService (UserService userService) {
       this.userService = userService;
    }
    public List<Event> geteventsByuserid(Long userId){

        if (userId != null) {
            Calendar calendar = userService.getCalendar(userId);
            return calendar.getAllEvents();
        } else {
            System.out.println("User not found.");
            return Collections.emptyList();
        }
    }


}
