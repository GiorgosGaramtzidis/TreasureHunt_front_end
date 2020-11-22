package com.ihu.treasurehunt_front_end.Model;

public class UsersQuest {
    public int userId;
    public String name;
    public int score;
    private int userPosition;
    public String password;

    public UsersQuest(int userId, String name, int score, String password) {
        this.userId = userId;
        this.name = name;
        this.score = score;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(int userPosition) {
        this.userPosition = userPosition;
    }
}

