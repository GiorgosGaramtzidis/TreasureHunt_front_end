package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class QuizQuestion {

    @SerializedName("quizId")
    private int quizId;

    @SerializedName("quiz")
    private String quiz;

    @SerializedName("answer")
    private String answer;

    @SerializedName("points")
    private int points;

    @SerializedName("characters")
    private String[] characters;

    public QuizQuestion(int quizId, String quiz, String answer, int points, String[] characters) {
        this.quizId = quizId;
        this.quiz = quiz;
        this.answer = answer;
        this.points = points;
        this.characters = characters;
    }

    public int getQuizId() {
        return quizId;
    }

    public String getQuiz() {
        return quiz;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }

    public String[] getCharacters() {
        return characters;
    }
}
