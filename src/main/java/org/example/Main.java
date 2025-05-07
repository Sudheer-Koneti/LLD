package org.example;


import org.example.entity.User;
import org.example.service.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();

        // Add users
        userService.addUser(new User(1L, "John Doe", "password123"));
        userService.addUser(new User(2L, "Jane Smith", "securePass"));

        // Login attempts
        if(userService.login(1L, "password123")){
            System.out.println("User 1 logged in successfully.");
        } else {
            System.out.println("User 1 login failed.");
        } // Successful
        userService.login(2L, "wrongPass");
    }
}