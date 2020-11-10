package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ihu.treasurehunt_front_end.Model.RiddleQuest;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;
import com.ihu.treasurehunt_front_end.Requests.RequestQuestionList;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnPlayGame;
    protected static TreasureHuntGame treasureHuntGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlayGame = (Button) findViewById(R.id.btnPlayGame);

        Intent gameActivityIntent = new Intent(this,RiddleActivity.class);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        RequestQuestionList requestQuestionList = new RequestQuestionList();
        List<RiddleQuest> riddleQuests =requestQuestionList
                .requestQuestions(requestQueue);


        btnPlayGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                treasureHuntGame= new TreasureHuntGame(riddleQuests);
                startActivity(gameActivityIntent);
            }
        });
    }
    public static TreasureHuntGame getTreasureHuntGame()
    {
        return treasureHuntGame;
    }
}