package com.game.snakeandladder;

import java.util.List;
import java.util.Objects;

public class Player {
    private final String name;
    private Box currPosition = new Box(-1);

    public Player(String name) {
        this.name = name;
    }

    private Player(Player other) {
        this.name = other.name;
        this.currPosition = other.currPosition;
    }

    public static Player copyInstance(Player player) {
        return new Player(player);
    }

    public Box rollDice(Dice dice, List<Box> boxes) {
        int diceState = dice.roll();
        System.out.println(this.getName() + " rolls. Dice State: " + diceState);
        if (hasNotStarted() && scoresSix(diceState)) {
            this.currPosition = new Box(0);
            return rollDice(dice, boxes);
        }

        if (hasNotStarted() && diceState != 6)
            return currPosition;

        int nextPosition = this.currPosition.getPosition() + diceState;
        if (nextPosition > 100)
            return this.currPosition;

        this.currPosition = boxes.get(nextPosition).getEndBox().getPosition() > 100 ? this.currPosition
                : boxes.get(nextPosition).getEndBox();

        if (scoresSix(diceState)) {
            this.currPosition = rollDice(dice, boxes);
            System.out.println("Player Position: " + this.currPosition.getPosition());
        }

        return this.currPosition;
    }

    private boolean getNextPosition(List<Box> boxes, int diceState) {
        int currPosition = this.currPosition.getPosition() + diceState;
        this.currPosition = boxes.get(-currPosition).getEndBox();
        if (this.currPosition.getPosition() > 100)
            return true;
        return false;
    }

    private boolean scoresSix(int diceState) {
        return diceState == 6;
    }

    private boolean hasNotStarted() {
        return currPosition.getPosition() == -1;
    }

    public String getName() {
        return name;
    }

    public Box getCurrPosition() {
        return currPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getName(), player.getName()) &&
                Objects.equals(getCurrPosition(), player.getCurrPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCurrPosition());
    }
}
