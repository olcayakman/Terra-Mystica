package com.TerraMystica.GameLogic;

public class Income extends IncomeOrCost{

    // It is only used by factory methods of this class.
    private Income(int worker, int coin, int priest, int power, int spade) {
        super(worker, coin, priest, power, spade);
    }

    public static Income withWorker(int worker) {
        return new Income(worker, 0, 0, 0, 0);
    }

    public static Income withCoinAndPower(int coin, int power) {
        return new Income(0, coin, 0, power, 0);
    }

    public static Income withPower(int power) {
        return new Income(0, 0, 0, power, 0);
    }

    public static Income withPriest(int priest) {
        return new Income(0, 0, priest, 0, 0);
    }

}
