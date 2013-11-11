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
    private String getValueByPoint(int point)
    {
        if(point == 0)
            return  "Love";
        else if (point == 1)
            return "Fifteen";
        else if(point == 2)
            return "Thirty";
        else if(point == 3)
            return "Forty";
        else
            return null;
    }
    private String haveNotEqualPoint()
    {
        String P1res = getValueByPoint(P1point);
        String P2res = getValueByPoint(P2point);

        if (P1res != null && P2res != null)
            return P1res + "-" + P2res;
        else
             return  otherValues();
    }
    private String otherValues()
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
