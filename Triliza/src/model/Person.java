package model;

import java.util.Scanner;
final public class Person extends Player{


    public Person(String name) {
        super(name);
    }

    int rowMove() {
        System.out.print("Row: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    int colMove() {
        System.out.print("Col: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    void makeMove(char[][] board) {
        this.board=board;
        board[rowMove()][colMove()]=sign;
    }
}

