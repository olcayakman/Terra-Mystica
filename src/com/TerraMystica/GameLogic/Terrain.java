package com.TerraMystica.GameLogic;

import java.util.HashSet;
import java.util.Set;

public class Terrain extends Hexagon {
    Dwelling structure;
    TerrainType terrainType;

    public Terrain(TerrainType terrainType) {
        this.terrainType = terrainType;
    }

    public Dwelling getStructure() {
        return structure;
    }
    public TerrainType getTerrainType() {
        return terrainType;
    }

    public void setStructure(Dwelling structure) {
        this.structure = structure;
    }
    public void setTerrainType(TerrainType terrainType) {
        this.terrainType = terrainType;
    }


    @Override
    public Set<Hexagon> getShippingTerrains(int shippingValue) {
        Set<Hexagon> result = new HashSet<>();
        result.add(this);
        return result;
    }
}
