package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ihu.treasurehunt_front_end.Model.MultipleChoiceQuest;
import com.ihu.treasurehunt_front_end.Model.QuizQuest;
import com.ihu.treasurehunt_front_end.Model.RiddleQuest;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;
import com.ihu.treasurehunt_front_end.Requests.RequestMultipleChoiceQuestion;
import com.ihu.treasurehunt_front_end.Requests.RequestQuestionList;
import com.ihu.treasurehunt_front_end.Requests.RequestQuizList;
import com.ihu.treasurehunt_front_end.Model.LocationsMap;
import com.ihu.treasurehunt_front_end.Requests.RequestLocationsMap;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView btnPlayGame;
    protected static TreasureHuntGame treasureHuntGame;
    private  static List<QuizQuest> list;
    //private static List<LocationsMap> locationsMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);

        Intent mapActivityIntent = new Intent(this,MapsActivity.class);


        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        RequestQuestionList requestQuestionList = new RequestQuestionList();
        List<RiddleQuest> riddleQuests =requestQuestionList
                .requestQuestions(requestQueue);



        //RequestQueue requestMultiple = Volley.newRequestQueue(MainActivity.this);
        RequestMultipleChoiceQuestion requestMultipleChoiceQuestion = new RequestMultipleChoiceQuestion();
        List<MultipleChoiceQuest> MultipleChoice = requestMultipleChoiceQuestion.requestMultipleQuestions(requestQueue);


        RequestLocationsMap requestLocationsMap = new RequestLocationsMap();
        List<LocationsMap> locationsMaps = requestLocationsMap.requestLocationsMap(requestQueue);




        RequestQuizList requestQuizList = new RequestQuizList();
        list = requestQuizList.requestQuestions(requestQueue);

        treasureHuntGame = new TreasureHuntGame(riddleQuests,locationsMaps,MultipleChoice,list);


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