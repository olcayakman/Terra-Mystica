package com.TerraMystica.GameLogic;

public class Cost extends IncomeOrCost {

    // It is only used by factory methods of this class.
    private Cost(int worker, int coin, int priest, int power, int spade) {
        super(worker, coin, priest, power, spade);
    }

    public static Cost withWorkerAndCoin(int worker, int coin) {
        return new Cost(worker, coin, 0, 0, 0);
    }

    public static Cost withWorkerCoinAndPriest(int worker, int coin, int priest) {
        return new Cost(worker, coin, priest, 0, 0);
    }

    public static Cost withCoinAndPriest(int coin, int priest) {
        return new Cost(0, coin, priest, 0, 0);
    }

    public static Cost withPower(int power) {
        return new Cost(0, 0, 0, power, 0);
    }

    public static Cost withSpade(int spade) {
        return new Cost(0, 0, 0, 0, spade);
    }

}
