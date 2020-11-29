package com.ihu.treasurehunt_front_end.Model;


import java.util.List;

public class Game
{
    private final List<MapLocation> mapLocations;
    private int positionOfLocation;
    private int progress;
    private int gameScore;
    private GameState gameState;

    public Game(List<MapLocation> mapLocations) {
        this.mapLocations = mapLocations;
        this.positionOfLocation=0;
        this.progress = 0;
        this.gameScore = 0;
        this.gameState = GameState.PLAYING;
    }

    public Location getQuestion() throws IndexOutOfBoundsException
    {
        if (positionOfLocation < mapLocations.size())
            return  mapLocations.get(positionOfLocation).getQuestion();
        throw new IndexOutOfBoundsException();

    }

    public int nextLocation(){
        return positionOfLocation;
    }

    public Boolean isStateWIN(){
        return this.gameState==GameState.WIN;
    }

    public void hasNext(){

    }

    public void nextQuestion()
    {
        if(positionOfLocation < mapLocations.size()) {
            this.positionOfLocation++;
            return;
        }
        gameState=GameState.WIN;
    }

    public Boolean isQuestionCorrectAnswered(String string)
    {
        if(string.equals(this.getQuestion().getAnswer()))
        {
            this.setQuestionProgress(this.getProgress()+
                    100/this.mapLocations.size());
            return true;
        }
        return false;

    }
    public int getProgress() {
        return progress;
    }
    public void setQuestionProgress(int progress)
    {
        this.progress = progress;
    }
    public void appendScore(int points)
    {
        this.gameScore += points;
    }
    public int getScore()
    {
        return this.gameScore;
    }
    public String getLocationDescription(){
        return mapLocations.get(positionOfLocation).getTitle();
    }
}
