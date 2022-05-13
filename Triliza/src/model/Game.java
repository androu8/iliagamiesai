package model;

import java.time.LocalDateTime;

public class Game {
    private Player player1, player2;
    private String player1Name, player2Name;
    private double player1Score, player2Score;
    private int gameResult;
    private LocalDateTime time;
    private char[][] board;
    static boolean inGame;

    Game(Player player1, Player player2) {
        inGame=true;
        time = LocalDateTime.now();

        this.player1=player1;
        this.player2=player2;

        this.player1Name = player1.getName();
        this.player2Name = player2.getName();

        this.player1Score = player1.getScore();
        this.player2Score = player2.getScore();

        player1.setSign('X');
        player2.setSign('O');

        board = new char[3][3];

        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                board[i][j] = '-';
            }
        }

    }

    void playGame() {
        while (true) {
            if (Board.result(board)==0 && !Board.isFull(board)) {

                if (Board.isPlayer1Turn(board)){
                    player1.makeMove(board);
                }
                else {
                    player2.makeMove(board);
                }

                Board.printBoard(board);
            }

            else if (Board.result(board)==10) {
                System.out.println("Player " + player1.getName() + " wins!");
                gameResult = 10;
                player1.updatePlayerState(gameResult(player1), this);
                player2.updatePlayerState(gameResult(player2), this);
                inGame=false;
                break;
            }

            else if (Board.result(board)==-10) {
                System.out.println("Player " + player2.getName() + " wins!");
                gameResult = -10;
                player1.updatePlayerState(gameResult(player1), this);
                player2.updatePlayerState(gameResult(player2), this);
                inGame=false;
                break;
            }
            else {
                System.out.println("It is a tie!");
                gameResult = 0;
                player1.updatePlayerState(gameResult(player1), this);
                player2.updatePlayerState(gameResult(player2), this);
                inGame=false;
                break;
            }
        }
    }

    public int gameResult(Player player) {
        if (player1.equals(player))
            return gameResult;

        else
            return -gameResult;


    }

    public int scoreComparison(Player player) {
        if (player1.equals(player)) {
            if (player1Score>player2Score)
                return -10;
            else if (player1Score<player2Score)
                return 10;
            else
                return 0;
        }

        else {
            if (player2Score>player1Score)
                return -10;
            else if (player2Score<player1Score)
                return 10;
            else
                return 0;
        }
    }

    public LocalDateTime getTime() {
        return time;
    }
}

