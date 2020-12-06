package com.ihu.treasurehunt_front_end.Requests;


import com.ihu.treasurehunt_front_end.Model.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardList {

    private final List<User> leaderBoardList = new ArrayList<>();


    public List<User> getLeaderBoardList() {
        return leaderBoardList;
    }

    public void getLeaderBoard(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<User>> call = jsonPlaceHolderAPI.getLeaderBoard();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
            List<User> userList =response.body();
            for (User user:userList){
                leaderBoardList.add(new User(user.getUserId()
                        ,user.getName()
                        ,user.getScore()
                        ,user.getPassword()));
            }
        }
            @Override
            public void onFailure(Call<List<User>> call, @NotNull Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }


}
