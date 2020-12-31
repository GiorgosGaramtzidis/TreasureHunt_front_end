package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TreasureHuntGame {

    @SerializedName("id")
    private final String id;

    @SerializedName("title")
    private final String title;

    @SerializedName("location")
    private final String location;

    @SerializedName("locations")
    private List<MapLocation> locations;

    @SerializedName("Players")
    private List<User> players;

    @SerializedName("CurrentLocations")
    private List<PlayerLocation> playerLocations;

    //Contractor admin uses to create a game
    public TreasureHuntGame(String id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public List<MapLocation> getLocations() {
        return locations;
    }

    public List<User> getPlayers() {
        return players;
    }

    public List<PlayerLocation> getPlayerLocations() {
        return playerLocations;
    }
}
