package GameLogic;

public class Fakirs extends Faction {

	public Fakirs(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, 
					int shippingLevel, int[] shippingCost, int[] powerbowl, 
					 Asset asset) 
	{
		super(name, homeTerrain, spadeLevel, spadeCost, 
		shippingLevel, shippingCost, powerbowl, 
		 asset);
	}

	public void carpetRide() {
		// TODO - implement Fakirs.carpetRide
		throw new UnsupportedOperationException();
	}

}