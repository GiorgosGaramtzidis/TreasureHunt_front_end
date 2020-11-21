package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class Question {
    @SerializedName("questionId")
    private int id;

    @SerializedName("question")
    private String question;

    @SerializedName("answer")
    private String answer;

    @SerializedName("points")
    private int points;

    public Question(int id, String question, String answer, int points) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.points = points;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public int getPoints() {
        return points;
    }
}
