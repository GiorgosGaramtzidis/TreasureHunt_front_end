package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.Model.RiddleQuest;
import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;

public class ResultActivity extends AppCompatActivity {

    TextView scoreLabel;
    Button returnButton;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        returnButton = (Button) findViewById(R.id.returnButton);
        scoreLabel = (TextView) findViewById(R.id.scoreLabel);

        scoreLabel.setText("Total Score : " + MainActivity.treasureHuntGame.getPoints());

        Intent intentMain;
        intentMain = new Intent(this,MainActivity.class);

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMain);
            }
        });
    }
}
