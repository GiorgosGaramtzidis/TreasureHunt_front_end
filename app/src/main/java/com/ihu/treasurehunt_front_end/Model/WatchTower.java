package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class WatchTower {
    @SerializedName("userName")
    private String userName;
    @SerializedName("locationTitle")
    private String locationTitle;

    public WatchTower(String userName, String locationTitle) {
        this.userName = userName;
        this.locationTitle = locationTitle;
    }


    public String getLocationTitle() {
        return locationTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setLocationTitle(String locationTitle) {
        this.locationTitle = locationTitle;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
