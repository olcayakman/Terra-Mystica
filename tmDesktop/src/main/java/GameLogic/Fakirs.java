package GameLogic;

public class Fakirs extends Faction {

	public Fakirs(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, int shippingLevel,
			int[] shippingCost, int[] powerbowl, Asset asset) {
		super();
		
        requiredSpades.put(TerrainType.PLAINS, 1);
        requiredSpades.put(TerrainType.SWAMP, 2);
        requiredSpades.put(TerrainType.LAKES, 3);
		requiredSpades.put(TerrainType.FOREST, 3);
        requiredSpades.put(TerrainType.MOUNTAINS, 2);
        requiredSpades.put(TerrainType.WASTELAND, 1);
	}

	public void carpetRide() {
		// TODO - implement Fakirs.carpetRide
		throw new UnsupportedOperationException();
	}

}