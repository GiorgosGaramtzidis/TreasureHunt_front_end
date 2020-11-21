package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userId")
    private int userId;

    @SerializedName("name")
    private String name;

    @SerializedName("score")
    private int score;

    public User(int userId, String name, int score) {
        this.userId = userId;
        this.name = name;
        this.score = score;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
