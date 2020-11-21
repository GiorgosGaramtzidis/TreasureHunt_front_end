package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.Question;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionList {

    List<Question> questionList = new ArrayList<>();

    public List<Question> getQuestionsList() {
        return questionList;
    }

    public void createQuestion(JsonPlaceHolderAPI jsonPlaceHolderAPI){

        Question question = new Question(6,"Τι χρώμα έχει το πορτοκάλι","Πορτικαλί",3);

        Call<Question> call = jsonPlaceHolderAPI.createQuestion(question);

        call.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                Question questionResponse = response.body();

            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
    public void getQuestions(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<Question>> call = jsonPlaceHolderAPI.getQuestions();

        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<Question> questions =response.body();

                for (Question question:questions){
                    questionList.add(new Question(question.getId(),question.getQuestion(),question.getAnswer(),question.getPoints()));
                }
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }
}
