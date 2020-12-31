package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class PlayerLocation {
    @SerializedName("v")
    private double v;

    @SerializedName("v1")
    private double v1;

    @SerializedName("playerUserName")
    private String playerUserName;

    public PlayerLocation(double v, double v1, String playerUserName) {
        this.v = v;
        this.v1 = v1;
        this.playerUserName = playerUserName;
    }

    public double getV() {
        return v;
    }

    public double getV1() {
        return v1;
    }

    public String getPlayerUserName() {
        return playerUserName;
    }
}
