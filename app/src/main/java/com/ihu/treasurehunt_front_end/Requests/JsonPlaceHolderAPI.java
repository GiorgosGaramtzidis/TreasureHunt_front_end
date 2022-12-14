package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.LeaderBoardUsers;
import com.ihu.treasurehunt_front_end.Model.MapLocation;
import com.ihu.treasurehunt_front_end.Model.Question;
import com.ihu.treasurehunt_front_end.Model.RegistrationAnswer;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.Model.WatchTower;

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

    @POST("TreasureHuntGame/createGame")
    Call<Boolean> createGame(@Query("id")String id,@Query("gameName") String gameName,@Query("gameLocation") String gameLocation);

    @GET("Questions/find")
    Call<List<Question>> getQuestions();

    @GET("Locations/find")
    Call<List<MapLocation>> getMapLocations();

    @GET("LeaderBoard/all")
    Call<List<LeaderBoardUsers>> getLeaderBoard();

    @PATCH("LeaderBoard/updateLeaderBoard")
    Call<Boolean> updateLeaderBoardUsers(@Query("leaderBoardName")String leaderBoardName,@Query("score") int score);

    @POST("/api/Question/addQuestion")
    Call<Boolean> createQuestion(@Body Question questions);

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

    @GET("api/Locations/Casino")
    Call<MapLocation> getCasinoLocation();

    @GET("api/Locations/WatchTower")
    Call<MapLocation> getWatchTowerLocation();

    @POST("api/Locations/Next")
    Call<MapLocation> getNextLocation(@Query("nextLocation") String nextLocation);

    @PATCH("LoseCondition/updateUserLives")
    Call<Boolean> updateUserLives(@Query("userName") String userName);

    @PATCH("Users/buyLife")
    Call<Boolean> buyLife(@Query("userName") String userName);

    @PATCH("Casino/updateScore")
    Call<Boolean> updateScore(@Query("userName") String userName);

    @PATCH("Users/addScore")
    Call<Integer> addScore(@Query("userName") String userName,@Query("score") int score);

    @GET("Users/getUserScore")
    Call<Integer> getUserScore(@Query("userName") String userName);

    @PATCH("Users/changeName")
    Call<String> changeName(@Query("userName") String userName,@Query("newName") String newName);

    @PATCH("Users/changePassword")
    Call<String> changePassword(@Query("userName") String userName,@Query("newPass") String newPass);

    @GET("AnswerCheck/AnswerCheck")
    Call<Boolean> checkAnswer(@Query("usersAnswer") String usersAnswer,@Query("Question") String locationTitle);

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

    @GET("Users/boughtAnswer")
    Call<String> boughtAnswer(@Query("userName") String userName, @Query("question") String question);

    @GET("api/Question/getRandomQuestion")
    Call<Question> getRandomQuestion();

    @POST("api/Question/getNewQuestion")
    Call<Question> getNewQuestion(@Body List<Question> questionList);

    @GET("WatchTower/WatchTowerList")
    Call<List<WatchTower>>  getWatchTower();

    @POST("WatchTower/addInWatchTower")
    Call<WatchTower> addInWatchTower(@Query("userName") String userName,@Query("locationTitle") String locationTitle);

    @PATCH("WatchTower/resetWatchTower")
    Call<Boolean> resetWatchTower();

}
