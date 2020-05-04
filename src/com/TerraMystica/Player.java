package com.TerraMystica;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Resource resource;
    private Faction faction;
    private List<Structure> structures;

    public Player(Faction faction) {
        this.faction = faction;
        this.resource = faction.initializeResources();
        this.structures = new ArrayList();
    }

    public void terraformAndBuild(Hexagon hexagon) {
        int cost = faction.getCost(hexagon);
        resource.spendSpades(cost);
        var dwelling = new Dwelling(hexagon);
        addStructure(dwelling);
    }

    private void addStructure(Dwelling dwelling) {
        structures.add(dwelling);
    }

    public List<Structure> getStructures() {
        return structures;
    }

    public Resource getResource() {
        return resource;
    }

    public Faction getFaction() {
        return faction;
    }
}
