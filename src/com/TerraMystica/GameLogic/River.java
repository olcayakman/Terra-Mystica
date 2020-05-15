package com.TerraMystica.GameLogic;

import java.util.HashSet;
import java.util.Set;

public class River extends Hexagon {

    @Override
    public Set<Hexagon> getShippingTerrains(int shippingValue) {
        Set<Hexagon> result = new HashSet<>();
        if (shippingValue == -1) {
            return result;
        }

        for (var neighbor : GameBoard.getInstance().getNeighborHexagons(this)) {
            result.addAll(neighbor.getShippingTerrains(shippingValue - 1));
        }

        return result;
    }
}
