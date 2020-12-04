package com.ihu.treasurehunt_front_end.Model;

import android.annotation.SuppressLint;
import android.widget.ProgressBar;

import com.ihu.treasurehunt_front_end.Requests.MapLocationList;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Requests.UserList;

public class AppContainer
{

    public RetroFitCreate retroFitCreate = new RetroFitCreate();
    public MapLocationList mapLocationList = new MapLocationList();
    public UserList userList = new UserList();
    @SuppressLint("StaticFieldLeak")
    public static ProgressBar progressBar;

}
