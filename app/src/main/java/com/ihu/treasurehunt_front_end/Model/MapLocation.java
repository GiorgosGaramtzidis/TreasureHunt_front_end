package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class MapLocation {
    @SerializedName("Id")
    private int Id;

    @SerializedName("v")
    private double v;

    @SerializedName("v1")
    private double v1;

    @SerializedName("title")
    private String title;

    @SerializedName("color")
    private String color;

    @SerializedName("question")
    private Location question;


    public MapLocation(int id, double v, double v1, String title, String color, Location question) {
        Id = id;
        this.v = v;
        this.v1 = v1;
        this.title = title;
        this.color = color;
        this.question = question;
       

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

    public Location getQuestion() {
        return question;
    }
}
