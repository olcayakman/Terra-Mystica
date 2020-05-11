package com.TerraMystica.GameLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayer {

    Player player;

    @BeforeEach
    void setup() {
        Faction faction = new Witches();
        player = new Player(faction);
    }

    static Stream<Hexagon> hexagonFactory() {
        return Stream.of(TerrainType.values())
                     .map(Hexagon::new);
    }

    static Stream<Faction> factionFactory() {
        return Stream.of(new Witches());
    }

    @ParameterizedTest
    @MethodSource("factionFactory")
    void testPlayer() {
        assertTrue(player.getResource().getWorker() > 0, "Player should have worker(s) at the beginning.");
        assertTrue(player.getResource().getCoin() > 0, "Player should have coin(s) at the beginning.");
        assertTrue(player.getResource().getPriest() == 0 | player.getResource().getPriest() == 1, "Player should have zero or one priest at the beginning.");
        assertTrue(player.getResource().getPower() == 12, "Player should have exactly 12 powers at the beginning.");
        assertEquals(0, player.getResource().getSpade(), "Player should not have any spades at the beginning.");
    }

    @ParameterizedTest
    @MethodSource("hexagonFactory")
    void testTerraformAndBuild(Hexagon hexagon) {
        int spadesBefore = player.getResource().getSpade();
        player.terraformAndBuild(hexagon);
        int spadesAfter = player.getResource().getSpade();

        assertNotNull(hexagon.getStructure(), "Hexagon should have structure.");
        assertTrue(player.getStructures().contains(hexagon.getStructure()), "Structures of player should contain structure on hexagon.");
        assertTrue(spadesAfter <= spadesBefore, "Spades should decrease after terraforming.");
        assertEquals(hexagon.getTerrainType(), player.getFaction().getTerrainType(), "Terrain type of the hexagon should be same as facton's terrain type." );

        System.out.println("Player has " + player.getStructures().size() + " structure");
    }
}
