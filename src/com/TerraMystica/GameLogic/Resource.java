package com.TerraMystica.GameLogic;

public class Resource {
    private int worker;
    private int coin;
    private int priest;
    private int power;
    private int spade;

    public Resource(Resource other) {
        this.worker = other.worker;
        this.coin = other.coin;
        this.priest = other.priest;
        this.power = other.power;
        this.spade = other.spade;
    }

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

    public void spendCost(Cost cost) {
        this.worker -= cost.getWorker();
        this.coin -= cost.getCoin();
        this.priest -= cost.getPriest();
        this.power -= cost.getPower();
        this.spade -= cost.getSpade();
    }

    public void addIncome(Income income) {
        this.worker += income.getWorker();
        this.coin += income.getCoin();
        this.priest += income.getPriest();
        this.power += income.getPower();
        this.spade += income.getSpade();
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

    public void setPower(int power) {
        this.power = power;
    }

    public void setPriest(int priest) {
        this.priest = priest;
    }
}
