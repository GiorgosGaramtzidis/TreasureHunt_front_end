package com.ihu.treasurehunt_front_end.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LoseCondition;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

public class RiddleActivity extends AppCompatActivity {
    TextView textQuestion;
    EditText textAnswer;
    TextView btnCheck;

    private LoseCondition loseCondition = new LoseCondition();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);

        btnCheck = (TextView) findViewById(R.id.btnCheck);
        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textAnswer= (EditText) findViewById(R.id.textAnswer);

        textQuestion.setText(MainActivity.game.getLocation().getQuestion().getQuestion());

        btnCheck.setOnClickListener(v ->{
           if (MainActivity.game.getLocation().getQuestion().getAnswer().equals(textAnswer.getText().toString())) {
                Toast.makeText(RiddleActivity.this, "You Win", Toast.LENGTH_SHORT).show();

           }
            else {
                loseCondition.get(retroFitCreate.getJsonPlaceHolderAPI());
               finish();
           }
            finish();
        });

    }


}