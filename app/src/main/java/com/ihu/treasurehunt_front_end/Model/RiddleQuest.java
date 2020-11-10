package com.ihu.treasurehunt_front_end.Model;

public class RiddleQuest
{
    private String  id;
    private String question;
    private String answer;
    private int points;


    public RiddleQuest(String id, String question, String answer,int points) {
        this.id = id;
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

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
