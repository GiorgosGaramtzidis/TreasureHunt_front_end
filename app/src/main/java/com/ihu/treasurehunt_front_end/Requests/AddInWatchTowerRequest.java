package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.WatchTower;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddInWatchTowerRequest {
    private WatchTower watchTower;
    public WatchTower getWatchTower(){
        return watchTower;
    }

    public void addInWatchTower(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName, String locationTitle){
        Call<WatchTower> call = jsonPlaceHolderAPI.addInWatchTower(userName, locationTitle);
        call.enqueue(new Callback<WatchTower>() {
            @Override
            public void onResponse(Call<WatchTower> call, Response<WatchTower> response) {
                WatchTower watchTowerResponse = response.body();
                watchTower=new WatchTower(watchTowerResponse.getUserName()
                        ,watchTowerResponse.getLocationTitle());
            }

            @Override
            public void onFailure(Call<WatchTower> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
