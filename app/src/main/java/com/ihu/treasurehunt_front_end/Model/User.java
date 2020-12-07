package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userId")
    private final int userId;

    @SerializedName("userName")
    private final String name;

    @SerializedName("score")
    private final int score;

    @SerializedName("password")
    private final String password;

    public User(int userId, String name, int score, String password) {
        this.userId = userId;
        this.name = name;
        this.score = score;
        this.password = password;
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

    public String getToStringScore(){return  String.valueOf(score);}

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", password='" + password + '\'' +
                '}';
    }

    /*
    public void appendToScore(int score)
    {
        this.score+=score;
    }
    */

}
