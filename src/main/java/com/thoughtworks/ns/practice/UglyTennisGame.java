package com.thoughtworks.ns.practice;

import static java.lang.String.format;

public class UglyTennisGame implements TennisGame {
    public int P1point;
    public int P2point;

    private String player1Name;
    private String player2Name;

    public UglyTennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        P1point = 0;
        P2point = 0;
    }
    private String haveEqualPoint()
    {
        String score = null;
        if (P1point==0)
            score = "Love-All";
        else if (P1point==1)
            score = "Fifteen-All";
        else if (P1point==2)
            score = "Thirty-All";
        else
            score = "Deuce";
        return score;
    }
    private String haveNotEqualPoint()
    {
        String score = null;
        String P1res = null;
        String P2res = null;

        if(P1point == 0)
            P1res = "Love";
        else if (P1point ==1)
            P1res = "Fifteen";
        else if(P1point==2)
            P1res="Thirty";
        else if(P1point==3)
            P1res="Forty";
        else
             return score = otherPoints();

        if (P2point ==0)
            P2res = "Love";
        else  if(P2point==1)
            P2res="Fifteen";
        else if(P2point ==2)
            P2res="Thirty";
        else if(P2point ==3)
            P2res = "Forty";
        else
            return  score = otherPoints();

        return  score = P1res + "-" + P2res;
    }
    private String otherPoints()
    {
        String score = null;
        if (P1point>P2point && P2point >= 3)
        {
            score = format("Advantage %s", player1Name);
        }
        if (P2point>P1point && P1point >= 3)
        {
            score = format("Advantage %s", player2Name);
        }
        if (P1point>=4 && (P1point-P2point)>=2)
        {
            score = format("Win for %s", player1Name);
        }
        if (P2point>=4 && (P2point-P1point)>=2)
        {
            score = format("Win for %s", player2Name);
        }
        return score;
    }

    public String getScore(){
        if (P1point == P2point)
            return haveEqualPoint();
        else
             return haveNotEqualPoint();
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name))
            P1point++;
        else
            P2point++;
    }
}
