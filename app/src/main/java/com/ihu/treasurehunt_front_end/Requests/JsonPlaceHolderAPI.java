package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.MapLocation;
import com.ihu.treasurehunt_front_end.Model.Riddle;
import com.ihu.treasurehunt_front_end.Model.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderAPI {

    @GET("Questions/find")
    Call<List<Riddle>> getQuestions();

    @GET("Locations/find")
    Call<List<MapLocation>> getMapLocations();

    @GET("Users/all")
    Call<List<User>> getUsers();

    @POST("Questions/addQuestion")
    Call<Riddle> createQuestion(@Body Riddle questions);

    @POST("Users/addUsers")
    Call<User> createUser(@Body User user);

    @POST("Users/registerUser")
    Call<User> RegisterUser(@Body User user);

    @FormUrlEncoded
    @POST("Users/addUsers")
    Call<User> createUser(
            @Field("userId") int userId,
            @Field("name") String name,
            @Field("score") int score
    );
}