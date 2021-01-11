package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.WatchTower;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WatchTowerListRequest {
    private List<WatchTower> watchTowerList = new ArrayList<>();

    public List<WatchTower> getWatchTowerList() {
        return watchTowerList;
    }

    public void getWatchTower(JsonPlaceHolderAPI jsonPlaceHolderAPI) {
        Call<List<WatchTower>> call = jsonPlaceHolderAPI.getWatchTower();
        call.enqueue(new Callback<List<WatchTower>>() {
            @Override
            public void onResponse(Call<List<WatchTower>> call, Response<List<WatchTower>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<WatchTower> watchTower =response.body();
                for (WatchTower watchTower1:watchTower){
                    watchTowerList.add(new WatchTower(watchTower1.getUserName()
                            ,watchTower1.getLocationTitle()));
                }
            }

            @Override
            public void onFailure(Call<List<WatchTower>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
