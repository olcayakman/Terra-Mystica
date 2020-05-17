package com.TerraMystica.GameLogic;

public abstract class IncomeOrCost {
    private int worker;
    private int coin;
    private int priest;
    private int power;
    private int spade;
    private int victoryPoints;

    public IncomeOrCost(int worker, int coin, int priest, int power, int spade, int victoryPoints) {
        this.worker = worker;
        this.coin = coin;
        this.priest = priest;
        this.power = power;
        this.spade = spade;
        this.victoryPoints = victoryPoints;
    }

    public int getWorker() {
        return worker;
    }

    public int getCoin() {
        return coin;
    }

    public int getPriest() {
        return priest;
    }

    public int getPower() {
        return power;
    }

    public int getSpade() {
        return spade;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }
}
