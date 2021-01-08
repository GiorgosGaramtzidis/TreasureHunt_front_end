package com.ihu.treasurehunt_front_end.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ihu.treasurehunt_front_end.Activities.SettingsActivity.SettingsActivity;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LogOutRequest;
import com.ihu.treasurehunt_front_end.Requests.RequestCasinoLocation;
import com.ihu.treasurehunt_front_end.Service.LoginService;
import com.ihu.treasurehunt_front_end.Requests.RequestFirstLocation;
import com.ihu.treasurehunt_front_end.Requests.RequestRandomQuestion;
import com.ihu.treasurehunt_front_end.Requests.RestartScoreAndLives;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    public static Game game;
    protected static RequestFirstLocation requestFirstLocation = new RequestFirstLocation();
    protected static RequestRandomQuestion requestRandomQuestion = new RequestRandomQuestion();
    private final RetroFitCreate retroFitCreate = new RetroFitCreate();
    private RestartScoreAndLives restartScoreAndLives = new RestartScoreAndLives();
    protected static RequestCasinoLocation requestCasinoLocation = new RequestCasinoLocation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.leaderBoardButton);

        restartScoreAndLives.restartScoreAndLives(retroFitCreate.getJsonPlaceHolderAPI(),SignInActivity.loginUser.getName());
        requestFirstLocation.get(retroFitCreate.getJsonPlaceHolderAPI());
        requestRandomQuestion.getRandomQuestion(retroFitCreate.getJsonPlaceHolderAPI());
        requestCasinoLocation.getCasinoLocation((retroFitCreate.getJsonPlaceHolderAPI()));

        TextView btnPlayGame =  findViewById(R.id.btnPlayGame);
        Button exitApp = findViewById(R.id.logOut);
        Button btnSettings =  findViewById(R.id.btnSettings);
        TextView username = findViewById(R.id.userName);
        TextView status = findViewById(R.id.userStatus);
        TextView id = findViewById(R.id.userId);


        username.append(SignInActivity.loginUser.getName());
        id.append(SignInActivity.loginUser.getUserId());
        status.append(SignInActivity.loginUser.getStatus().toString());

        button.setOnClickListener(v -> {
            startActivity(new Intent(this,LeaderBoardActivity.class));
        });

        btnSettings.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation(),requestCasinoLocation.getMapLocation());
            game.setUserLoggedIn(SignInActivity.loginUser.getName());
            startActivity(new Intent(this, SettingsActivity.class));
        });


        exitApp.setOnClickListener(v ->{
            LogOutRequest logOutRequest = new LogOutRequest();
            logOutRequest.logOutUser(retroFitCreate.getJsonPlaceHolderAPI(),SignInActivity.loginUser.getName());
            new Handler().postDelayed(() ->{
                System.exit(0);
            },1000);

        });

        btnPlayGame.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation(),requestCasinoLocation.getMapLocation());
            game.setQuestion(requestRandomQuestion.getQuestion());
            game.setUserLoggedIn(SignInActivity.loginUser.getName());
            startActivity(new Intent(this,MapsActivity.class));
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        restartScoreAndLives.restartScoreAndLives(retroFitCreate.getJsonPlaceHolderAPI(),SignInActivity.loginUser.getName());
    }

}