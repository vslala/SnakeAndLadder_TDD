package com.game.snakeandladder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GameBoardTest {

    private GameBoard gameBoard;

    @Before
    public void setup() {
        gameBoard = GameBoard.newInstance();
    }

    @Test
    public void itShouldInitializePlayerForTheGame() {
        // given
        Player player1 = new Player("Varun");
        Player player2 = new Player("Aakruti");

        // when
        boolean isInitialized = gameBoard.initPlayers(player1, player2);

        // then
        Assert.assertTrue(isInitialized);
        Assert.assertFalse(gameBoard.getPlayers().isEmpty());
    }

    @Test
    public void itShouldInitializeGameDice() {
        // Given
        Dice dice = new Dice();

        // when
        boolean isInitialized = gameBoard.initDice(dice);

        Assert.assertTrue(isInitialized);
        Assert.assertNotNull(gameBoard.getDice());
    }

    @Test
    public void itShouldInitializeTheSnakesAndLadderGameBoard() {
        boolean isInitialized = gameBoard.initGameBoard();
        Assert.assertTrue(isInitialized);
        Assert.assertEquals(gameBoard.get().size(), 101);
        Assert.assertEquals(5, gameBoard.get().stream().filter(box -> box instanceof Snake).toArray().length);
        Assert.assertEquals(7, gameBoard.get().stream().filter(box -> box instanceof Ladder).toArray().length);
    }

    @Test
    public void playerOneRollsTheDice() {
        gameBoard.initPlayers(new Player("Varun"), new Player("Aakruti"));
        gameBoard.initDice(new Dice());
        gameBoard.initGameBoard();

        Player currPlayer = gameBoard.play();

        Assert.assertEquals("Varun", currPlayer.getName());
        Assert.assertEquals(-1, currPlayer.getCurrPosition().getPosition());
        Assert.assertEquals(1, gameBoard.getPlayerTurn());
    }

//    @Ignore
    @Test
    public void playerShouldWinTheGame() {
        gameBoard.initPlayers(new Player("Aakruti"), new Player("Varun"), new Player("Rashmit"), new Player("Aayushi"));
        gameBoard.initDice(new Dice());
        gameBoard.initGameBoard();

        List<Player> winningPlayers = gameBoard.fastMode();

        winningPlayers.forEach(player -> System.out.println(player.getName()));
    }
}
