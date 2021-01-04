package com.ihu.treasurehunt_front_end.Requests;

import androidx.annotation.NonNull;

import com.ihu.treasurehunt_front_end.Model.MapLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestCasinoLocation {

    private MapLocation mapLocation;

    public void getCasinoLocation(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<MapLocation> call = jsonPlaceHolderAPI.getCasinoLocation();

        call.enqueue(new Callback<MapLocation>() {
            @Override
            public void onResponse(Call<MapLocation> call, Response<MapLocation> response) {
                MapLocation location =response.body();
                mapLocation = new MapLocation(location.getV(),
                        location.getV1(),
                        location.getTitle(),null);
                System.out.println("========"+response.body());
            }

            @Override
            public void onFailure(Call<MapLocation> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    public MapLocation getMapLocation() {
        return this.mapLocation;
    }


    @Override
    public String toString() {
        return "RequestCasinoLocation{" +
                "mapLocation=" + mapLocation +
                '}';
    }
}
