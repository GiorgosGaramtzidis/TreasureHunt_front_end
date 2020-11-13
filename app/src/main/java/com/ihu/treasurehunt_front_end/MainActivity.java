package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView btnPlayGame;
    private Button button_start_Multiple;
    protected static TreasureHuntGame treasureHuntGame;
    private  static List<QuizQuest> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlayGame = (TextView) findViewById(R.id.btnPlayGame);

        //Intent mapActivityIntent = new Intent(this,MapsActivity.class);
        Intent gameActivityIntent = new Intent(this,RiddleActivity.class);
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        RequestQuestionList requestQuestionList = new RequestQuestionList();
        List<RiddleQuest> riddleQuests =requestQuestionList
                .requestQuestions(requestQueue);

        button_start_Multiple = (Button) findViewById(R.id.button_start_Multiple) ;
        Intent gameMultiple = new Intent(this,MultipleChoiceActivity.class);
        RequestQueue requestMultiple = Volley.newRequestQueue(MainActivity.this);
        RequestMultipleChoiceQuestion requestMultipleChoiceQuestion = new RequestMultipleChoiceQuestion();
        List<MultipleChoiceQuest> MultipleChoice = requestMultipleChoiceQuestion.requestMultipleQuestions(requestMultiple);


        //for the quiz game (should be remove later)
        Intent intent = new Intent(this,QuizActivity.class);
        RequestQuizList requestQuizList = new RequestQuizList();
        list = requestQuizList.requestQuestions( requestQueue);


        btnPlayGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                treasureHuntGame= new TreasureHuntGame(riddleQuests,MultipleChoice);
                startActivity(gameMultiple);
                //startActivity(mapActivityIntent);
            }
        });
    }
    public static TreasureHuntGame getTreasureHuntGame()
    {
        return treasureHuntGame;
    }

    //for the quiz game (should be remove later)
    public static List<QuizQuest> getList()
    {
        return list;
    }
}