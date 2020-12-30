package com.ihu.treasurehunt_front_end.Activities.SettingsActivity;
import android.content.Intent;
import android.os.Bundle;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.Activities.SignInActivity;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.R;


import com.ihu.treasurehunt_front_end.Activities.MainActivity;
import com.ihu.treasurehunt_front_end.Requests.RequestFirstLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;


public class SettingsActivity extends AppCompatActivity {

    protected static Game game;
    protected static RequestFirstLocation requestFirstLocation = new RequestFirstLocation();
    private final RetroFitCreate retroFitCreate = new RetroFitCreate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView btnGoback =  findViewById(R.id.goback);
        TextView btnChangePass =  findViewById(R.id.btnChangePass);
        TextView btnChangeName =  findViewById(R.id.btnLogIn);

        requestFirstLocation.get(retroFitCreate.getJsonPlaceHolderAPI());

        btnGoback.setOnClickListener(v -> finish());

        btnChangeName.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation());
            game.setUserLoggedIn(MainActivity.game.getUserLoggedIn());
            startActivity(new Intent(this, NameChange.class));
        });

        btnChangePass.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation());
            game.setUserLoggedIn(SignInActivity.loginUser.getPassword());
            startActivity(new Intent(this, PasswordChange.class));
        });

    }






}