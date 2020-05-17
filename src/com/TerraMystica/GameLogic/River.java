package com.TerraMystica.GameLogic;

import java.util.HashSet;
import java.util.Set;

public class River extends Hexagon {


    @Override
    public Set<Terrain> getShippingTerrains(int shippingValue) {
        Set<Terrain> result = new HashSet<>();
        if (shippingValue == -1) {
            return result;
        }

        for (var neighbor : GameBoard.getInstance().getNeighborHexagons(this)) {
            result.addAll(neighbor.getShippingTerrains(shippingValue - 1));
        }

        return result;
    }

    @Override
    public TerrainType getTerrainType() {
        return null;
    }

    @Override
    public Dwelling getStructure() {
        return null;
    }

}
