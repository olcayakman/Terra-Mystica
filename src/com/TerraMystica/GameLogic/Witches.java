package com.TerraMystica.GameLogic;

import java.util.Map;

public class Witches extends Faction {

    public Witches() {
        terraformingCost =  Map.ofEntries(
                Map.entry(TerrainType.FOREST,0),
                Map.entry(TerrainType.LAKES, 1),
                Map.entry(TerrainType.MOUNTAINS, 1),
                Map.entry(TerrainType.WASTELAND, 2),
                Map.entry(TerrainType.SWAMP, 2),
                Map.entry(TerrainType.PLAINS, 3),
                Map.entry(TerrainType.DESERT, 3)
        );
    }

    public Resource initializeResources() {
        return new Resource(3, 15);
    }

    public TerrainType getTerrainType() {
        return TerrainType.FOREST;
    }

    public void terraform(Terrain terrain) {
        terrain.setTerrainType(getTerrainType());
    }

    public Income getDwellingIncome(int dwellingCount) {
        int worker = 1 + dwellingCount;
        if (dwellingCount >= 8) {
            worker = 8;
        }
        return Income.withWorker(worker);
    }

    public Income getTradingHouseIncome(int tradingHouseCount) {
        int coin = 2 * tradingHouseCount;
        int power = tradingHouseCount;

        if (tradingHouseCount == 3) {
            power += 1;
        }
        else if (tradingHouseCount == 4) {
            power += 2;
        }
        return Income.withCoinAndPower(coin, power);
    }

    @Override
    public Income getStrongholdIncome(int strongholdCount) {
        return Income.withPower(2 * strongholdCount);
    }

    @Override
    public Income getTempleIncome(int templeCount) {
        return Income.withPriest(templeCount);
    }

    @Override
    public Income getSanctuaryIncome(int sanctuaryCount) {
        return Income.withPriest(sanctuaryCount);
    }

    @Override
    public Cost getDwellingCost() {
        return Cost.withWorkerAndCoin(1, 2);
    }

    @Override
    public Cost getTradingHouseCost() {
        return Cost.withWorkerAndCoin(2, 6);
    }

    @Override
    public Cost getStrongholdCost() {
        return Cost.withWorkerAndCoin(4, 6);
    }

    @Override
    public Cost getTempleCost() {
        return Cost.withWorkerAndCoin(2, 5);
    }

    @Override
    public Cost getSanctuaryCost() {
        return Cost.withWorkerAndCoin(4, 6);
    }

    @Override
    public Cost getUpgradeSpadeLevelCost() {
        return Cost.withWorkerCoinAndPriest(2, 5, 1);
    }

    @Override
    public Cost getUpgradeShippingLevelCost() {
        return Cost.withCoinAndPriest(4, 1);
    }

    @Override
    public Cost getPriestCost() {
        return Cost.withPower(5);
    }

    @Override
    public Cost getWorkerCost() {
        return Cost.withPower(3);
    }

    @Override
    public Cost getCoinCost() {
        return Cost.withPower(1);
    }

}
