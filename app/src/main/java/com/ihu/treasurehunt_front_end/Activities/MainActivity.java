package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.Model.AppContainer;
import com.ihu.treasurehunt_front_end.Model.Game;
import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LeaderBoardList;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("StaticFieldLeak")
    protected static AppContainer appContainer;
    protected static Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button leaderBoardButton = (Button) findViewById(R.id.leaderBoardButton);

        TextView btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);

        btnPlayGame.setOnClickListener(v -> {
   startActivity(new Intent(this,MapsActivity.class));
            initializeAppContainer();
            game = new Game(appContainer.mapLocationList.getMapLocationList());
        });

        leaderBoardButton.setOnClickListener(v -> {
            RetroFitCreate retroFitCreate = new RetroFitCreate();
            LeaderBoardList leaderBoardList = new LeaderBoardList();
            leaderBoardList.getLeaderBoard(retroFitCreate.getJsonPlaceHolderAPI());
            new Handler().postDelayed(() -> {
                List<User> leaderBoard = new ArrayList<>();
                leaderBoard = leaderBoardList.getLeaderBoardList();
                for (int i = 0; i<leaderBoard.size();i++)
                {
                    LeaderBoardActivity.textView.append((i++)+leaderBoard.get(i).getName()+"   ");
                    LeaderBoardActivity.textView.append("Score  ->"+leaderBoard.get(i).getToStringScore()+"\n");
                    System.out.println(LeaderBoardActivity.textView);
                }
            },1000);

startActivity(new Intent(this,LeaderBoardActivity.class));
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