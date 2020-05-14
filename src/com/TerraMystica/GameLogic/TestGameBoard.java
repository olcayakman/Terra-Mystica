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
    void testGetAllAdjacentHexagons() {
        var hexagon = new Terrain(TerrainType.PLAINS);
        hexagon.setRow(2);
        hexagon.setCol(3);
        var allAdjacentHexagons = gameBoard.getAllAdjacentHexagons(hexagon);

        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(1, 2)), "Adjacent hexagons should contain the hexagon at [1][2].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(1, 3)), "Adjacent hexagons should contain the hexagon at [1][3].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(2, 2)), "Adjacent hexagons should contain the hexagon at [2][2].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(2, 4)), "Adjacent hexagons should contain the hexagon at [2][4].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(3, 2)), "Adjacent hexagons should contain the hexagon at [3][2].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(3, 3)), "Adjacent hexagons should contain the hexagon at [3][3].");
        assertEquals(6, allAdjacentHexagons.size(), "Total number of adjacent hexagons should be 6.");

        hexagon.setRow(1);
        hexagon.setCol(0);
        allAdjacentHexagons = gameBoard.getAllAdjacentHexagons(hexagon);

        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(0, 0)), "Adjacent hexagons should contain the hexagon at [0][0].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(0, 1)), "Adjacent hexagons should contain the hexagon at [0][1].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(1, 1)), "Adjacent hexagons should contain the hexagon at [1][1].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(2, 0)), "Adjacent hexagons should contain the hexagon at [2][0].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(2, 1)), "Adjacent hexagons should contain the hexagon at [2][1].");
        assertEquals(5, allAdjacentHexagons.size(), "Total number of adjacent hexagons should be 5.");

        hexagon.setRow(0);
        hexagon.setCol(0);
        allAdjacentHexagons = gameBoard.getAllAdjacentHexagons(hexagon);

        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(0, 1)), "Adjacent hexagons should contain the hexagon at [0][1].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(1, 0)), "Adjacent hexagons should contain the hexagon at [1][0].");
        assertEquals(2, allAdjacentHexagons.size(), "Total number of adjacent hexagons should be 2.");

        hexagon.setRow(8);
        hexagon.setCol(12);
        allAdjacentHexagons = gameBoard.getAllAdjacentHexagons(hexagon);

        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(8, 11)), "Adjacent hexagons should contain the hexagon at [8][11].");
        assertTrue(allAdjacentHexagons.contains(gameBoard.getHexagon(7, 11)), "Adjacent hexagons should contain the hexagon at [7][11].");
        assertEquals(2, allAdjacentHexagons.size(), "Total number of adjacent hexagons should be 2.");
    }
}
