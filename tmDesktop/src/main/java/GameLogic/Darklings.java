package GameLogic;

public class Darklings extends Faction {

    public Darklings(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, int shippingLevel,
            int[] shippingCost, int[] powerbowl, Asset asset) {

        super();

        requiredSpades.put(TerrainType.LAKES, 1);
        requiredSpades.put(TerrainType.FOREST, 2);
        requiredSpades.put(TerrainType.MOUNTAINS, 3);
        requiredSpades.put(TerrainType.WASTELAND, 3);
        requiredSpades.put(TerrainType.DESERT, 2);
        requiredSpades.put(TerrainType.PLAINS, 1);
    }
}