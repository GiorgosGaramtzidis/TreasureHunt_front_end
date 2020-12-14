package com.ihu.treasurehunt_front_end.Activities.SettingsActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.Activities.MapsActivity;
import com.ihu.treasurehunt_front_end.Activities.SignInActivity;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.R;


import com.ihu.treasurehunt_front_end.Activities.MainActivity;
import com.ihu.treasurehunt_front_end.Requests.RequestFirstLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import java.text.BreakIterator;

import static com.ihu.treasurehunt_front_end.Activities.SignInActivity.loginPost;


public class SettingsActivity extends AppCompatActivity {

    protected static Game game;
    protected static RequestFirstLocation requestFirstLocation = new RequestFirstLocation();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        TextView btnGoback = (TextView) findViewById(R.id.goback);
        TextView btnChangePass = (TextView) findViewById(R.id.btnChangePass);
        TextView btnChangeName = (TextView) findViewById(R.id.btnChangeName);

        requestFirstLocation.get(retroFitCreate.getJsonPlaceHolderAPI());



        btnGoback.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        btnChangeName.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation());
            game.setUserLoggedIn(MainActivity.game.getUserLoggedIn());
            startActivity(new Intent(this, NameChange.class));
        });

        btnChangePass.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation());
            game.setUserLoggedIn(SignInActivity.loginPost.getUserPass());
            startActivity(new Intent(this, PasswordChange.class));
        });

    }






}