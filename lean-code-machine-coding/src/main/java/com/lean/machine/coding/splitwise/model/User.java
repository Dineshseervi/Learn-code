package com.lean.machine.coding.splitwise.model;

public class User {

    private int userId;
    private String name;
    private String email;
    private long mobileNum;

    public User(String name, String email, long mobileNum) {
        this.name = name;
        this.email = email;
        this.mobileNum = mobileNum;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getMobileNum() {
        return mobileNum;
    }
}
