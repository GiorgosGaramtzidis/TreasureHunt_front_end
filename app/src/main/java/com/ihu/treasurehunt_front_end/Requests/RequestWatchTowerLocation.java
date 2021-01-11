package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.MapLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestWatchTowerLocation {
    private MapLocation mapLocation;

    public MapLocation getMapLocation() {
        return mapLocation;
    }

    public void getWatchTowerLocation(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<MapLocation> call=jsonPlaceHolderAPI.getWatchTowerLocation();
        call.enqueue(new Callback<MapLocation>() {
            @Override
            public void onResponse(Call<MapLocation> call, Response<MapLocation> response) {
                MapLocation location =response.body();
                mapLocation = new MapLocation(location.getV(),
                        location.getV1(),
                        location.getTitle(),null);
            }

            @Override
            public void onFailure(Call<MapLocation> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
