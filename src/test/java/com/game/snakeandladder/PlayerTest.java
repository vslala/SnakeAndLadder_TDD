package com.game.snakeandladder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private Player player;
    private FakeDice dice;
    private GameBoard gameBoard;

    @Before
    public void setup() {
        gameBoard = GameBoard.newInstance();
        gameBoard.initGameBoard();
        player = new Player("Varun");
        dice = new FakeDice();
    }

    @Test
    public void playerRollsTheDiceForTheFirstTimeAndDoNotScoreASix() {
        dice.setState(1);
        Box nextPosition = player.rollDice(dice, gameBoard.get());

        Assert.assertTrue(nextPosition.getPosition() == -1);
    }

    @Test
    public void playerRollsTheDiceForTheFirstTimeAndScoresASix() {
        dice.setState(6);
        Box nextPosition = player.rollDice(dice, gameBoard.get());

        Assert.assertEquals(5, nextPosition.getPosition());
    }

    @Test
    public void playerRollsTheDiceAfterScoringASix() {
        dice.setState(6);
        player.rollDice(dice, gameBoard.get());

        dice.setState(4);
        Box nextPosition = player.rollDice(dice, gameBoard.get());

        Assert.assertEquals(9, nextPosition.getPosition());
    }

    @Test
    public void playerRollsDiceBeyondHundred() {
        dice.setState(6);
        player.rollDice(dice, gameBoard.get());

        dice.setState(111);
        Box nextPosition = player.rollDice(dice, gameBoard.get());

        Assert.assertEquals(5, nextPosition.getPosition());
    }

    @Test
    public void playerRollsTwoSixesFromPosition99() {
        dice.setState(6);
        player.rollDice(dice, gameBoard.get());

        dice.setState(93);
        player.rollDice(dice, gameBoard.get());

        dice.setState(6);
        player.rollDice(dice, gameBoard.get());

        dice.setState(6);
        Box nextPosition = player.rollDice(dice, gameBoard.get());

        Assert.assertEquals(98, nextPosition.getPosition());
    }

    @Test
    public void playerRollsASixShouldGetASecondChance() {
        playerRollsTheDiceAfterScoringASix();
        dice.setState(6);
        Box nextPosition = player.rollDice(dice, gameBoard.get());

        Assert.assertTrue(nextPosition.getPosition() > 10);
    }
}
