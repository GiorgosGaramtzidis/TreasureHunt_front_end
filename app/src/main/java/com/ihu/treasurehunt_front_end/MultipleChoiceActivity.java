package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.Model.MultipleChoiceQuest;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;

public class MultipleChoiceActivity extends AppCompatActivity {

    private TextView textViewQuestion;
    private RadioGroup rbGroup;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private Button buttonConfirmed;
    private TextView btnBack;
    MultipleChoiceQuest multipleChoiceQuest;
    TreasureHuntGame treasureHuntGame;
    Intent intentMain,intentGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_choice);

        btnBack = (TextView) findViewById(R.id.btnback);

        treasureHuntGame = MainActivity.getTreasureHuntGame();
        textViewQuestion = findViewById(R.id.text_view_question);
        rbGroup = findViewById(R.id.radio_group);
        rb1 = findViewById(R.id.radio_button1);
        rb2 = findViewById(R.id.radio_button2);
        rb3 = findViewById(R.id.radio_button3);
        buttonConfirmed = findViewById(R.id.button_confirm_next);

        textViewQuestion.setText(treasureHuntGame.getMquestions().get(0).getQuestion());
        rb1.setText(treasureHuntGame.getMquestions().get(0).getwrongAnswer1());
        rb2.setText(treasureHuntGame.getMquestions().get(0).getcorrectAnswer());
        rb3.setText(treasureHuntGame.getMquestions().get(0).getwrongAnswer2());

        // intentMain = new Intent(this,MainActivity.class);
        // intentGame = new Intent(this,MultipleChoiceActivity.class);

        buttonConfirmed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb3.isChecked()) {
                    treasureHuntGame.setQuestionProgressCounter(treasureHuntGame.getQuestionProgressCounter()+
                            100/(treasureHuntGame.getQuestions().size()+
                                    treasureHuntGame.getMquestions().size()+
                                    treasureHuntGame.getQuizQuests().size()));
                    MapsActivity.progressBar.setProgress(treasureHuntGame.getQuestionProgressCounter());
                    finish();
                    Toast.makeText(MultipleChoiceActivity.this, "CORRECT ANSWER", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MultipleChoiceActivity.this, "WRONG ANSWER", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


}