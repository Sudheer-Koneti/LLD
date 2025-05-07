package org.example.entity;


public class User {
    private final Long userId;
    private String userName;
    private String password;
    private Calendar calendar;

    public User(Long userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.calendar = new Calendar(this);
    }
    public Long getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Calendar getCalendar() {
        return calendar;
    }

}
