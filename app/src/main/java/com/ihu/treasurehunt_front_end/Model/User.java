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
    private Integer userLives;

    @SerializedName("status")
    private Status status;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @SerializedName("Role")
    private Role role;

    public User(String name , String password)
    {
        this.name = name;
        this.password=password;
        this.score = 0;
        this.userLives = 5;
        this.role = Role.PLAYER;
    }
    public User(){
        this.userId = userId;
        this.name = name;
        this.score = score;
        this.password = password;
        this.userLives = userLives;
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

    public Role getRole() {
        return role;
    }

    public Status getStatus() {
        return status;
    }
}
