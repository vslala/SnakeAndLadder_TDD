package com.game.snakeandladder;

import java.util.Objects;

public class Box {

    private final int position;

    public Box(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public Box getEndBox() {
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;
        Box box = (Box) o;
        return getPosition() == box.getPosition();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPosition());
    }
}
