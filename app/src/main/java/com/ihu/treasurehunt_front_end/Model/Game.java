package com.ihu.treasurehunt_front_end.Model;


import java.util.List;

public class Game
{
    private final List<MapLocation> mapLocations;
    private int positionOfLocation;
    private int progress;
    private int gameScore;


    public Game(List<MapLocation> mapLocations) {
        this.mapLocations = mapLocations;
        this.positionOfLocation=0;
        this.progress = 0;
        this.gameScore = 0;
    }

    public Boolean endOfGame(){
        return mapLocations.size() == positionOfLocation;
    }

    public MapLocation getMapLocation()
    {
        return  mapLocations.get(positionOfLocation);
    }

    public int getPositionOfLocation(){
        return positionOfLocation;
    }



    public void increaseLocationPosition()
    {
        this.positionOfLocation++;
    }

    public Boolean isQuestionCorrectAnswered(String string)
    {
        if(string.equals(this.getMapLocation().getQuestion().getAnswer()))
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
