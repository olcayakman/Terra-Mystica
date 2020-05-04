package com.TerraMystica.GameLogic;

public class Dwelling extends Structure{

    public Dwelling(Hexagon hexagon) {
        this.location = hexagon;
        hexagon.setStructure(this);
    }
}
