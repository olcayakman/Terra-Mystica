package GameLogic;

public class Cultists extends Faction {

    public Cultists(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, int shippingLevel,
            int[] shippingCost, int[] powerbowl, Asset asset) {

        super();
        requiredSpades.put(TerrainType.SWAMP, 1);
        requiredSpades.put(TerrainType.LAKES, 2);
        requiredSpades.put(TerrainType.FOREST, 3);
        requiredSpades.put(TerrainType.MOUNTAINS, 3);
        requiredSpades.put(TerrainType.WASTELAND, 2);
        requiredSpades.put(TerrainType.DESERT, 1);
    }
}