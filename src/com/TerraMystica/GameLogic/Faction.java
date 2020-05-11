package com.TerraMystica.GameLogic;

import java.util.Map;

public abstract class Faction {

    Map<TerrainType, Integer> terraformingCost;

    public Integer getCost(Hexagon hexagon) {
        return terraformingCost.get(hexagon.getTerrainType());
    }

    public abstract Resource initializeResources();

    public abstract TerrainType getTerrainType();

    public abstract void terraform(Hexagon hexagon);

    public abstract Income awardDwellingIncome(int dwellingCount);

    public abstract Income awardTradingHouseIncome(int tradingHouseCount);

    public abstract Income awardStrongholdIncome(int strongholdCount);

    public abstract Income awardTempleIncome(int templeCount);

    public abstract Income awardSanctuaryIncome(int sanctuaryCount);
}
