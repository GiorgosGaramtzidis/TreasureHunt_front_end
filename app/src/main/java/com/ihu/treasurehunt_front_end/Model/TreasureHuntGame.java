package com.ihu.treasurehunt_front_end.Model;

import java.util.List;

public class TreasureHuntGame {
    private List<Question> questionList;
    private List<MapLocation> mapLocationList;
    private List<QuizQuestion> quizQuestionList;
    private List<User> userList;
    private int positionOfQuestion;
    private int questionProgressCounter;
    private List<MultipleQuestion> multipleQuestionList;
    private int points;


    public TreasureHuntGame(List<User> userList,List<Question> questionList, List<MapLocation> mapLocationList, List<MultipleQuestion> multipleQuestionList, List<QuizQuestion> quizQuestionList) {
        this.userList = userList;
        this.questionList = questionList;
        this.mapLocationList = mapLocationList;
        this.multipleQuestionList = multipleQuestionList;
        this.quizQuestionList = quizQuestionList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<QuizQuestion> getQuizQuestionList() {
        return quizQuestionList;
    }

    public List<MultipleQuestion> getMquestions() {
        return multipleQuestionList;
    }

    public List<MapLocation> getMapLocationList() {
        return mapLocationList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public int getQuestionProgressCounter() {
        return questionProgressCounter;
    }

    public void setQuestionProgressCounter(int questionProgressCounter) {
        this.questionProgressCounter = questionProgressCounter;
    }


    public int getPositionOfQuestion() {
        return positionOfQuestion;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

