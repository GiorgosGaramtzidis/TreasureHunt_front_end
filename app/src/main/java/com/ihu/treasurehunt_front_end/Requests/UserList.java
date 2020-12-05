package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserList {

    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }
    public void getUsers(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<User>> call = jsonPlaceHolderAPI.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<User> users =response.body();

                for (User user:users){
                    userList.add(new User(user.getUserId()
                                    ,user.getName()
                                    ,user.getScore()
                                    ,user.getPassword()
                                    ,user.getUserLives()));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }

    public void createUser(JsonPlaceHolderAPI jsonPlaceHolderAPI,String id,String name,String password,int userLives){
        User user = new User(id,name,0,password,userLives);
        Call<User> call = jsonPlaceHolderAPI.createUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    return;
                }
                User userResponse = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                //MainActivity.textViewResult.setText(t.getMessage());
            }
        });
    }

}
