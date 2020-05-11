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

    public void terraform(Hexagon hexagon) {
        hexagon.setTerrainType(getTerrainType());
    }

    public Income awardDwellingIncome(int dwellingCount) {
        int worker = 1 + dwellingCount;
        if (dwellingCount >= 8) {
            worker = 8;
        }
        return Income.withWorker(worker);
    }

    public Income awardTradingHouseIncome(int tradingHouseCount) {
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
    public Income awardStrongholdIncome(int strongholdCount) {
        return Income.withPower(2 * strongholdCount);
    }

    @Override
    public Income awardTempleIncome(int templeCount) {
        return Income.withPriest(templeCount);
    }

    @Override
    public Income awardSanctuaryIncome(int sanctuaryCount) {
        return Income.withPriest(sanctuaryCount);
    }


}
