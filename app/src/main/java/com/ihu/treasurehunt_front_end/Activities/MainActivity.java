package com.ihu.treasurehunt_front_end.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ihu.treasurehunt_front_end.Activities.SettingsActivity.SettingsActivity;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LogOutRequest;
import com.ihu.treasurehunt_front_end.Requests.LoginPost;
import com.ihu.treasurehunt_front_end.Requests.RequestFirstLocation;
import com.ihu.treasurehunt_front_end.Requests.RestartScoreAndLives;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {



    public static Game game;
    public static Game game;
    protected static RequestFirstLocation requestFirstLocation = new RequestFirstLocation();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();

    private ViewPager mViewPager;

    private final RetroFitCreate retroFitCreate = new RetroFitCreate();
    private RestartScoreAndLives restartScoreAndLives = new RestartScoreAndLives();
    private LoginPost loginPost = new LoginPost();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restartScoreAndLives.restartScoreAndLives(retroFitCreate.getJsonPlaceHolderAPI(),SignInActivity.loginUser.getName());

        requestFirstLocation.get(retroFitCreate.getJsonPlaceHolderAPI());

        TextView btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);

        Button btnSettings = (Button) findViewById(R.id.btnSettings);

        btnSettings.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation());
            game.setUserLoggedIn(SignInActivity.loginPost.getUserLoggedIn());
            startActivity(new Intent(this, SettingsActivity.class));
        });

        TextView username = findViewById(R.id.userName);
        TextView status = findViewById(R.id.userStatus);
        TextView id = findViewById(R.id.userId);

        username.append(SignInActivity.loginUser.getName());
        id.append(SignInActivity.loginUser.getUserId());
        status.append(SignInActivity.loginUser.getStatus().toString());

        Button exitApp = findViewById(R.id.logOut);


        exitApp.setOnClickListener(v ->{
            LogOutRequest logOutRequest = new LogOutRequest();
            logOutRequest.logOutUser(retroFitCreate.getJsonPlaceHolderAPI(),SignInActivity.loginUser.getName());
            new Handler().postDelayed(() ->{
                System.exit(0);
            },1000);

        });

        btnPlayGame.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation());
            game.setUserLoggedIn(SignInActivity.loginPost.getUserLoggedIn());
            startActivity(new Intent(this, MapsActivity.class));
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
