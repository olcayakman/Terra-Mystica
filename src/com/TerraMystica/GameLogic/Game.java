package com.TerraMystica.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private List<Player> activePlayers;
    private Player currentPlayer;
    private Player nextPlayer;
    int round;

    public Game(List<Player> players) {
        this.players = new ArrayList<Player>(players);
        round = 0;
        initializeRound();
    }

    public void executeIncomePhase() {
        players.forEach(player -> player.collectIncome());
    }

    public void nextTurn() {
        if (activePlayers.isEmpty()) {
            currentPlayer = null;
            nextPlayer = null;
            return;
        }

        currentPlayer = nextPlayer;
        var nextPlayerIndex = activePlayers.indexOf(currentPlayer) + 1;

        if (nextPlayerIndex >= activePlayers.size()) {
            nextPlayerIndex = 0;
        }

        nextPlayer = activePlayers.get(nextPlayerIndex);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void pass() {
        activePlayers.remove(getCurrentPlayer());
    }

    public boolean isEndOfActionPhase() {
       return currentPlayer == null;
    }

    public void initializeRound() {
        activePlayers = new ArrayList<Player>(players);
        currentPlayer = activePlayers.get(0);
        nextPlayer = activePlayers.get(1); // Assuming there are always at least 2 active players in the beginning.
        round++;
    }

    public boolean isEndOfRound() {
        return isEndOfActionPhase();
    }

    public boolean isEndOfGame() {
        return round >= 6 && isEndOfRound();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public List<Player> getActivePlayers() {
        return new ArrayList<Player>(activePlayers); // To prevent the mutation of actual activePlayers list.
    }

    public int getRound() {
        return round;
    }
}
