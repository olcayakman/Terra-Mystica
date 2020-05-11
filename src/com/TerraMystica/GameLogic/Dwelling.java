package com.TerraMystica.GameLogic;

public class Dwelling extends Structure{

    public Dwelling(Hexagon location) {
        this.location = location;
        location.setStructure(this);
    }

}
