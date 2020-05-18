package com.TerraMystica.GameLogic;

public abstract class Structure {
    protected Terrain location;
    protected Player owner;

    public Terrain getLocation() {
        return location;
    }

    public Player getOwner() {
        return owner;
    }

}
