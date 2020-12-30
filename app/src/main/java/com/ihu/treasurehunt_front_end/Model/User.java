package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private String userId;

    @SerializedName("userName")
    private String name;

    @SerializedName("score")
    private int score;

    @SerializedName("password")
    private String password;

    @SerializedName("userLives")
    private int userLives;

    @SerializedName("status")
    private Status status;

    @SerializedName("UserState")
    private UserState userState;

    @SerializedName("userRole")
    private UserRole role;

    public User(String userId, String name, int score, String password, int userLives, Status status, UserState userState, UserRole role) {
        this.userId = userId;
        this.name = name;
        this.score = score;
        this.password = password;
        this.userLives = userLives;
        this.status = status;
        this.userState = userState;
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getPassword() {
        return password;
    }

    public void appendToScore(int score)
    {
        this.score+=score;
    }

    public Integer getUserLives() {
        return userLives;
    }

    public UserRole getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }
}
