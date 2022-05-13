package model;

import java.util.Random;

public final class MediumPlayer extends Player {

    char opponentSign;
    int winValue;
    int loseValue;

    public MediumPlayer(String name) {
        super(name);
    }

    void makeMove(char[][] board) {
        int i, j;
        boolean opponentCanWin = false;
        this.board = board;

        loop1: for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (Board.isEmptyBox(board[i][j])) {
                    board[i][j] = sign;
                    if (Board.result(board) == winValue) {
                        break loop1;
                    }
                    board[i][j] = '-';
                }
            }
        }

        loop2: for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (Board.isEmptyBox(board[i][j])) {
                    board[i][j] = opponentSign;
                    if (Board.result(board) == loseValue) {
                        break loop2;
                    }
                    board[i][j] = '-';
                }
            }
        }

        if (!opponentCanWin) {
            playRandomly();
        }
    }

    private void playRandomly() {
        int i, j;
        Random rand = new Random();
        int moves = 0;
        int randomMove = rand.nextInt(Board.movesLeft(board));

        loop:
        for (i = 0; i < 3; i++) {

            for (j = 0; j < 3; j++) {
                if (Board.isEmptyBox(board[i][j])) {
                    if (moves == randomMove) {
                        board[i][j] = sign;
                        break loop;
                    }
                    moves++;
                }
            }
        }
    }


    public void setSign(char sign) {
        this.sign = sign;
        opponentSign = (sign=='X')?'O':'X';

        winValue = (sign=='X')?10:-10;
        loseValue = -winValue;
    }

}

