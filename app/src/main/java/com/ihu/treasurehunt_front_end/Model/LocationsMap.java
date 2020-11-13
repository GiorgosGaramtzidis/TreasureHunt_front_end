package com.ihu.treasurehunt_front_end.Model;

public class LocationsMap {

    private int Id;
    private double v;
    private  double v1;
    private String title;
    private String color;

    public LocationsMap(int id, double v, double v1, String title, String color) {
        Id = id;
        this.v = v;
        this.v1 = v1;
        this.title = title;
        this.color = color;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public double getV1() {
        return v1;
    }

    public void setV1(double v1) {
        this.v1 = v1;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
