package org.example.service;

import org.example.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    private Map<Long, User> userData = new HashMap<>();

    public void addUser(User user) {
        if(user!=null && user.getUserId() != null ){
            if(!userData.containsKey(user.getUserId())) {
                userData.put(user.getUserId(), user);
            }else{
                System.out.println("User already exists.");
            }
        } else {
            System.out.println("Invalid user data.");
        }
    }

    public boolean login(Long userId, String password) {
        User user = userData.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful for user: " + user.getUserId());
            return true;
        } else {
            System.out.println("Invalid user ID or password.");
            return false;
        }
    }

    public void getCalendar(Long userId) {
        User user = userData.get(userId);
        if (user != null) {
            System.out.println("Calendar for user: " + user.getUserId());
            user.getCalendar().getEventsofToday().forEach(event -> {
                System.out.println("Event: " + event.g());
            });
        } else {
            System.out.println("User not found.");
        }
    }
}
