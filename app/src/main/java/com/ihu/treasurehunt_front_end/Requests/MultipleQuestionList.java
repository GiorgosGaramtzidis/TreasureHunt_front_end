package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.MultipleQuestion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MultipleQuestionList {

    List<MultipleQuestion> multipleQuestionList = new ArrayList<>();

    public List<MultipleQuestion> getMultipleQuestionList() {
        return multipleQuestionList;
    }

    public void getMultipleQuestions(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<MultipleQuestion>> call = jsonPlaceHolderAPI.getMultipleQuestions();

        call.enqueue(new Callback<List<MultipleQuestion>>() {
            @Override
            public void onResponse(Call<List<MultipleQuestion>> call, Response<List<MultipleQuestion>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<MultipleQuestion> multipleQuestions =response.body();

                for (MultipleQuestion multipleQuestion:multipleQuestions){
                    multipleQuestionList.add(new MultipleQuestion(multipleQuestion.getQuestionId()
                            ,multipleQuestion.getQuestion()
                            ,multipleQuestion.getWrongAnswer1()
                            ,multipleQuestion.getWrongAnswer2()
                            ,multipleQuestion.getCorrectAnswer()
                            ,multipleQuestion.getPoints()));
                }
            }

            @Override
            public void onFailure(Call<List<MultipleQuestion>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
