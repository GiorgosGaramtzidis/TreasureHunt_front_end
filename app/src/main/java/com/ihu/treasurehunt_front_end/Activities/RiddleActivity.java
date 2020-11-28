package com.ihu.treasurehunt_front_end.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.Model.AppContainer;
import com.ihu.treasurehunt_front_end.R;

public class RiddleActivity extends AppCompatActivity {
    TextView textQuestion;
    EditText textAnswer;
    TextView btnCheck;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);


        btnCheck = (TextView) findViewById(R.id.btnCheck);
        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textAnswer= (EditText) findViewById(R.id.textAnswer);

        textQuestion.setText(MainActivity.game.getQuestion().getQuestion());


        btnCheck.setOnClickListener(v ->{
            if (MainActivity.game.isQuestionCorrectAnswered(textAnswer.getText().toString())) {
                Toast.makeText(RiddleActivity.this, "You Win", Toast.LENGTH_SHORT).show();
                AppendProgressBar();
                MainActivity.game.nextQuestion();
                finish();
            }
            else
                Toast.makeText(RiddleActivity.this, "You lost", Toast.LENGTH_SHORT).show();
            finish();
        });

    }
    @SuppressLint("SetTextI18n")
    public void AppendProgressBar()
    {
        AppContainer.progressBar.setProgress(MainActivity.game.getProgress());
        MainActivity.game.appendScore(MainActivity.game.getQuestion().getPoints());
        MapsActivity.textView.setText("Score : " + MainActivity.game.getScore());
    }
}