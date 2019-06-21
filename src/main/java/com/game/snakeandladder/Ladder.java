package com.game.snakeandladder;

public class Ladder extends Box {

    private Box endBox;

    public Ladder(int position) {
        super(position);
        int limit = ((position / 10) + 1) * 10;
        System.out.println(limit);
        int endPosition = ((int) (Math.random() * limit)) + position;
        endBox = new Box(endPosition);
    }

    @Override
    public Box getEndBox() {
        return endBox;
    }
}
