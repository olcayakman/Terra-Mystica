package com.TerraMystica.GameLogic;

import java.util.List;

public class Game {
    List<Player> players;

    public void executeIncomePhase() {
        players.forEach(player -> player.collectIncome());
    }
}
