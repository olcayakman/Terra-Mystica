package com.TerraMystica.GameLogic;

public class Dwelling extends Structure{

    public Dwelling(Terrain location) {
        this.location = location;
        location.setStructure(this);
    }

}
