package com.ihu.treasurehunt_front_end.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ihu.treasurehunt_front_end.Model.User;
import com.ihu.treasurehunt_front_end.R;
import com.ihu.treasurehunt_front_end.Requests.LeaderBoardList;
import com.ihu.treasurehunt_front_end.Requests.RetroFitCreate;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {
    RetroFitCreate retroFitCreate = new RetroFitCreate();
    LeaderBoardList leaderBoardList = new LeaderBoardList();
     private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        textView = findViewById(R.id.Result);
        leaderBoardList.getLeaderBoard(retroFitCreate.getJsonPlaceHolderAPI());
        List<User> leaderBoard = new ArrayList<>();
        leaderBoard = leaderBoardList.getLeaderBoardList();

        for (int i =0; i<leaderBoard.size();i++)
        {
            textView.append(leaderBoard.get(i).getName());
            System.out.println(leaderBoard.get(i).getName());
        }

       
    }
}