package model;

public class Board {

    public static boolean isPlayer1Turn(char[][] board) {
        int i, j;
        int emptyBoxes=0;
        for (i=0;i<3;i++) {
            for (j=0;j<3;j++) {
                if (board[i][j] == '-') {
                    emptyBoxes++;
                }
            }
        }
        return emptyBoxes % 2 != 0;
    }


    public static int result(char[][] board) {
        int i;
        int result=0;
        boolean finishedGame=false;

        for (i = 0; i < 3; i++) {
            if ((board[i][0]==board[i][1])&&(board[i][1]==board[i][2])) {
                if (board[i][0]!='-') {
                    result=(board[i][0]=='X')?10:-10;
                    finishedGame=true;
                }
            }
        }

        for (i = 0; i < 3; i++) {
            if ((board[0][i]==board[1][i])&&(board[1][i]==board[2][i])) {
                if (board[0][i]!='-') {
                    result=(board[0][i]=='X')?10:-10;
                    finishedGame=true;
                }
            }
        }

        if ((board[0][0]==board[1][1])&&(board[1][1]==board[2][2])) {
            if (board[1][1]!='-') {
                result=(board[1][1]=='X')?10:-10;
                finishedGame=true;
            }
        }

        else if ((board[0][2]==board[1][1])&&(board[1][1]==board[2][0])) {
            if (board[1][1]!='-') {
                result=(board[1][1]=='X')?10:-10;
                finishedGame=true;
            }
        }

        else if (!finishedGame){
            result=0;
        }

        return result;
    }

    static void printBoard(char[][] board) {
        int i,j;
        for (i=0;i<3;i++) {
            for (j=0;j<3;j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isFull(char[][] board) {
        int i,j;
        for (i=0;i<3;i++) {
            for (j=0;j<3;j++) {
                if (board[i][j]=='-')
                    return false;
            }
        }
        return true;
    }

    static boolean isEmptyBox(char box) {
        return box == '-';
    }

    static int movesLeft(char[][] grid) {
        int i,j;
        int emptyBoxes = 0;
        for (i=0;i<3;i++) {
            for (j=0;j<3;j++) {
                if (grid[i][j]=='-')
                    emptyBoxes++;
            }
        }
        return emptyBoxes;
    }

}
