package GameLogic;

public class ChaosMagicians extends Faction {
    public ChaosMagicians(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, int shippingLevel,
            int[] shippingCost, int[] powerbowl, Asset asset) {

        super();
        requiredSpades.put(TerrainType.DESERT, 1);
        requiredSpades.put(TerrainType.PLAINS, 2);
        requiredSpades.put(TerrainType.SWAMP, 3);
        requiredSpades.put(TerrainType.LAKES, 3);
        requiredSpades.put(TerrainType.FOREST, 2);
        requiredSpades.put(TerrainType.MOUNTAINS, 1);
    }
}