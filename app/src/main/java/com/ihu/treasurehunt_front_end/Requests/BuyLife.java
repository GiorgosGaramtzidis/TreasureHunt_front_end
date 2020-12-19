package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuyLife {
    private Boolean hasBoughtLife;

    public Boolean getHasBoughtLife() {
        return hasBoughtLife;
    }

    public void buyALife(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName){
        Call<Boolean> call = jsonPlaceHolderAPI.buyLife(userName);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(!response.isSuccessful()){
                    System.out.println(response.code());
                    return;
                }
                hasBoughtLife =response.body();
                System.out.println(hasBoughtLife);

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
