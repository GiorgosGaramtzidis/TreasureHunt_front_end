package com.ihu.treasurehunt_front_end.Model;

public class MultipleChoiceQuest {
    private String id;
    private String question;
    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
    private int points;


    public MultipleChoiceQuest(String id, String question, String correctAnswer,String wrongAnswer1,String wrongAnswer2,int points)
    {
        this.id = id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public String getcorrectAnswer() {
        return correctAnswer;
    }

    public String getwrongAnswer1() {
        return wrongAnswer1;
    }

    public String getwrongAnswer2() {
        return wrongAnswer2;
    }

    public int getPoints() {
        return points;
    }

    public String getQuestion() {
        return question;
    }

    public void setcorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void settwrongAnswer2(String getPossiblyAnswer2) {
        this.wrongAnswer2 = wrongAnswer2;
    }

    public void setPossiblyAnswer1(String possiblyAnswer1) {
        this.wrongAnswer1 = wrongAnswer1;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}

