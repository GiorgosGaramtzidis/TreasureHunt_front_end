package com.ihu.treasurehunt_front_end.Model;

public class QuizQuest
{
    private int id;
    private String quiz;
    private String answer;
    private int points;
    private String[] chars;

    public QuizQuest(int id, String quiz, String answer, int points, String[] chars) {
        this.id = id;
        this.quiz = quiz;
        this.answer = answer;
        this.points = points;
        this.chars = chars;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuiz() {
        return quiz;
    }

    public void setQuiz(String quiz) {
        this.quiz = quiz;
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

    public String[] getChars() {
        return chars;
    }

    public void setChars(String[] chars) {
        this.chars = chars;
    }
}
