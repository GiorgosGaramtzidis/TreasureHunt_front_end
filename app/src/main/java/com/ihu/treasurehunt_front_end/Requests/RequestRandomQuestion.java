package com.ihu.treasurehunt_front_end.Requests;

import com.ihu.treasurehunt_front_end.Model.Question;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestRandomQuestion {

    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void getRandomQuestion(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<Question> call = jsonPlaceHolderAPI.getRandomQuestion();

        call.enqueue(new Callback<Question>() {
            @Override
            public void onResponse(Call<Question> call, Response<Question> response) {

                Question responseQuestion = response.body();
                question = new Question(responseQuestion.getId(),responseQuestion.getQuestion()
                    ,responseQuestion.getAnswer()
                    ,responseQuestion.getPoints());
                System.out.println(question);
            }

            @Override
            public void onFailure(Call<Question> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
