package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.Model.RiddleQuest;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;

public class RiddleActivity extends AppCompatActivity {

    TextView textQuestion;
    EditText textAnswer;
    Button btnCheck,btnContinue;
    Intent intentMain,intentGame,intentResult;
    TreasureHuntGame treasureHuntGame;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);

        treasureHuntGame = MainActivity.getTreasureHuntGame();
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        btnContinue = (Button) findViewById(R.id.btnContinue);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textAnswer= (EditText) findViewById(R.id.textAnswer);

        progressBar.setProgress(treasureHuntGame.getQuestionProgressCounter());
        textQuestion.setText(treasureHuntGame
                .getQuestions()
                .get(treasureHuntGame.getPositionOfQuestion())
                .getQuestion());


        intentMain = new Intent(this,MainActivity.class);
        intentGame = new Intent(this,RiddleActivity.class);
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
                    treasureHuntGame.setQuestionProgressCounter(treasureHuntGame.getQuestionProgressCounter()+ 100/treasureHuntGame.getQuestions().size());
                    progressBar.setProgress(treasureHuntGame.getQuestionProgressCounter());
                    treasureHuntGame.setPoints(treasureHuntGame.getPoints()+treasureHuntGame.getQuestions().get(treasureHuntGame.getPositionOfQuestion()).getPoints());
                    btnContinue.setVisibility(View.VISIBLE);
                }
                else{
                    Toast.makeText(RiddleActivity.this, "You lost", Toast.LENGTH_SHORT).show();
                    startActivity(intentResult);
                }
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                treasureHuntGame.increasePosition();
                finish();
                startActivity(intentGame);

                if(treasureHuntGame.getPositionOfQuestion()>=treasureHuntGame.getQuestions().size())
                {
                    Toast.makeText(RiddleActivity.this, "You find the treasure", Toast.LENGTH_SHORT).show();
                    startActivity(intentResult);
                }
            }

        });
    }
}