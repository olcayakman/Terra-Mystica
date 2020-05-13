package com.TerraMystica.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Resource resource;
    private Faction faction;
    private List<Dwelling> dwellings;
    private List<TradingHouse> tradingHouses;
    private List<Stronghold> strongholds;
    private List<Temple> temples;
    private List<Sanctuary> sanctuaries;


    public Player(Faction faction) {
        this.faction = faction;
        this.resource = faction.initializeResources();
        this.dwellings = new ArrayList<Dwelling>();
        this.tradingHouses = new ArrayList<TradingHouse>();
        this.strongholds = new ArrayList<Stronghold>();
        this.temples = new ArrayList<Temple>();
        this.sanctuaries = new ArrayList<Sanctuary>();
    }

    public void terraformAndBuild(Hexagon hexagon) {
        resource.spendCost(faction.getSpadeCost(hexagon));
        faction.terraform(hexagon);
        resource.spendCost(faction.getDwellingCost());
        addStructure(new Dwelling(hexagon));
    }

    public void collectIncome() {
        resource.addIncome(faction.getDwellingIncome(dwellings.size()));
        resource.addIncome(faction.getTradingHouseIncome(tradingHouses.size()));
        resource.addIncome(faction.getStrongholdIncome(strongholds.size()));
        resource.addIncome(faction.getTempleIncome(temples.size()));
        resource.addIncome(faction.getSanctuaryIncome(sanctuaries.size()));
    }

    private void addStructure(Dwelling dwelling) {
        dwellings.add(dwelling);
    }

    public List<Dwelling> getStructures() {
        return dwellings;
    }

    public Resource getResource() {
        return resource;
    }

    public Faction getFaction() {
        return faction;
    }
}
