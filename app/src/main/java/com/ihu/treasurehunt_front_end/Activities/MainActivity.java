package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.Model.AppContainer;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LoginPost;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    protected static AppContainer appContainer = new AppContainer();
    protected static Game game;
    private LoginPost loginPost = new LoginPost();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);
        loginPost.LoginUserPost(appContainer.retroFitCreate.getJsonPlaceHolderAPI());
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