package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LeaderBoardList;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

public class LeaderBoardActivity extends AppCompatActivity {

     protected static TextView textViewName;
     protected static TextView textViewScore;
private RetroFitCreate retroFitCreate = new RetroFitCreate();
private LeaderBoardList leaderBoardList = new LeaderBoardList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        leaderBoardList.getLeaderBoard(retroFitCreate.getJsonPlaceHolderAPI());
        new Handler().postDelayed(() -> {
            for (int i=0;i<leaderBoardList.getLeaderBoardList().size();i++){
                textViewName.append(leaderBoardList.getLeaderBoardList().get(i).getName()+"\n");
                textViewScore.append("\t\t\t\t\t\t\t"+Integer.toString(leaderBoardList.getLeaderBoardList().get(i).getScore())+"\n");
            }

        },1000);
        textViewName = findViewById(R.id.ResultName);
        textViewScore = findViewById(R.id.ResultScore);
    }
}