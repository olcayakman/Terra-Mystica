package com.TerraMystica.GameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGame {
    Game game;
    Player player1;
    Player player2;

    @BeforeEach
    void setup() {
        player1 = new Player(new Witches());
        player2 = new Player(new Witches());
        List <Player> playerList = new ArrayList<Player>();
        playerList.add(player1);
        playerList.add(player2);

        game = new Game(playerList);
    }

    @Test
    void testExecuteIncomePhase() {
        player1.terraformAndBuild(new Hexagon(player1.getFaction().getTerrainType()));
        player2.terraformAndBuild(new Hexagon(player2.getFaction().getTerrainType()));

        Resource beforeResourcePlayer1 = new Resource(player1.getResource());
        Resource beforeResourcePlayer2 = new Resource(player2.getResource());
        game.executeIncomePhase();
        Resource afterResourcePlayer1 = player1.getResource();
        Resource afterResourcePlayer2 = player2.getResource();

        TestPlayer.incomeTest(afterResourcePlayer1, beforeResourcePlayer1);
        TestPlayer.incomeTest(afterResourcePlayer2, beforeResourcePlayer2);
    }

    @Test
    void testNextTurn() {
        assertEquals(game.getCurrentPlayer(), player1, "The current player should be player1 at the beginning.");
        assertEquals(game.getNextPlayer(), player2, "Next player should be player2 at the beginning. ");

        game.nextTurn();

        assertEquals(game.getCurrentPlayer(), player2, "The current player should be player2 in the second turn.");
        assertEquals(game.getNextPlayer(), player1, "Next player should be player1 in the second turn.");

        game.nextTurn();

        assertEquals(game.getCurrentPlayer(), player1, "The current player should be player1 in the third turn.");
        assertEquals(game.getNextPlayer(), player2, "Next player should be player2 in the third turn. ");
    }

    @Test
    void testPass() {
        var sizeBeforePass = game.getActivePlayers().size();
        var currentPlayerBeforePass = game.getCurrentPlayer();
        game.pass();
        var sizeAfterPass = game.getActivePlayers().size();

        assertTrue(sizeAfterPass < sizeBeforePass, "Active players should decrease after passing.");
        assertFalse(game.getActivePlayers().contains(currentPlayerBeforePass), "The passed player should be removed from active player's list.");
    }

    @Test
    void testIsEndOfActionPhase() {
        assertFalse(game.isEndOfActionPhase(), "Action phase should continue when there are active players.");
        game.nextTurn();
        assertFalse(game.isEndOfActionPhase(), "Action phase should continue when there are active players.");
        game.nextTurn();
        assertFalse(game.isEndOfActionPhase(), "Action phase should continue when there are active players.");
        game.pass();
        assertFalse(game.isEndOfActionPhase(), "Action phase should continue when there are active players.");
        game.nextTurn();
        assertFalse(game.isEndOfActionPhase(), "Action phase should continue when there are active players.");
        game.pass();
        assertFalse(game.isEndOfActionPhase(), "Action phase should not finish before next turn.");
        game.nextTurn();
        assertTrue(game.isEndOfActionPhase(), "Action phase should be completed when there is no active player, and the turn is switched to next player.");
    }

    @Test
    void actionPhaseTest() {
        var nextPlayerBeforePass = game.getNextPlayer();
        game.pass();
        game.nextTurn();
        var currentPlayerAfterPass = game.getCurrentPlayer();

        assertEquals(nextPlayerBeforePass, currentPlayerAfterPass, "The next player before pass should be the current player after pass.");

        var currentPlayerBeforeNextTurn = game.getCurrentPlayer();
        game.nextTurn();
        var currentPlayerAfterNextTurn = game.getCurrentPlayer();

        assertEquals(currentPlayerBeforeNextTurn, currentPlayerAfterNextTurn, "Next turn should be the same when there is a single player.");
        game.pass();
        assertTrue(game.getActivePlayers().isEmpty(), "Active player list should be empty after two passes for game with 2 players.");
        game.nextTurn();
        assertTrue(game.isEndOfActionPhase(), "Action phase should be completed when there is no active player, and the turn is switched to next player.");
    }

    @Test
    void testInitializeRound() {
        var roundBeforeInitialization = game.getRound();
        game.initializeRound();
        assertTrue(roundBeforeInitialization < game.getRound(), "Round is incremented by one after round initialization");
        game.initializeRound();
        assertTrue(roundBeforeInitialization < game.getRound(), "Round is incremented by one after round initialization");
        assertTrue(game.getActivePlayers().equals(game.getPlayers()), "Active player list size should be equal to player list size after round initialization");
    }

    @Test
    void testIsEndOfRound() {
       finishActionPhase();
    }

    @Test
    void testIsEndOfGame() {
        for (int i = 0; i < 5; i++) {
            game.initializeRound();
        }
        finishActionPhase();
        assertEquals(6, game.getRound(), "Round should be equal to 6 after 5 round initializations.");
        assertTrue(game.isEndOfGame(), "Game should be finished at the end of Round 6.");
    }

    @Test
    void roundTest() {
        assertEquals(1, game.getRound(), "Round should be equal to 1 at the beginning of game.");
        game.executeIncomePhase();
        assertEquals(1, game.getRound(), "Round should be equal to 1 at the beginning of game.");
        finishActionPhase();
        assertEquals(1, game.getRound(), "Round should be equal to 1 at the beginning of game.");
        game.initializeRound();
        assertEquals(2, game.getRound(), "Round should be equal to 2 after first initialization of the round during the game.");
    }

    void finishActionPhase() {
        game.pass();
        game.nextTurn();
        game.pass();
        game.nextTurn();
        assertTrue(game.isEndOfActionPhase(), "Action phase should be finished when all players passed.");
        assertTrue(game.isEndOfRound(), "Round should be finished at the end of action phase.");
    }
}
