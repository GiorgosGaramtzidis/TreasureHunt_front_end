package com.ihu.treasurehunt_front_end.Model;

import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("id")
    private String id;

    @SerializedName("question")
    private String question;

    @SerializedName("answer")
    private String answer;

    @SerializedName("points")
    private int points;


    public Question(String id,String question, String answer, int points) {
        this.id=id;
        this.question = question;
        this.answer = answer;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
