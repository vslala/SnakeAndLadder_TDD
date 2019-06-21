package com.game.snakeandladder;

public class FakeDice extends Dice {

    private int currState = 0;

    public void setState(int diceState) {
        this.currState = diceState;
    }

    @Override
    public int roll() {
        return currState--;
    }
}
