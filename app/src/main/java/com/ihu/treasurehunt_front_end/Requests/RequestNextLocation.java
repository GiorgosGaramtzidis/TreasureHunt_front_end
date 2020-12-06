package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.MapLocation;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestNextLocation {


    public MapLocation getMapLocationNext() {
        return mapLocationNext;
    }

    public void setMapLocationNext(MapLocation mapLocationNext) {
        this.mapLocationNext = mapLocationNext;
    }

    private MapLocation mapLocationNext;



    public void getNextLocation(JsonPlaceHolderAPI jsonPlaceHolderAPI, MapLocation mapLocation){
        Call<MapLocation> call = jsonPlaceHolderAPI.getNextLocation(mapLocation);

        call.enqueue(new Callback<MapLocation>() {
            @Override
            public void onResponse(Call<MapLocation> call, Response<MapLocation> response) {
                System.out.println("======================================SUCCESS====================");

                MapLocation location =response.body();
                mapLocationNext = new MapLocation(location.getV(),
                        location.getV1(),
                        location.getTitle(),
                        location.getQuestion(),
                        location.getNextLocation());

                System.out.println(mapLocationNext);

            }

            @Override
            public void onFailure(Call<MapLocation> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }



    @Override
    public String toString() {
        return "RequestFirstLocation{" +
                "mapLocation=" + mapLocationNext +
                '}';
    }
}
