package com.TerraMystica;

public class Hexagon {

    TerrainType terrainType;
    Dwelling structure;

    public Hexagon(TerrainType terrainType) {
        this.terrainType = terrainType;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public void setStructure(Dwelling structure) {
        this.structure = structure;
    }

    public Dwelling getStructure() {
        return structure;
    }
}
