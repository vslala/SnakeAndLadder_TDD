package com.game.snakeandladder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DiceTest {

    private Dice dice;

    @Before
    public void setup() {
        dice = new Dice();
    }

    @Test
    public void itShouldRollAndGenerateRandomNumberBetweenOneAndSixIncluded() {
        // given
        // when
        int currRoll = dice.roll();
        List<Integer> validStates = Arrays.asList(1,2,3,4,5,6);

        // then
        Assert.assertTrue(currRoll > 0);
        Assert.assertTrue(currRoll < 7);
        Assert.assertTrue(validStates.contains(currRoll));
    }


}
