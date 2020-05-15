package com.TerraMystica.GameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestGameBoard {
    GameBoard gameBoard;

    @BeforeEach
    void setup() {
        gameBoard = new GameBoard();
    }

    @Test
    void testGetNeighborHexagons() {
        var hexagon = gameBoard.getHexagon(2, 3);
        var neighborHexagons = gameBoard.getNeighborHexagons(hexagon);

        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(1, 2)), "Neighbor hexagons should contain the hexagon at [1][2].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(1, 3)), "Neighbor hexagons should contain the hexagon at [1][3].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(2, 2)), "Neighbor hexagons should contain the hexagon at [2][2].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(2, 4)), "Neighbor hexagons should contain the hexagon at [2][4].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(3, 2)), "Neighbor hexagons should contain the hexagon at [3][2].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(3, 3)), "Neighbor hexagons should contain the hexagon at [3][3].");
        assertEquals(6, neighborHexagons.size(), "Total number of Neighbor hexagons should be 6.");

        hexagon = gameBoard.getHexagon(1, 0);
        neighborHexagons = gameBoard.getNeighborHexagons(hexagon);

        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(0, 0)), "Neighbor hexagons should contain the hexagon at [0][0].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(0, 1)), "Neighbor hexagons should contain the hexagon at [0][1].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(1, 1)), "Neighbor hexagons should contain the hexagon at [1][1].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(2, 0)), "Neighbor hexagons should contain the hexagon at [2][0].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(2, 1)), "Neighbor hexagons should contain the hexagon at [2][1].");
        assertEquals(5, neighborHexagons.size(), "Total number of Neighbor hexagons should be 5.");

        hexagon = gameBoard.getHexagon(0, 0);
        neighborHexagons = gameBoard.getNeighborHexagons(hexagon);

        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(0, 1)), "Neighbor hexagons should contain the hexagon at [0][1].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(1, 0)), "Neighbor hexagons should contain the hexagon at [1][0].");
        assertEquals(2, neighborHexagons.size(), "Total number of Neighbor hexagons should be 2.");

        hexagon = gameBoard.getHexagon(8, 12);
        neighborHexagons = gameBoard.getNeighborHexagons(hexagon);

        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(8, 11)), "Neighbor hexagons should contain the hexagon at [8][11].");
        assertTrue(neighborHexagons.contains(gameBoard.getHexagon(7, 11)), "Neighbor hexagons should contain the hexagon at [7][11].");
        assertEquals(2, neighborHexagons.size(), "Total number of Neighbor hexagons should be 2.");
    }

    @Test
    void testGetAllAdjacentHexagons() {
        var hexagon = gameBoard.getHexagon(2, 4);

        var allAdjacentTerrains = gameBoard.getAllAdjacentTerrains(hexagon, 0);
        assertEquals(2, allAdjacentTerrains.size(),
                "2 adjacent terrains should be found for the hexagon at [" + hexagon.getRow() + "][" + hexagon.getCol() + "]");

        allAdjacentTerrains = gameBoard.getAllAdjacentTerrains(hexagon, 1);

        assertFalse(allAdjacentTerrains.contains(hexagon), "Adjacent terrains should not contain the original hexagon.");
        assertFalse(allAdjacentTerrains instanceof River, "There should not be River in the list of adjacent hexagons.");
        assertEquals(9, allAdjacentTerrains.size(), "9 adjacent terrains should be found for the hexagon at [" + hexagon.getRow() + "][" + hexagon.getCol() + "]");

        allAdjacentTerrains = gameBoard.getAllAdjacentTerrains(hexagon, 2);

        assertFalse(allAdjacentTerrains.contains(hexagon), "Adjacent terrains should not contain the original hexagon.");
        assertFalse(allAdjacentTerrains instanceof River, "There should not be River in the list of adjacent hexagons.");
        assertEquals(13, allAdjacentTerrains.size(), "13 adjacent terrains should be found for the hexagon at [" + hexagon.getRow() + "][" + hexagon.getCol() + "]");

        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(0, 2)), "Adjacent terrains should contain the terrains at [0][2]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(0, 3)), "Adjacent terrains should contain the terrains at [0][3]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(0, 5)), "Adjacent terrains should contain the terrains at [0][5]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(0, 6)), "Adjacent terrains should contain the terrains at [0][6]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(1, 3)), "Adjacent terrains should contain the terrains at [1][3]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(1, 4)), "Adjacent terrains should contain the terrains at [1][4]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(2, 2)), "Adjacent terrains should contain the terrains at [2][2]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(3, 2)), "Adjacent terrains should contain the terrains at [3][2]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(3, 5)), "Adjacent terrains should contain the terrains at [3][5]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(4, 3)), "Adjacent terrains should contain the terrains at [4][3]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(4, 4)), "Adjacent terrains should contain the terrains at [4][4]");
        assertTrue(allAdjacentTerrains.contains(gameBoard.getHexagon(4, 5)), "Adjacent terrains should contain the terrains at [4][5]");

        allAdjacentTerrains = gameBoard.getAllAdjacentTerrains(hexagon, 3);

        assertFalse(allAdjacentTerrains.contains(hexagon), "Adjacent terrains should not contain the original hexagon.");
        assertFalse(allAdjacentTerrains instanceof River, "There should not be River in the list of adjacent hexagons.");
        assertEquals(17, allAdjacentTerrains.size(), "17 adjacent terrains should be found for the hexagon at [" + hexagon.getRow() + "][" + hexagon.getCol() + "]");

    }
}
