package model;

import java.util.Random;

public final class RandomPlayer extends Player {

    public RandomPlayer(String name) {
        super(name);
    }

    void makeMove(char[][] board) {
        int i, j;
        Random rand = new Random();
        this.board = board;

        int moves = 0;

        int randomMove = rand.nextInt(Board.movesLeft(board));

        loop: for (i = 0; i < 3; i++) {
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
}

