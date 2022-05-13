package model;

public final class AI extends Player{
    private int rowMove;
    private int colMove;
    private char opponentSign;
    private int winValue;
    private int loseValue;

    public AI(String name) {
        super(name);
    }

    public int minimax(char[][] board, int depth, Boolean isMaximizing)
    {
        if (Board.result(board)==winValue)
            return winValue;

        else if (Board.result(board)==loseValue)
            return loseValue;

        else if (Board.result(board)==0 && Board.isFull(board))
            return 0;

        if(isMaximizing) {
            int i, j;
            int best;
            best = (winValue==10)?-20:20;

            for (i=0;i<3;i++) {
                for (j=0;j<3;j++) {

                    if (board[i][j]=='-') {
                        board[i][j] = sign;

                        if (winValue==10) {
                            best = Math.max(best, minimax(board, depth + 1, false));
                        }
                        else {
                            best = Math.min(best, minimax(board, depth + 1, false));
                        }
                        board[i][j] = '-';
                    }

                }
            }
            return best;
        }

        else {
            int i, j;
            int best= (winValue==10)?20:-20;

            for (i=0;i<3;i++) {
                for (j=0;j<3;j++) {

                    if (board[i][j] == '-') {
                        board[i][j] = opponentSign;

                        if (winValue==10) {
                            best = Math.min(best, minimax(board, depth + 1, true));
                        }
                        else {
                            best = Math.max(best, minimax(board, depth + 1, true));
                        }

                        board[i][j] = '-';
                    }

                }
            }
            return best;
        }
    }

    void findBestMove(char[][] board)
    {
        int i, j;
        int best;
        int moveValue;


        best = (winValue==10)?-20:20;

        for (i=0;i<3;i++) {
            for (j=0;j<3;j++) {

                if (board[i][j]=='-') {

                    board[i][j]=sign;

                    moveValue = minimax(board, 0, false);

                    if (winValue==10) {
                        if (moveValue > best) {
                            rowMove = i;
                            colMove = j;
                            best = moveValue;
                        }
                    }

                    else {
                        if (moveValue < best) {
                            rowMove = i;
                            colMove = j;
                            best = moveValue;
                        }
                    }

                    board[i][j]='-';

                }

            }
        }
    }

    void makeMove(char[][] board)  {
        this.board=board;

        findBestMove(board);
        board[rowMove][colMove] = sign;
    }

    public void setSign(char sign) {
        this.sign = sign;
        opponentSign = (sign=='X')?'O':'X';

        winValue = (sign=='X')?10:-10;
        loseValue = -winValue;
    }

}
