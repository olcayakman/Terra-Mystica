package com.TerraMystica.GameLogic;

public class Income {

    private int worker;
    private int coin;
    private int priest;
    private int power;

    // It is only used by factory methods of this class.
    private Income(int worker, int coin, int priest, int power) {
        this.worker = worker;
        this.coin = coin;
        this.priest = priest;
        this.power = power;
    }

    public static Income withWorker(int worker) {
        return new Income(worker, 0, 0, 0);
    }

    public static Income withCoinAndPower(int coin, int power) {
        return new Income(0, coin, 0, power);
    }

    public static Income withPower(int power) {
        return new Income(0, 0, 0, power);
    }

    public static Income withPriest(int priest) {
        return new Income(0, 0, priest, 0);
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
