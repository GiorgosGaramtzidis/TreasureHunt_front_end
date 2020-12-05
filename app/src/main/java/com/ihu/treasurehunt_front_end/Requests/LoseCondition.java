    package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoseCondition {

    private User user = new User("7","Ath",0,"4546",9);
    private int lives;


    public void get(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<Integer> call = jsonPlaceHolderAPI.updateUserLives(user);

        call.enqueue(new Callback<Integer>() {
            @Override
            public void onResponse(Call<Integer> call, Response<Integer> response) {
                if(!response.isSuccessful()){
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++SUCCESS====================Code: "+ response.code());
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

    public Integer getLives(){
        return lives;
    }
    public User getUser(){
        return user;
    }



        }


