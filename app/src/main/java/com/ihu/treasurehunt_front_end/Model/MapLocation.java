package com.ihu.treasurehunt_front_end.Model;

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


    public MapLocation( double v, double v1, String title,Question question) {

        this.v = v;
        this.v1 = v1;
        this.title = title;

        this.question = question;
       

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


    @Override
    public String toString() {
        return "MapLocation{" +
                " v=" + v +
                ", v1=" + v1 +
                ", title='" + title + '\'' +
                ", question=" + question +
                '}';
    }
}
