package com.TerraMystica.GameLogic;

import java.util.HashSet;
import java.util.Set;

public class River extends Hexagon {

    @Override
    public Set<Hexagon> getShippingTerrains(GameBoard gameBoard, int shippingValue) {
        Set<Hexagon> result = new HashSet<>();
        if (shippingValue == -1) {
            return result;
        }

        for (var neighbor : gameBoard.getNeighborHexagons(this)) {
            result.addAll(neighbor.getShippingTerrains(gameBoard, shippingValue - 1));
        }

        return result;
    }
}
