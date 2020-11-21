package com.ihu.treasurehunt_front_end.Requests;


import com.ihu.treasurehunt_front_end.Model.QuizQuestion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizList {

    List<QuizQuestion> quizQuestionList = new ArrayList<>();

    public List<QuizQuestion> getQuizQuestionList() {
        return quizQuestionList;
    }

    public void getQuizQuestion(JsonPlaceHolderAPI jsonPlaceHolderAPI){
        Call<List<QuizQuestion>> call = jsonPlaceHolderAPI.getQuizQuestions();

        call.enqueue(new Callback<List<QuizQuestion>>() {
            @Override
            public void onResponse(Call<List<QuizQuestion>> call, Response<List<QuizQuestion>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Code: "+ response.code());
                    return;
                }
                List<QuizQuestion> quizQuestions =response.body();

                for (QuizQuestion quizQuestion:quizQuestions){
                    quizQuestionList.add(new QuizQuestion(quizQuestion.getQuizId()
                            ,quizQuestion.getQuiz()
                            ,quizQuestion.getAnswer()
                            ,quizQuestion.getPoints()
                            ,quizQuestion.getCharacters()));
                }
            }

            @Override
            public void onFailure(Call<List<QuizQuestion>> call, Throwable t) {
                System.out.println(t.getMessage());            }
        });
    }
}
