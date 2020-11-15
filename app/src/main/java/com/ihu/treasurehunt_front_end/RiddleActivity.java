package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;

public class RiddleActivity extends AppCompatActivity {

    TextView textQuestion;
    EditText textAnswer;
    TextView btnCheck;
    Intent intentResult;
    TreasureHuntGame treasureHuntGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);

        treasureHuntGame = MainActivity.getTreasureHuntGame();
        btnCheck = (TextView) findViewById(R.id.btnCheck);
        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textAnswer= (EditText) findViewById(R.id.textAnswer);


        textQuestion.setText(treasureHuntGame
                .getQuestions().get(0).getQuestion());



        intentResult = new Intent(this,ResultActivity.class);
        playGame();



    }

    public void playGame()
    {
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textAnswer.getText().toString().equals(treasureHuntGame.getQuestions().get(treasureHuntGame.getPositionOfQuestion()).getAnswer()))
                {
                    Toast.makeText(RiddleActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                    treasureHuntGame.setQuestionProgressCounter(treasureHuntGame.getQuestionProgressCounter()+
                            100/(treasureHuntGame.getQuestions().size()+
                                    treasureHuntGame.getMquestions().size()+
                                    treasureHuntGame.getQuizQuests().size()));
                    MapsActivity.progressBar.setProgress(treasureHuntGame.getQuestionProgressCounter());
                    treasureHuntGame.setPoints(treasureHuntGame.getPoints()+treasureHuntGame.getQuestions().get(treasureHuntGame.getPositionOfQuestion()).getPoints());
                    MapsActivity.textView.setText("Score : " + treasureHuntGame.getPoints());
                    finish();


                }
                else{
                    Toast.makeText(RiddleActivity.this, "You lost", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}