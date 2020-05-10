package GameLogic;

public class Engineers extends Faction {

    public Engineers(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, int shippingLevel,
            int[] shippingCost, int[] powerbowl, Asset asset) {

        super(name, homeTerrain, spadeLevel, spadeCost, shippingLevel, shippingCost, powerbowl, asset);

    }
}