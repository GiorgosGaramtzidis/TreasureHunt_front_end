package com.ihu.treasurehunt_front_end.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.AddPointsRequest;
import com.ihu.treasurehunt_front_end.Requests.BuyLife;
import com.ihu.treasurehunt_front_end.Requests.CheckAnswerRequest;
import com.ihu.treasurehunt_front_end.Requests.LoseCondition;
import com.ihu.treasurehunt_front_end.Requests.RequestNextLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Requests.SetUserStateRequest;

public class RiddleActivity extends AppCompatActivity {
    TextView textQuestion;
    EditText textAnswer;
    TextView btnCheck;
    TextView buyLf;

    private CheckAnswerRequest checkAnswerRequest = new CheckAnswerRequest();
    private AddPointsRequest addPointsRequest = new AddPointsRequest();
    private LoseCondition loseCondition = new LoseCondition();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private SetUserStateRequest setUserStateRequest = new SetUserStateRequest();
    private RequestNextLocation requestNextLocation = new RequestNextLocation();
    private BuyLife buyLife = new BuyLife();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle);

        btnCheck = (TextView) findViewById(R.id.btnCheck);
        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textAnswer = (EditText) findViewById(R.id.textAnswer);
        buyLf = (TextView) findViewById(R.id.buyLf);

        textQuestion.setText(MainActivity.game.getLocation().getQuestion().getQuestion());

        btnCheck.setOnClickListener(v -> {

            checkAnswerRequest.answerCheck(retroFitCreate.getJsonPlaceHolderAPI(), textAnswer.getText().toString(), MainActivity.game.getLocation().getTitle());
            new Handler().postDelayed(() -> {
                if (checkAnswerRequest.isResult()) {
                    addPointsRequest.addScoreToPlayer(retroFitCreate.getJsonPlaceHolderAPI(), MainActivity.game.getUserLoggedIn(),
                            MainActivity.game.getLocation().getQuestion().getPoints());
                    requestNextLocation.getNextLocation(retroFitCreate.getJsonPlaceHolderAPI(), MainActivity.game.getLocation().getNextLocation());
                    setUserStateRequest.setUserState(retroFitCreate.getJsonPlaceHolderAPI(),
                            MainActivity.game.getUserLoggedIn(),
                            MainActivity.game.getLocation().getNextLocation());
                    new Handler().postDelayed(() -> {
                        MapsActivity.marker.setVisible(false);
                        MainActivity.game.setLocation(requestNextLocation.getMapLocationNext());
                    }, 500);
                    Toast.makeText(RiddleActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                } else {
                    loseCondition.get(retroFitCreate.getJsonPlaceHolderAPI(), MainActivity.game.getUserLoggedIn());
                    new Handler().postDelayed(() -> {
                        if (loseCondition.getHasLost()) {
                            startActivity(new Intent(this, MainActivity.class));
                            Toast.makeText(RiddleActivity.this, (MainActivity.game.getUserLoggedIn() + " lost "), Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(RiddleActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    }, 1000);

                }
                finish();
            }, 1000);
        });

        buyLf.setOnClickListener(v -> {
            buyLife.buyALife(retroFitCreate.getJsonPlaceHolderAPI(), MainActivity.game.getUserLoggedIn());
            new Handler().postDelayed(() -> {
                if (buyLife.getHasBoughtLife()) {
                    Toast.makeText(RiddleActivity.this, "You just bought a life!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RiddleActivity.this, "In order to buy a life you have to reach 20 points.", Toast.LENGTH_SHORT).show();
                }
                finish();
            }, 1000);

        });

    }
}