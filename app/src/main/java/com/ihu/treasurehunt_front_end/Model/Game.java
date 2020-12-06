package com.ihu.treasurehunt_front_end.Model;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ihu.treasurehunt_front_end.Activities.MainActivity;

import static com.google.maps.android.SphericalUtil.computeDistanceBetween;


public class Game
{
    private int progress;
    private int gameScore;
    private MapLocation location;
    private MapLocation nextLocation;



    public Game(MapLocation mapLocation) {
        this.nextLocation = mapLocation;
        this.location = mapLocation;
        this.progress = 0;
        this.gameScore = 0;
    }

    public MapLocation getNextLocation() {
        return nextLocation;
    }

    public void setNextLocation(MapLocation nextLocation) {
        this.nextLocation = nextLocation;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
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

    //nextLocationService

    public LatLng pos(){
        nextLocation.getNextLocation();
        return new LatLng(this.nextLocation.getV(),this.nextLocation.getV1());
    }

    public MarkerOptions markerOption1(){
        nextLocation.getNextLocation();
        return new MarkerOptions().position(this.pos()).title(this.nextLocation.getTitle());
    }
    public Marker nextMarker(GoogleMap map){
        nextLocation.getNextLocation();
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
