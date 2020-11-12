package com.ihu.treasurehunt_front_end.Model;

import java.util.List;

public class TreasureHuntGame
{
    private List<RiddleQuest> questions;
    private int positionOfQuestion;
    private int questionProgressCounter;
    private int points;

    public TreasureHuntGame(List<RiddleQuest> questions) {
        this.questions = questions;
        positionOfQuestion=0;
    }

    public List<RiddleQuest> getQuestions() {
        return questions;
    }

    public int getQuestionProgressCounter() {
        return questionProgressCounter;
    }

    public void setQuestionProgressCounter(int questionProgressCounter) {
        this.questionProgressCounter = questionProgressCounter;
    }

    public void setQuestions(List<RiddleQuest> questions) {
        this.questions = questions;
    }

    public int getPositionOfQuestion() {
        return positionOfQuestion;
    }

    public void setPositionOfQuestion(int positionOfQuestion) {
        this.positionOfQuestion = positionOfQuestion;
    }
    public void increasePosition()
    {
        this.positionOfQuestion++;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
