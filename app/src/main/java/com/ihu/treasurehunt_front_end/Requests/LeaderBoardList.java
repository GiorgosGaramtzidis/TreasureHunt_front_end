package com.ihu.treasurehunt_front_end.Requests;


import com.ihu.treasurehunt_front_end.Model.LeaderBoardUsers;
import com.ihu.treasurehunt_front_end.Model.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardList {

    private final List<LeaderBoardUsers> leaderBoardList = new ArrayList<>();


    public List<LeaderBoardUsers> getLeaderBoardList() {
        return leaderBoardList;
    }

    public void getLeaderBoard(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<LeaderBoardUsers>> call = jsonPlaceHolderAPI.getLeaderBoard();

        call.enqueue(new Callback<List<LeaderBoardUsers>>() {
            @Override
            public void onResponse(@NotNull Call<List<LeaderBoardUsers>> call, @NotNull Response<List<LeaderBoardUsers>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<LeaderBoardUsers> leaderBoard =response.body();
                for (LeaderBoardUsers leaderBoardUsers:leaderBoard){
                    leaderBoardList.add(new LeaderBoardUsers(leaderBoardUsers.getUserId()
                            ,leaderBoardUsers.getName()
                            ,leaderBoardUsers.getGames()));
                }

            }
            @Override
            public void onFailure(Call<List<LeaderBoardUsers>> call, @NotNull Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }


}
