package com.game.snakeandladder;

public class Dice {

    public Dice() {
    }

    Dice(Dice other) {
    }

    public static Dice copyInstance(Dice dice) {
        return new Dice(dice);
    }

    public int roll() {
        int diceState = (int) (Math.random() * 6 + 1);
        return diceState;
    }
}
