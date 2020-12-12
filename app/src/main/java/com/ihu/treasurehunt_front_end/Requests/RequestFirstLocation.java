package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.MapLocation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RequestFirstLocation {


    private MapLocation mapLocation;



    public void get(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<MapLocation> call = jsonPlaceHolderAPI.getStartLocation();

        call.enqueue(new Callback<MapLocation>() {
            @Override
            public void onResponse(Call<MapLocation> call, Response<MapLocation> response) {
                System.out.println("======================================SUCCESS====================");

                MapLocation location =response.body();
                mapLocation = new MapLocation(location.getV(),
                        location.getV1(),
                        location.getTitle(),
                        location.getQuestion(),
                        location.getNextLocation());

                System.out.println(mapLocation);

            }

            @Override
            public void onFailure(Call<MapLocation> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

    public void setMapLocation(MapLocation mapLocation) {
        this.mapLocation = mapLocation;
    }

    public MapLocation getLocation(){
        return this.mapLocation;
    }

    @Override
    public String toString() {
        return "RequestFirstLocation{" +
                "mapLocation=" + mapLocation +
                '}';
    }
}