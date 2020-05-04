package com.TerraMystica.GameLogic;

public class Resource {
    private int worker;
    private int coin;
    private int priest;
    private int power;
    private int spade;

    public Resource(int worker, int coin) {
        this.worker = worker;
        this.coin = coin;
        priest = 0;
        power = 12;
        spade = 0;
    }

    public Resource(int worker, int coin, boolean priest) {
        this.worker = worker;
        this.coin = coin;
        this.priest = priest ? 1 : 0;
        power = 12;
        spade = 0;
    }

    public void spendSpades(int cost) {
        spade = spade - cost;
    }

    public int getSpade() {
        return spade;
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
}
