package GameLogic;

public class Auren extends Faction {

    public Auren(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, int shippingLevel,
            int[] shippingCost, int[] powerbowl, Asset asset) {

        super();
        
        requiredSpades.put(TerrainType.MOUNTAINS, 1);
        requiredSpades.put(TerrainType.WASTELAND, 2);
        requiredSpades.put(TerrainType.DESERT, 3);
        requiredSpades.put(TerrainType.PLAINS, 3);
        requiredSpades.put(TerrainType.SWAMP, 2);
        requiredSpades.put(TerrainType.LAKES, 1);
    }

}