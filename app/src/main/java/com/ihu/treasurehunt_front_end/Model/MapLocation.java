package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class MapLocation {
    @SerializedName("Id")
    public int Id;

    @SerializedName("v")
    public double v;

    @SerializedName("v1")
    public double v1;

    @SerializedName("title")
    public String title;

    @SerializedName("color")
    public String color;

    public MapLocation(int id, double v, double v1, String title, String color) {
        Id = id;
        this.v = v;
        this.v1 = v1;
        this.title = title;
        this.color = color;
    }

    public int getId() {
        return Id;
    }

    public double getV() {
        return v;
    }

    public double getV1() {
        return v1;
    }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }
}
