package com.ihu.treasurehunt_front_end.Model;

import java.util.List;

public class TreasureHuntGame {
    private List<RiddleQuest> questions;
    private List<LocationsMap> locationsMaps;
    private List<QuizQuest> quizQuests;
    private int positionOfQuestion;
    private int questionProgressCounter;
    private List<MultipleChoiceQuest> mquestions;
    private int points;


    public TreasureHuntGame(List<RiddleQuest> questions, List<LocationsMap> locationsMaps, List<MultipleChoiceQuest> multipleChoiceQuests,List<QuizQuest> quizQuestList) {
        this.questions = questions;
        this.locationsMaps = locationsMaps;
        this.mquestions = multipleChoiceQuests;
        this.quizQuests = quizQuestList;
    }

    public List<QuizQuest> getQuizQuests() {
        return quizQuests;
    }

    public void setQuizQuests(List<QuizQuest> quizQuests) {
        this.quizQuests = quizQuests;
    }

    public void setLocationsMaps(List<LocationsMap> locationsMaps) {
        this.locationsMaps = locationsMaps;
    }

    public void setMquestions(List<MultipleChoiceQuest> mquestions) {
        this.mquestions = mquestions;
    }

    public List<MultipleChoiceQuest> getMquestions() {
        return mquestions;
    }

    public List<LocationsMap> getLocationsMaps() {
        return locationsMaps;
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

    public void increasePosition() {
        this.positionOfQuestion++;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

