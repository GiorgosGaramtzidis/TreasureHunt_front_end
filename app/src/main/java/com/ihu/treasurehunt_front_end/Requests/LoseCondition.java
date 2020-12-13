    package com.ihu.treasurehunt_front_end.Requests;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoseCondition {

    private int lives;


    public void get(JsonPlaceHolderAPI jsonPlaceHolderAPI,String userName){
        Call<Integer> call = jsonPlaceHolderAPI.updateUserLives(userName);

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if(!response.isSuccessful()){
                    System.out.println(response.code());
                    return;
                }
                lives =response.body();
                System.out.println(lives);

            }

            @Override
            public void onFailure(Call<Integer> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }




        }


