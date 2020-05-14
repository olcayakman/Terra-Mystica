package com.TerraMystica.GameLogic;

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

}
