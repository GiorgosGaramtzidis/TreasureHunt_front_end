package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.Model.AppContainer;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.R;

public class MainActivity extends AppCompatActivity {

    protected static AppContainer appContainer;
    protected static Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);

        btnPlayGame.setOnClickListener(v -> {
            startActivity(new Intent(this,MapsActivity.class));
            initializeAppContainer();
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
}