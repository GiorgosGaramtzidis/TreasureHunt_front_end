package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class MultipleQuestion {

    @SerializedName("questionId")
    public int questionId;

    @SerializedName("question")
    public String question;

    @SerializedName("wrongAnswer1")
    public String wrongAnswer1;

    @SerializedName("wrongAnswer2")
    public String wrongAnswer2;

    @SerializedName("correctAnswer")
    public String correctAnswer;

    @SerializedName("points")
    public int points;

    public MultipleQuestion(int questionId, String question, String wrongAnswer1, String wrongAnswer2, String correctAnswer, int points) {
        this.questionId = questionId;
        this.question = question;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.correctAnswer = correctAnswer;
        this.points = points;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getWrongAnswer1() {
        return wrongAnswer1;
    }

    public String getWrongAnswer2() {
        return wrongAnswer2;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getPoints() {
        return points;
    }
}
