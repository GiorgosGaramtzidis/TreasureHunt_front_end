package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.Model.AppContainer;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.R;

public class MainActivity extends AppCompatActivity {

    protected static AppContainer appContainer;
    private Intent mapActivityIntent,loginActivityIntent;
    protected static Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.button);
        TextView btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);

        loginButton.setOnClickListener(v -> startActivity(loginActivityIntent));

        btnPlayGame.setOnClickListener(v -> {
            startActivity(mapActivityIntent);
            initializeAppContainer();
            initializeIntents();
            game = new Game(appContainer.mapLocationList.getMapLocationList());
        });
    }

   public void initializeAppContainer()
   {
       appContainer = new AppContainer();

       appContainer.mapLocationList.getMapLocations
               (appContainer.retroFitCreate.getJsonPlaceHolderAPI());
       appContainer.userList.getUsers
               (appContainer.retroFitCreate.getJsonPlaceHolderAPI());

   }
   public void initializeIntents()
   {
       this.mapActivityIntent = new Intent(this,MapsActivity.class);
       this.loginActivityIntent = new Intent(this,LoginActivity.class);
   }
}