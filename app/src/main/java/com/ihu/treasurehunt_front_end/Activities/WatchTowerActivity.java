package com.ihu.treasurehunt_front_end.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Requests.WatchTowerListRequest;

public class WatchTowerActivity extends AppCompatActivity {
    protected static TextView names;
    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private WatchTowerListRequest watchTowerListRequest = new WatchTowerListRequest();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_tower);
        names =findViewById(R.id.names);
        watchTowerListRequest.getWatchTower(retroFitCreate.getJsonPlaceHolderAPI());
        new Handler().postDelayed(() -> {
            for (int i=0;i<watchTowerListRequest.getWatchTowerList().size();i++){
                names.append(watchTowerListRequest.getWatchTowerList().get(i).getUserName()+"                     "+watchTowerListRequest.getWatchTowerList().get(i).getLocationTitle()+"\n");
            }
        },1000);

        }
    }