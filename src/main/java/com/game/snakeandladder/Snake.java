package com.game.snakeandladder;

public class Snake extends Box {

    private Box endBox;

    public Snake(int position) {
        super(position);
        int limit = (position / 10) * 10;
        System.out.println(limit);
        int endPosition = (int) (Math.random() * limit);
        endBox = new Box(endPosition);
    }

    @Override
    public Box getEndBox() {
        return this.endBox;
    }
}
