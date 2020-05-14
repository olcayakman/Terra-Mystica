package com.TerraMystica.GameLogic;

import java.util.Map;

public abstract class Faction {

    Map<TerrainType, Integer> terraformingCost;

    public Cost getSpadeCost(Terrain terrain) {
        return Cost.withSpade(terraformingCost.get(terrain.getTerrainType()));
    }

    public abstract Resource initializeResources();

    public abstract TerrainType getTerrainType();

    public abstract void terraform(Terrain terrain);

    public abstract Income getDwellingIncome(int dwellingCount);
    public abstract Income getTradingHouseIncome(int tradingHouseCount);
    public abstract Income getStrongholdIncome(int strongholdCount);
    public abstract Income getTempleIncome(int templeCount);
    public abstract Income getSanctuaryIncome(int sanctuaryCount);

    public abstract Cost getDwellingCost();
    public abstract Cost getTradingHouseCost();
    public abstract Cost getStrongholdCost();
    public abstract Cost getTempleCost();
    public abstract Cost getSanctuaryCost();
    public abstract Cost getUpgradeSpadeLevelCost();
    public abstract Cost getUpgradeShippingLevelCost();
    public abstract Cost getPriestCost();
    public abstract Cost getWorkerCost();
    public abstract Cost getCoinCost();

}
