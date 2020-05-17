package com.TerraMystica.GameLogic;

import java.util.HashSet;
import java.util.Set;

public class Terrain extends Hexagon {
    Dwelling structure;
    TerrainType terrainType;

    public Terrain(TerrainType terrainType) {
        this.terrainType = terrainType;
    }

    @Override
    public Set<Terrain> getShippingTerrains(int shippingValue) {
        Set<Terrain> result = new HashSet<>();
        result.add(this);
        return result;
    }

    public boolean hasStructure() {
        return structure != null;
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
}
