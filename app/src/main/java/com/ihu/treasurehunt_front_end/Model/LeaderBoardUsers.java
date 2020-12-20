package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class LeaderBoardUsers {
    @SerializedName("id")
    private String userId;

    @SerializedName("leaderBoardName")
    private String name;

    @SerializedName("score")
    private int score;


    public LeaderBoardUsers(String userId , String name, int score)
    {
        this.userId= userId;
        this.name = name;
       this.score = score;


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

    public String toString() {
        return  name + score ;

    }








}
