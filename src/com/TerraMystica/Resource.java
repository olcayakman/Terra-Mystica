package com.TerraMystica;

public class Resource {
    private int worker;
    private int coin;
    private int priest;
    private int power;
    private int spade;

    public void spendSpades(int cost) {
        spade = spade - cost;
    }

    public int getSpade() {
        return spade;
    }
}
