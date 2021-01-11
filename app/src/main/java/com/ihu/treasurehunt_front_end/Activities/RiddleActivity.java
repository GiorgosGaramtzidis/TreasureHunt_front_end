package com.ihu.treasurehunt_front_end.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.AddInWatchTowerRequest;
import com.ihu.treasurehunt_front_end.Requests.AddPointsRequest;
import com.ihu.treasurehunt_front_end.Requests.BuyAnswerRequest;
import com.ihu.treasurehunt_front_end.Requests.BuyLife;
import com.ihu.treasurehunt_front_end.Requests.CheckAnswerRequest;
import com.ihu.treasurehunt_front_end.Requests.LeaderBoardList;
import com.ihu.treasurehunt_front_end.Requests.LoseCondition;
import com.ihu.treasurehunt_front_end.Requests.RequestNewQuestion;
import com.ihu.treasurehunt_front_end.Requests.RequestNextLocation;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;
import com.ihu.treasurehunt_front_end.Requests.SetUserStateRequest;

public class RiddleActivity extends AppCompatActivity {
    TextView textQuestion;
    EditText textAnswer;
    TextView btnCheck;
    TextView shop;
    TextView buyLf;

    private CheckAnswerRequest checkAnswerRequest = new CheckAnswerRequest();
    private AddPointsRequest addPointsRequest = new AddPointsRequest();
    private LoseCondition loseCondition = new LoseCondition();
    private RetroFitCreate retroFitCreate = new RetroFitCreate();
    private SetUserStateRequest setUserStateRequest = new SetUserStateRequest();
    private RequestNextLocation requestNextLocation = new RequestNextLocation();
    private LeaderBoardList leaderBoardList = new LeaderBoardList();
    private RequestNewQuestion requestNewQuestion = new RequestNewQuestion();
    private BuyAnswerRequest buyAnswerRequest = new BuyAnswerRequest();
    private AddInWatchTowerRequest addInWatchTowerRequest = new AddInWatchTowerRequest();
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
        shop = (TextView)findViewById(R.id.answer);

        textQuestion.setText(MainActivity.game.getQuestion().getQuestion());

        if(MainActivity.game.getGameScore()>=10){
            shop.setVisibility(View.VISIBLE);
            buyLf.setVisibility(View.VISIBLE);
        }

        shop.setOnClickListener(v -> {
            buyAnswerRequest.buyAnswer(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getUserLoggedIn(),MainActivity.game.getQuestion().getQuestion());
            new Handler().postDelayed(() -> {
                textAnswer.setText(buyAnswerRequest.getAnswer());
                shop.setVisibility(View.INVISIBLE);
            },750);

        });
        btnCheck.setOnClickListener(v ->{

            checkAnswerRequest.answerCheck(retroFitCreate.getJsonPlaceHolderAPI(),textAnswer.getText().toString(),MainActivity.game.getQuestion().getQuestion());
            new Handler().postDelayed(() -> {
                if (checkAnswerRequest.isResult()) {
                    addPointsRequest.addScoreToPlayer(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getUserLoggedIn(),
                            MainActivity.game.getQuestion().getPoints());
                    requestNextLocation.getNextLocation(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getLocation().getNextLocation());
                    requestNewQuestion.getNewQuestion(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getQuestionList());
                    setUserStateRequest.setUserState(retroFitCreate.getJsonPlaceHolderAPI(),
                            MainActivity.game.getUserLoggedIn(),
                            MainActivity.game.getLocation().getNextLocation());
                    new Handler().postDelayed(() -> {
                        leaderBoardList.updateLeaderBoard(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getUserLoggedIn(),MainActivity.game.getQuestion().getPoints());
                        addInWatchTowerRequest.addInWatchTower(retroFitCreate.getJsonPlaceHolderAPI(),MainActivity.game.getUserLoggedIn(),MainActivity.game.getLocation().getTitle());
                        MapsActivity.marker.setVisible(false);
                        MainActivity.game.setLocation(requestNextLocation.getMapLocationNext());
                        MainActivity.game.setQuestion(requestNewQuestion.getQuestion());
                    },1000);
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