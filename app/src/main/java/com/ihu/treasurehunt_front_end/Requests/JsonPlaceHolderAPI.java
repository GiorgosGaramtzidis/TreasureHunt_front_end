package com.ihu.treasurehunt_front_end.Requests;


import com.ihu.treasurehunt_front_end.Model.LeaderBoardUsers;
import com.ihu.treasurehunt_front_end.Model.MapLocation;
import com.ihu.treasurehunt_front_end.Model.Question;
import com.ihu.treasurehunt_front_end.Model.RegistrationAnswer;
import com.ihu.treasurehunt_front_end.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderAPI {

    @GET("Questions/find")
    Call<List<Question>> getQuestions();

    @GET("Locations/find")
    Call<List<MapLocation>> getMapLocations();

    @GET("Users/all")
    Call<List<User>> getUsers();

    @GET("LeaderBoard/all")
    Call<List<LeaderBoardUsers>> getLeaderBoard();

    @POST("Questions/addQuestion")
    Call<Question> createQuestion(@Body Question questions);

    @POST("Users/addUsers")
    Call<User> createUser(@Body User user);

    @FormUrlEncoded
    @POST("Users/addUsers")
    Call<User> createUser(
            @Field("userId") int userId,
            @Field("name") String name,
            @Field("score") int score
    );

    @GET("api/Locations/Start")
    Call<MapLocation> getStartLocation();

    @POST("api/Locations/Next")
    Call<MapLocation> getNextLocation(@Query("nextLocation") String nextLocation);

    @PATCH("LoseCondition/updateUserLives")
    Call<Boolean> updateUserLives(@Query("userName") String userName);

    @PATCH("Users/addScore")
    Call<Integer> addScore(@Query("userName") String userName,@Query("score") int score);

    @GET("Users/getUserScore")
    Call<Integer> getUserScore(@Query("userName") String userName);

    @GET("AnswerCheck/AnswerCheck")
    Call<Boolean> checkAnswer(@Query("usersAnswer") String usersAnswer,@Query("locationTitle") String locationTitle);

    @PATCH("Users/setUserState")
    Call<Boolean> setUserState(@Query("userName") String userName,@Query("locationTitle") String locationTitle);

    @GET("Users/checkUserState")
    Call<String> checkUserState();

    @GET("LoseCondition/getUserLives")
    Call<Integer> getUserLives(int userLives);

    @POST("UserRegistration/registerUser")
    Call<RegistrationAnswer>RegisterUser(@Query("username")String userName, @Query("password") String passWord);

    @GET("UserLogin/login")
    Call<User> loginUser(@Query("username") String username, @Query("password") String password);

    @PATCH("UserLogin/logout")
    Call<Void> logoutUser(@Query("username")String username);
    @PATCH("Users/restart")
    Call<Boolean> restartScoreAndLives(@Query("userName") String userName);



}
