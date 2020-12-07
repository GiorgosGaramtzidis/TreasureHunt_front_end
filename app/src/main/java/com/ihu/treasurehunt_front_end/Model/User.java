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

    public User(String userId, String name, int score, String password, Integer userLives) {
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
}
