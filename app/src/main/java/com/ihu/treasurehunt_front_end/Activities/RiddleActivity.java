package com.ihu.treasurehunt_front_end.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.AddPointsRequest;
import com.ihu.treasurehunt_front_end.Requests.CheckAnswerRequest;
import com.ihu.treasurehunt_front_end.Requests.LoseCondition;
import com.ihu.treasurehunt_front_end.Requests.RequestNextLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Requests.SetUserStateRequest;

public class RiddleActivity extends AppCompatActivity {
    TextView textQuestion;
    EditText textAnswer;
    TextView btnCheck;

    private CheckAnswerRequest checkAnswerRequest = new CheckAnswerRequest();
    private AddPointsRequest addPointsRequest = new AddPointsRequest();
    private LoseCondition loseCondition = new LoseCondition();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private SetUserStateRequest setUserStateRequest = new SetUserStateRequest();

    private RequestNextLocation requestNextLocation = new RequestNextLocation();


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
            checkAnswerRequest.answerCheck(retroFitCreate.getJsonPlaceHolderAPI(),textAnswer.getText().toString(),MainActivity.game.getLocation().getTitle());
            new Handler().postDelayed(() -> {
                if (checkAnswerRequest.isResult()) {
                    addPointsRequest.addScoreToPlayer(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getUserLoggedIn(),
                            MainActivity.game.getLocation().getQuestion().getPoints());
                    requestNextLocation.getNextLocation(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getLocation().getNextLocation());
                    setUserStateRequest.setUserState(retroFitCreate.getJsonPlaceHolderAPI(),
                            MainActivity.game.getUserLoggedIn(),
                            MainActivity.game.getLocation().getNextLocation());
                    new Handler().postDelayed(() -> {
                        MapsActivity.marker.setVisible(false);
                        MainActivity.game.setLocation(requestNextLocation.getMapLocationNext());
                    },750);
                    Toast.makeText(RiddleActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }
                else {
                    loseCondition.get(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getUserLoggedIn());
                    Toast.makeText(RiddleActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            },750);
            finish();
        });

    }


}