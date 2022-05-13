package model;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Pavlos");
        Person person2 = new Person("Nikos");
        AI hal = new AI("Hal");
        AI hal2 = new AI("Hal 2");
        RandomPlayer mrBean = new RandomPlayer("MrBean");
        RandomPlayer mrBean2 = new RandomPlayer("MrBean2");
        MediumPlayer medium = new MediumPlayer("Medium");

        Game game = new Game(person1, hal);

        game.playGame();
    }
}

