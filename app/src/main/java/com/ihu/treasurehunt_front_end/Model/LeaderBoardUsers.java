package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class LeaderBoardUsers {
    @SerializedName("id")
    private String userId;

    @SerializedName("leaderBoardName")
    private String name;

    @SerializedName("games")
    private int games;



    public LeaderBoardUsers(String userId , String name, int games)
    {
        this.userId= userId;
        this.name = name;
       this.games = games;


    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getGames() {
        return games;
    }
    @Override
    public String toString() {
        return "Question{" +
                "question='" + userId + '\'' +
                ", answer='" + name + '\'' +
                ", points=" + games +
                '}';
    }
}
