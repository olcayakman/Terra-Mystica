package com.TerraMystica.GameLogic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private int victoryPoints;
    private int score;


    public Player(Faction faction) {
        this.faction = faction;
        resource = faction.initializeResources();
        dwellings = new ArrayList<Dwelling>();
        tradingHouses = new ArrayList<TradingHouse>();
        strongholds = new ArrayList<Stronghold>();
        temples = new ArrayList<Temple>();
        sanctuaries = new ArrayList<Sanctuary>();
        shippingValue = 0;
        victoryPoints = 20;
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

    public int getMaxNumberOfConnectedStructures() {
        int result = 0;

        for (var terrain : getTerrains()) {
            Set<Terrain> connectedTerrains = new HashSet<>();
            getConnectedTerrains(terrain, connectedTerrains);
            if (connectedTerrains.size() > result) {
                result = connectedTerrains.size();
            }
        }

        return result;
    }

    public void getConnectedTerrains(Terrain terrain, Set<Terrain> discovered) {
        if (discovered.contains(terrain)) {
            return;
        }
        discovered.add(terrain);

        var adjacentTerrains = GameBoard.getInstance().getAllAdjacentTerrains(terrain, shippingValue);
        adjacentTerrains.retainAll(getTerrains());

        for (var adjacentTerrain: adjacentTerrains) {
            getConnectedTerrains(adjacentTerrain, discovered);
        }
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

    public void setShippingValue(int shippingValue) {
        this.shippingValue = shippingValue;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
