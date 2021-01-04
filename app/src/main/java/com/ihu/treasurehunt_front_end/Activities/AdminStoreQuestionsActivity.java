package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Service.StoreQuestionService;

public class AdminStoreQuestionsActivity extends AppCompatActivity {

    TextInputEditText question,answer,points;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_store_questions);

        question = findViewById(R.id.QuestionEditText);
        answer = findViewById(R.id.AnswerEditText);
        points = findViewById(R.id.PointsEditText);

        MaterialButton save = findViewById(R.id.btnStore);
        MaterialButton clear = findViewById(R.id.ClearTexts);
        MaterialButton cancel = findViewById(R.id.btnCancel);

        cancel.setOnClickListener(v ->{
            clearTexts();
            finish();
        });

        clear.setOnClickListener(v -> clearTexts());
        save.setOnClickListener(v ->{
            StoreQuestionService storeQuestionService = new StoreQuestionService();
            RetroFitCreate retroFitCreate = new RetroFitCreate();
            try {
                storeQuestionService.store(retroFitCreate.getJsonPlaceHolderAPI(),
                        question.getText().toString(),
                        answer.getText().toString(),
                        points.getText().toString());
                new Handler().postDelayed(() -> Snackbar.make(v,storeQuestionService.getMessage(),Snackbar.LENGTH_SHORT).show(),1000);
            }catch (Exception e)
            {
                Snackbar.make(v,e.getMessage(),Snackbar.LENGTH_SHORT).show();
            }
        });
    }
    public void clearTexts()
    {
        question.setText("");
        answer.setText("");
        points.setText("");
    }
}