package model;

public class Player {
    private int games;
    private int wins;
    private int defeats;
    private int ties;
    private double score;
    private Game[] recentGames;
    private Game[] bestGames;

    private String name;


    Player(String name) {
        this.name=name;
        recentGames = new Game[5];
        bestGames = new Game[5];

        games = 0;
        wins = 0;
        defeats = 0;
        ties = 0;
        score = 0;
    }

    public void updatePlayerState(int result, Game game) {
        Game temporaryGame = game;
        Game temporaryGame2;

        games++;
        if (result==10)
            wins++;

        else if (result==-10)
            defeats++;

        else
            ties++;

        score = 50 * (2*wins+ties)/games;

        for (int i=0;i<5;i++) {
            try {
                if(temporaryGame.getTime().isAfter(recentGames[i].getTime())) {
                    temporaryGame2 = recentGames[i];
                    recentGames[i] = temporaryGame;
                    temporaryGame = temporaryGame2;
                }
            }catch (NullPointerException e){
                recentGames[i] = game;
            }
        }

        temporaryGame = game;

        for (int i=0;i<5;i++) {
            try {
                if (isBetterGame(temporaryGame, bestGames[i])) {
                    temporaryGame2 = bestGames[i];
                    bestGames[i] = temporaryGame;
                    temporaryGame = temporaryGame2;
                }
            }catch (NullPointerException e) {
                bestGames[i] = game;
            }
        }
    }

    private boolean isBetterGame(Game game1, Game game2) {
        if (game1.gameResult(this)>game2.gameResult(this))
            return true;
        else if (game1.gameResult(this)<game2.gameResult(this))
            return false;

        if (game1.scoreComparison(this)>game2.scoreComparison(this))
            return true;

        else if (game1.scoreComparison(this)<game2.scoreComparison(this))
            return false;

        if (game1.getTime().isAfter(game2.getTime()))
            return true;

        else
            return false;
    }

    public double getScore() {
        return score;
    }

    public String getName() {
        return name;
    }



    //in game variables and functions
    protected char[][] board;
    protected char sign;

    void makeMove(char[][] board) {
        this.board=board;
    }

    public void setSign(char sign) {
        this.sign = sign;
    }
}

