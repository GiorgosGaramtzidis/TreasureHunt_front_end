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

    @SerializedName("nextLocation")
    private String nextLocation;


    public MapLocation(double v, double v1, String title, String nextLocation) {
        this.v = v;
        this.v1 = v1;
        this.title = title;
        this.nextLocation = nextLocation;
    }

    public MapLocation() {
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



    public String getNextLocation() {
        return nextLocation;
    }

    public void setV(double v) {
        this.v = v;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setNextLocation(String nextLocation) {
        this.nextLocation = nextLocation;
    }

    @Override
    public String toString() {
        return "MapLocation{" +
                "v=" + v +
                ", v1=" + v1 +
                ", title='" + title + '\'' +
                ", nextLocation=" + nextLocation +
                '}';
    }
}
