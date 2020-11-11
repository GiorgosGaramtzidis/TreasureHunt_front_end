package com.ihu.treasurehunt_front_end;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ihu.treasurehunt_front_end.Model.QuizQuest;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private int presCounter =0;
    private int maxPresCounter;
    private String[] keys ;
    TextView textQuestion;
    QuizQuest quizQuest = MainActivity.getList().get(0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        textQuestion = (TextView) findViewById(R.id.TextQuestion);



        maxPresCounter = quizQuest.getAnswer().length();
        textQuestion.setText( quizQuest.getQuiz());
        keys =shuffleArray(quizQuest.getChars());

        for(String key : keys)
        {
            addView(((LinearLayout) findViewById(R.id.layoutParent))
                    , key
                    ,((EditText) findViewById(R.id.editText)));
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
        textView.setTextColor(this.getResources().getColor(R.color.mycolor  ));
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

        if(editText.getText().toString().equals(quizQuest.getAnswer()))
        {
                //ToDo..Do something when win
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "You Win", Toast.LENGTH_SHORT).show();
                editText.setText("");
        } else{
                Toast.makeText(this, "You lost", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                editText.setText("");
        }

    }
}