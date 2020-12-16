    package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoseCondition {

    private Boolean hasLost;

    public Boolean getHasLost() {
        return hasLost;
    }

    public void get(JsonPlaceHolderAPI jsonPlaceHolderAPI, String userName){
        Call<Boolean> call = jsonPlaceHolderAPI.updateUserLives(userName);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if(!response.isSuccessful()){
                    System.out.println(response.code());
                    return;
                }
                hasLost =response.body();
                System.out.println(hasLost);

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }




        }


