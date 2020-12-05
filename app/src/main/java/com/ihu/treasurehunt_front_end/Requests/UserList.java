package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.User;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserList {

    private final List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }
    public void getUsers(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<User>> call = jsonPlaceHolderAPI.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NotNull Call<List<User>> call, @NotNull Response<List<User>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<User> users =response.body();

                for (User user:users){
                    userList.add(new User(user.getUserName()
                                    ,user.getPassword()));
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, @NotNull Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }

    public void createUser(JsonPlaceHolderAPI jsonPlaceHolderAPI,String name,String password){
        User user = new User(name,password);
        Call<User> call = jsonPlaceHolderAPI.createUser(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NotNull Call<User> call, Response<User> response) {
                if(!response.isSuccessful()){
                    //MainActivity.textViewResult.setText("Code: "+ response.code());
                    return;
                }
                User userResponse = response.body();
            }

            @Override
            public void onFailure(Call<User> call, @NotNull Throwable t) {
                //MainActivity.textViewResult.setText(t.getMessage());
            }
        });
    }

}
