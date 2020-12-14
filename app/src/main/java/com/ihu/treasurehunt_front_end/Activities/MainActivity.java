package com.ihu.treasurehunt_front_end.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LogOutRequest;
import com.ihu.treasurehunt_front_end.Requests.LoginPost;
import com.ihu.treasurehunt_front_end.Requests.RequestFirstLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {


    public static Game game;
    protected static RequestFirstLocation requestFirstLocation = new RequestFirstLocation();
    private final RetroFitCreate retroFitCreate = new RetroFitCreate();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestFirstLocation.get(retroFitCreate.getJsonPlaceHolderAPI());

        TextView btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);

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
            game.setUserLoggedIn(SignInActivity.loginUser.getName());
            startActivity(new Intent(this,MapsActivity.class));
        });
    }


}