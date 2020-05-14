package com.TerraMystica.GameLogic;

public class Main {

    public static void main(String[] args) {
        var faction = new Witches();
        var player = new Player(faction);
        var terrainType = TerrainType.DESERT;
        var hexagon = new Terrain(terrainType);
        player.terraformAndBuild(hexagon);

        if(hexagon.getStructure() != null) {
            System.out.println("Hexagon has a structure");
        }

        System.out.println("Player has " + player.getStructures().size() + " structure");
        System.out.println(player.getStructures().get(0));
        System.out.println(player.getStructures().get(0) == hexagon.getStructure());
        System.out.println("Number of spades: " + player.getResource().getSpade());
    }
}
