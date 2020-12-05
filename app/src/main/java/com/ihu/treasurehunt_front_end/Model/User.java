package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("userId")
    private final String userId;

    @SerializedName("userName")
    private final String userName;

    @SerializedName("score")
    private final int score;

    @SerializedName("password")
    private final String password;

    public User(String name,String password) {
        this.userName = name;
        this.score = 0;
        this.password = password;
        this.userId ="";
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getScore() {
        return score;
    }

    public String getPassword() {
        return password;
    }


}