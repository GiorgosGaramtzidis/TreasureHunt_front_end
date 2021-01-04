package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CasinoRequest {

    private Boolean hasWonRisk;

    public Boolean getHasWonRisk() {
        return hasWonRisk;
    }

    public void updateScore(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName){
        Call<Boolean> call = jsonPlaceHolderAPI.updateScore(userName);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(!response.isSuccessful()){
                    System.out.println(response.code());
                    return;
                }
                hasWonRisk = response.body();
                System.out.println(hasWonRisk);
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
