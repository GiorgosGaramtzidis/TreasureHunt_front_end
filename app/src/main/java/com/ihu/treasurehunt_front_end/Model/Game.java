package com.ihu.treasurehunt_front_end.Model;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import static com.google.maps.android.SphericalUtil.computeDistanceBetween;


public class Game
{
    private int gameScore;
    private MapLocation location;
    private String userLoggedIn;
    private Question question;
    private List<Question> questionList = new ArrayList<>();


    public Game(MapLocation mapLocation) {

        this.location = mapLocation;
        this.gameScore = 0;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
        this.questionList.add(question);
    }

    public String getUserLoggedIn() {
        return userLoggedIn;
    }



    public void setUserLoggedIn(String userLoggedIn) {
        this.userLoggedIn = userLoggedIn;
    }

    public int getGameScore() {
        return gameScore;
    }

    public void setGameScore(int gameScore) {
        this.gameScore = gameScore;
    }

    public MapLocation getLocation() {
        return location;
    }


    public void setLocation(MapLocation location) {
        this.location = location;
    }

    public LatLng position(){
        return new LatLng(this.location.getV(),this.location.getV1());
    }

    public MarkerOptions markerOptions(){
        return new MarkerOptions().position(this.position()).title(this.location.getTitle());
    }

    public Marker addFirstLocationToMap(GoogleMap map){
        Marker marker = map.addMarker(this.markerOptions());
        marker.setVisible(false);
        return marker;
    }

    public void DistanceBetween(LatLng latLng,Marker marker){
        double distance;
        distance = computeDistanceBetween(latLng,marker.getPosition());
        marker.setVisible(distance <= 50);
    }

    @Override
    public String toString() {
        return "Game{" +
                "location=" + location +
                '}';
    }
}
