package com.ihu.treasurehunt_front_end.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.ihu.treasurehunt_front_end.Activities.SettingsActivity.SettingsActivity;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.RequestFirstLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {



    public static Game game;
    protected static RequestFirstLocation requestFirstLocation = new RequestFirstLocation();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestFirstLocation.get(retroFitCreate.getJsonPlaceHolderAPI());

        TextView btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);

        Button btnSettings = (Button) findViewById(R.id.btnSettings);

        btnSettings.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation());
            game.setUserLoggedIn(SignInActivity.loginPost.getUserLoggedIn());
            startActivity(new Intent(this, SettingsActivity.class));
        });

        btnPlayGame.setOnClickListener(v -> {
            game = new Game(requestFirstLocation.getLocation());
            game.setUserLoggedIn(SignInActivity.loginPost.getUserLoggedIn());
            startActivity(new Intent(this, MapsActivity.class));
        });


    }
}
