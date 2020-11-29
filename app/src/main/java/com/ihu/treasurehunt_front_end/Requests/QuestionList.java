package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.Location;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionList {

    List<Location> questionList = new ArrayList<>();

    public List<Location> getQuestionsList() {
        return questionList;
    }

    public void createQuestion(JsonPlaceHolderAPI jsonPlaceHolderAPI){

        Location question = new Location(6,"Τι χρώμα έχει το πορτοκάλι","Πορτικαλί",3);

        Call<Location> call = jsonPlaceHolderAPI.createQuestion(question);

        call.enqueue(new Callback<Location>() {
            @Override
            public void onResponse(Call<Location> call, Response<Location> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                Location questionResponse = response.body();

            }

            @Override
            public void onFailure(Call<Location> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
    public void getQuestions(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<Location>> call = jsonPlaceHolderAPI.getQuestions();

        call.enqueue(new Callback<List<Location>>() {
            @Override
            public void onResponse(Call<List<Location>> call, Response<List<Location>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<Location> questions =response.body();

                for (Location question:questions){
                    questionList.add(new Location(question.getId(),question.getQuestion(),question.getAnswer(),question.getPoints()));
                }
            }

            @Override
            public void onFailure(Call<List<Location>> call, Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }
}
