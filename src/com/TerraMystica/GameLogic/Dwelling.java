package com.TerraMystica.GameLogic;

public class Dwelling extends Structure {

    public Dwelling(Terrain location) {
        this.location = location;
        location.setStructure(this);
    }

    public Dwelling(Terrain location, Player owner) {
        this.location = location;
        this.owner = owner;
        location.setStructure(this);
    }
}
