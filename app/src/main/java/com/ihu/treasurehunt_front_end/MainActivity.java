package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;
import com.ihu.treasurehunt_front_end.Requests.MapLocationList;
import com.ihu.treasurehunt_front_end.Requests.QuestionList;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Requests.UserList;

public class MainActivity extends AppCompatActivity {

    private TextView btnPlayGame;
    private Button loginButton;
    protected static TreasureHuntGame treasureHuntGame;

    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private QuestionList questionList = new QuestionList();
    private MapLocationList mapLocationList = new MapLocationList();
    private UserList userList = new UserList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginButton = (Button)findViewById(R.id.button);
        btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        Intent mapActivityIntent = new Intent(this,MapsActivity.class);
        Intent loginActivityIntent = new Intent(this,LoginActivity.class);

       questionList.getQuestions(retroFitCreate.getJsonPlaceHolderAPI());
       mapLocationList.getMapLocations(retroFitCreate.getJsonPlaceHolderAPI());
       userList.getUsers(retroFitCreate.getJsonPlaceHolderAPI());


        treasureHuntGame = new TreasureHuntGame(userList.getUserList(),questionList.getQuestionsList()
                ,mapLocationList.getMapLocationList()
                );


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(loginActivityIntent);
            }
        });

        btnPlayGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(mapActivityIntent);
            }
        });
    }
    public static TreasureHuntGame getTreasureHuntGame()
    {
        return treasureHuntGame;
    }
}