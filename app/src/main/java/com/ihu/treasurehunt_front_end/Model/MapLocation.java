package com.ihu.treasurehunt_front_end.Model;

import android.location.Location;

import com.google.gson.annotations.SerializedName;

public class MapLocation {

    @SerializedName("v")
    private double v;

    @SerializedName("v1")
    private double v1;

    @SerializedName("title")
    private String title;

    @SerializedName("questions")
    private Question question;

    @SerializedName("nextLocation")
    private String nextLocation;


    public MapLocation(double v, double v1, String title, Question question, String nextLocation) {
        this.v = v;
        this.v1 = v1;
        this.title = title;
        this.question = question;
        this.nextLocation = nextLocation;
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

    public Question getQuestion() {
        return question;
    }

    public String getNextLocation() {
        return nextLocation;
    }

    @Override
    public String toString() {
        return "MapLocation{" +
                "v=" + v +
                ", v1=" + v1 +
                ", title='" + title + '\'' +
                ", question=" + question +
                ", nextLocation=" + nextLocation +
                '}';
    }
}