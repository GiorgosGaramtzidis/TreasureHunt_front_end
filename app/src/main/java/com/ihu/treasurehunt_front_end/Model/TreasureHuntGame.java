package com.ihu.treasurehunt_front_end.Model;

import java.util.List;

public class TreasureHuntGame
{
    private List<RiddleQuest> questions;
    private int positionOfQuestion;


    public TreasureHuntGame(List<RiddleQuest> questions) {
        this.questions = questions;
    }

    public List<RiddleQuest> getQuestions() {
        return questions;
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


}
