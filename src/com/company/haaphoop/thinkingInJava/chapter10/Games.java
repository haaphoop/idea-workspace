package com.company.haaphoop.thinkingInJava.chapter10;

/**
 * Created by daishuli on 2017/7/4.
 */
public class Games {

    public static void playGame(GameFactory gameFactory){
        Game game = gameFactory.getGame();
        while (game.move());
    }

    public static void main(String[] args) {
        playGame(Checkers.gameFactory);
        playGame(Chess.gameFactory);
    }
}

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

class Checkers implements Game {
    private Checkers(){};
    private int moves = 0;
    private static final int MOVES = 3;

    @Override
    public boolean move() {
        System.out.println("Checkers move " + moves);
        return ++moves != MOVES;
    }
    public static GameFactory gameFactory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Checkers();
        }
    };
}
class Chess implements Game {
    private Chess(){};
    private int moves = 0;
    private static final int MOVE = 4;
    @Override
    public boolean move() {
        System.out.println("Chess move " + moves);
        return ++moves!= MOVE;
    }
    public static GameFactory gameFactory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Chess();
        }
    };
}