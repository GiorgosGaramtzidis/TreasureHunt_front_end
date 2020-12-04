package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.MapLocation;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapLocationList {

    List<MapLocation> mapLocationList = new ArrayList<>();

    public List<MapLocation> getMapLocationList() {

        return mapLocationList;
    }

    public void getMapLocations(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<MapLocation>> call = jsonPlaceHolderAPI.getMapLocations();

        call.enqueue(new Callback<List<MapLocation>>() {
            @Override
            public void onResponse(Call<List<MapLocation>> call, Response<List<MapLocation>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<MapLocation> mapLocations =response.body();

                for (MapLocation mapLocation:mapLocations){
                    mapLocationList.add(new MapLocation(
                            mapLocation.getV()
                            ,mapLocation.getV1()
                            ,mapLocation.getTitle()
                            ,mapLocation.getQuestion()
                    ));
                }
            }

            @Override
            public void onFailure(Call<List<MapLocation>> call, Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }
}
