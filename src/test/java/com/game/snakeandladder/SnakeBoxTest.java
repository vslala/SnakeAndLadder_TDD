package com.game.snakeandladder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SnakeBoxTest {

    private Snake snake;

    @Before
    public void setup() {
        snake = new Snake(23);
    }

    @Test
    public void itShouldInitializeEndBox() {
        Box endBox = snake.getEndBox();
        System.out.println(endBox.getPosition());
        Assert.assertTrue( endBox.getPosition() < 20);
        Assert.assertTrue(endBox.getPosition() > 0);
    }
}
