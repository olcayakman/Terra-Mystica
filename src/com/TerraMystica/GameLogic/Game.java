package com.TerraMystica.GameLogic;

import java.util.*;

public class Game {
    private List<Player> players;
    private List<Player> activePlayers;
    private Player currentPlayer;
    private Player nextPlayer;
    int round;

    public Game(List<Player> players) {
        this.players = new ArrayList<Player>(players);
        round = 0;
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

    public List<Player> getAreaRanking() {
        List<Player> result = getPlayers();
        Comparator<Player> byMaxNumberOfConnectedStructures = Comparator.comparing(Player::getMaxNumberOfConnectedStructures);
        Collections.sort(result, byMaxNumberOfConnectedStructures);
        Collections.reverse(result);
        return result;
    }

    public void updateScore() {
        List<Player> players = getAreaRanking();
        players.get(0).setScore(players.get(0).getVictoryPoints() + 18);
        players.get(1).setScore(players.get(1).getVictoryPoints() + 12);
        if (players.size() > 2) {
            players.get(2).setScore(players.get(2).getVictoryPoints() + 6);
        }
    }

    public List<Player> getPlayerRanking() {
        List<Player> result = getPlayers();
        Comparator<Player> byScore = Comparator.comparing(Player::getScore);
        Collections.sort(result, byScore);
        Collections.reverse(result);
        return result;
    }

    public boolean isEndOfRound() {
        return isEndOfActionPhase();
    }

    public boolean isEndOfGame() {
        return round >= 6 && isEndOfRound();
    }

    public List<Player> getPlayers() {
        return new ArrayList<Player>(players);
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
