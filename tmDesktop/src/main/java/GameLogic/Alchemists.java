package GameLogic;

public class Alchemists extends Faction {
    public Alchemists() {

        super();

        name = "Alchemists"; 
		homeTerrain = TerrainType.SWAMP;
        spadeLevel = 0;
        System.out.println("Initialized name, homeTerrain, spadeLevel");

		for(int i = 0; i < 3; i++){
            spadeCost[i] = new Asset(0,0,3 - i,0);
        }
        System.out.println("Initialized spadeCosts");

        shippingLevel = 0;
        victoryPointsEarnedWithShipping = new int[]{0,2,3,4};
        System.out.println("Initialized victoryPointsEarnedWithShipping");
        powerbowl = new int[]{5,7,0};
        System.out.println("Initialized powerbowl");
        for(int i = 0; i < 3; i++){
            System.out.println("Bowl" + String.valueOf(i+1) + " : " + powerbowl[i]);
        }
        // 15 Coins, 0 Priests, 3 Workers
        asset = new Asset(15,0,3,0);
        System.out.println("Initialized Assets");

        incomePerBuilding.put(Structure.DWELLING, new Asset(1,0,0,0));
        incomePerBuilding.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerBuilding.put(Structure.TEMPLE, new Asset(0,1,0,0));
        // Building strongholds give bonuses that last throught the game. 
        // This can be handled in the upgradeStructure method of the ActionHandler 
        incomePerBuilding.put(Structure.STRONGHOLD, new Asset(6,0,0,12));
        // Will give TownTiles * 1 priest. Can be handled in the ActionHandler
        incomePerBuilding.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerBuilding");

        requiredSpades.put(TerrainType.LAKES, 1);
        requiredSpades.put(TerrainType.FOREST, 2);
        requiredSpades.put(TerrainType.MOUNTAINS, 3);
        requiredSpades.put(TerrainType.WASTELAND, 3);
        requiredSpades.put(TerrainType.DESERT, 2);
        requiredSpades.put(TerrainType.PLAINS, 1);
        System.out.println("Initialized requiredSpades");

        spadeUpgradeCost = new Asset(5,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
    }
}