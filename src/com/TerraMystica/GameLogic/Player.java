package com.TerraMystica.GameLogic;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private Resource resource;
    private Faction faction;
    private List<Dwelling> dwellings;
    private List<TradingHouse> tradingHouses;
    private List<Stronghold> strongholds;
    private List<Temple> temples;
    private List<Sanctuary> sanctuaries;
    private int shippingValue;


    public Player(Faction faction) {
        this.faction = faction;
        resource = faction.initializeResources();
        dwellings = new ArrayList<Dwelling>();
        tradingHouses = new ArrayList<TradingHouse>();
        strongholds = new ArrayList<Stronghold>();
        temples = new ArrayList<Temple>();
        sanctuaries = new ArrayList<Sanctuary>();
        shippingValue = 0;
    }

    public void terraformAndBuild(Terrain terrain) {
        resource.spendCost(faction.getSpadeCost(terrain));
        faction.terraform(terrain);
        resource.spendCost(faction.getDwellingCost());
        addStructure(new Dwelling(terrain));
    }

    public void collectIncome() {
        resource.addIncome(faction.getDwellingIncome(dwellings.size()));
        resource.addIncome(faction.getTradingHouseIncome(tradingHouses.size()));
        resource.addIncome(faction.getStrongholdIncome(strongholds.size()));
        resource.addIncome(faction.getTempleIncome(temples.size()));
        resource.addIncome(faction.getSanctuaryIncome(sanctuaries.size()));
    }

    public List<Terrain> getTerrains() {
        List<Terrain> result = new ArrayList<>();
        getStructures().forEach(structure -> result.add(structure.getLocation()));
        return result;
    }

    public void addStructure(Dwelling dwelling) {
        dwellings.add(dwelling);
    }

    public void addStructure(Hexagon hexagon) {
        addStructure(new Dwelling((Terrain) hexagon));
    }

    public List<Structure> getStructures() {
        List<Structure> result = new ArrayList<>();
        result.addAll(dwellings);
        result.addAll(tradingHouses);
        result.addAll(strongholds);
        result.addAll(temples);
        result.addAll(sanctuaries);
        return result;
    }

    public Resource getResource() {
        return resource;
    }

    public Faction getFaction() {
        return faction;
    }

    public int getShippingValue() {
        return shippingValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dwelling> getDwellings() {
        return dwellings;
    }

    public List<TradingHouse> getTradingHouses() {
        return tradingHouses;
    }

    public List<Stronghold> getStrongholds() {
        return strongholds;
    }

    public List<Temple> getTemples() {
        return temples;
    }

    public List<Sanctuary> getSanctuaries() {
        return sanctuaries;
    }
}
