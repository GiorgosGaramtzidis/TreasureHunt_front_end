package com.ihu.treasurehunt_front_end.Requests;


import com.ihu.treasurehunt_front_end.Model.LeaderBoardUsers;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeaderBoardList {

    private final List<LeaderBoardUsers> leaderBoardList = new ArrayList<>();
    private  Boolean updateLeaderBoard;


    public Boolean getUpdateLeaderBoard() {
        return updateLeaderBoard;
    }

    public void updateLeaderBoard(JsonPlaceHolderAPI jsonPlaceHolderAPI, String leaderBoardUserName,int score) {
        Call<Boolean> call = jsonPlaceHolderAPI.updateLeaderBoardUsers(leaderBoardUserName,score);

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (!response.isSuccessful()) {
                    System.out.println(response.code());
                    return;
                }
                updateLeaderBoard = response.body();
                System.out.println(updateLeaderBoard);

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }







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
                            ,leaderBoardUsers.getScore()));
                }

            }
            @Override
            public void onFailure(Call<List<LeaderBoardUsers>> call, @NotNull Throwable t) {
                System.out.println(t.getMessage());            }
        });

    }


}
