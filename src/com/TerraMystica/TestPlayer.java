package com.TerraMystica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @ParameterizedTest
    @MethodSource("hexagonFactory")
    void testTerraformAndBuild(Hexagon hexagon) {
        int spadesBefore = player.getResource().getSpade();
        player.terraformAndBuild(hexagon);
        int spadesAfter = player.getResource().getSpade();

        assertNotNull(hexagon.getStructure(), "Hexagon should have structure.");
        assertTrue(player.getStructures().contains(hexagon.getStructure()), "Structures of player should contain structure on hexagon.");
        assertEquals(spadesAfter, spadesBefore - player.getFaction().getCost(hexagon), "Spades should decrease by the cost of terraforming.");

        System.out.println("Player has " + player.getStructures().size() + " structure");
    }
}
