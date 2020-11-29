package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class MapLocation {
    @SerializedName("Id")
    private final int Id;

    @SerializedName("v")
    private final double v;

    @SerializedName("v1")
    private final double v1;

    @SerializedName("title")
    private final String title;

    @SerializedName("color")
    private final String color;

    @SerializedName("question")
    private final Riddle question;


    public MapLocation(int id, double v, double v1, String title, String color, Riddle question) {
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

    public Riddle getQuestion() {
        return question;
    }
}
