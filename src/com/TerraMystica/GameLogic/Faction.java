package com.TerraMystica.GameLogic;

import java.util.Map;

public abstract class Faction {

    Map<TerrainType, Integer> terraformingCost;

    public Cost getSpadeCost(Hexagon hexagon) {
        return Cost.withSpade(terraformingCost.get(hexagon.getTerrainType()));
    }

    public abstract Resource initializeResources();

    public abstract TerrainType getTerrainType();

    public abstract void terraform(Hexagon hexagon);

    public abstract Income awardDwellingIncome(int dwellingCount);
    public abstract Income awardTradingHouseIncome(int tradingHouseCount);
    public abstract Income awardStrongholdIncome(int strongholdCount);
    public abstract Income awardTempleIncome(int templeCount);
    public abstract Income awardSanctuaryIncome(int sanctuaryCount);

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
