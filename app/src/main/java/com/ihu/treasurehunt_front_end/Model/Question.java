package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class Question {
    
    @SerializedName("question")
    private String question;

    @SerializedName("answer")
    private String answer;

    @SerializedName("points")
    private int points;


    public Question( String question, String answer, int points) {
        this.question = question;
        this.answer = answer;
        this.points = points;
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

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", points=" + points +
                '}';
    }
}
