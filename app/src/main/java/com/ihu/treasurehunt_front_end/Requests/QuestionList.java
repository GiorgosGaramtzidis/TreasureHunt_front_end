package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.Riddle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionList {

    List<Riddle> questionList = new ArrayList<>();

    public List<Riddle> getQuestionsList() {
        return questionList;
    }

    public void createQuestion(JsonPlaceHolderAPI jsonPlaceHolderAPI){

        Riddle question = new Riddle(6,"Τι χρώμα έχει το πορτοκάλι","Πορτικαλί",3);

        Call<Riddle> call = jsonPlaceHolderAPI.createQuestion(question);

        call.enqueue(new Callback<Riddle>() {
            @Override
            public void onResponse(Call<Riddle> call, Response<Riddle> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                Riddle questionResponse = response.body();

            }

            @Override
            public void onFailure(Call<Riddle> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
    public void getQuestions(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<Riddle>> call = jsonPlaceHolderAPI.getQuestions();

        call.enqueue(new Callback<List<Riddle>>() {
            @Override
            public void onResponse(Call<List<Riddle>> call, Response<List<Riddle>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<Riddle> questions =response.body();

                for (Riddle question:questions){
                    questionList.add(new Riddle(question.getId(),question.getQuestion(),question.getAnswer(),question.getPoints()));
                }
            }

            @Override
            public void onFailure(Call<List<Riddle>> call, Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }
}
