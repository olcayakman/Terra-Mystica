package GameLogic;

public class Engineers extends Faction {

    public Engineers(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, int shippingLevel,
            int[] shippingCost, int[] powerbowl, Asset asset) {

        super();
        requiredSpades.put(TerrainType.FOREST, 1);
        requiredSpades.put(TerrainType.LAKES, 2);
        requiredSpades.put(TerrainType.SWAMP, 3);
        requiredSpades.put(TerrainType.PLAINS, 3);
        requiredSpades.put(TerrainType.DESERT, 2);
        requiredSpades.put(TerrainType.WASTELAND, 1);
    }
}