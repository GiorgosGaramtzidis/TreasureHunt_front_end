package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.Model.TreasureHuntGame;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private int presCounter =0;
    private int keyCounter = 0;
    private int maxPresCounter;
    private String[] keys ;
    private TreasureHuntGame treasureHuntGame = MainActivity.getTreasureHuntGame();
    TextView textQuestion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        textQuestion = (TextView) findViewById(R.id.TextQuestion);



        maxPresCounter = treasureHuntGame.getQuizQuestionList().get(0).getAnswer().length();
        textQuestion.setText( treasureHuntGame.getQuizQuestionList().get(0).getQuiz());
        keys =shuffleArray(treasureHuntGame.getQuizQuestionList().get(0).getCharacters());


        for(String key : keys)
        {
            if(keyCounter < 5)
                addView(((LinearLayout) findViewById(R.id.layoutParent))
                        , key
                        , ((EditText) findViewById(R.id.editText)));
            else
                addView(((LinearLayout) findViewById(R.id.layoutParent2))
                        , key
                        , ((EditText) findViewById(R.id.editText)));
            keyCounter++;
        }

    }
    private String[] shuffleArray(String[] ar)
    {

        Random random = new Random();
        for(int i=ar.length - 1;i > 0; i--)
        {
            int index = random.nextInt(i+1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i]= a;
        }
        return ar;
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        layoutParams.rightMargin = 20;

        final TextView textView = new TextView(this);

        textView.setLayoutParams(layoutParams);
        textView.setBackground(this.getResources()
                .getDrawable(R.drawable.button2));
        textView.setTextColor(this.getResources().getColor(R.color.mycolor));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);

        textView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(presCounter < maxPresCounter)
                {
                    if(presCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);

                    textView.animate().alpha(0).setDuration(300);
                    presCounter++;
                    if(presCounter == maxPresCounter)
                    {
                        doValidate();
                    }
                }
            }
        });
        viewParent.addView(textView);
    }
    private void doValidate()
    {
        presCounter =0;
        EditText editText = findViewById(R.id.editText);

        if(editText.getText().toString().equals(treasureHuntGame.getQuizQuestionList().get(0).getAnswer()))
        {
            treasureHuntGame.setQuestionProgressCounter(treasureHuntGame.getQuestionProgressCounter()+
                    100/(treasureHuntGame.getQuestionList().size()+
                            treasureHuntGame.getMquestions().size()+
                            treasureHuntGame.getQuizQuestionList().size()));
                MapsActivity.progressBar.setProgress(treasureHuntGame.getQuestionProgressCounter());
            Toast.makeText(this, "You Win", Toast.LENGTH_SHORT).show();
            treasureHuntGame.setPoints(treasureHuntGame.getPoints()+treasureHuntGame.getQuizQuestionList().get(0).getPoints());
            MapsActivity.textView.setText("Score : " + treasureHuntGame.getPoints());
            finish();
        } else{
            //Todo.. Do something when loose
                Toast.makeText(this, "You lost", Toast.LENGTH_SHORT).show();
                 finish();
        }

    }
}