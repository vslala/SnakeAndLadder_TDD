package com.game.snakeandladder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LadderTest {
    private Ladder ladder;

    @Before
    public void setup() {
        ladder = new Ladder(23);
    }

    @Test
    public void itShouldInitializeEndBox() {
        Box endBox = ladder.getEndBox();
        System.out.println(endBox.getPosition());
        Assert.assertTrue( endBox.getPosition() > 30);
        Assert.assertTrue(endBox.getPosition() < 100);
    }
}
