package GameLogic;

public class Giants extends Faction {
    public Giants() {

        super();

        name = "Giants";
        homeTerrain = TerrainType.WASTELAND;
        spadeLevel = 0;
        System.out.println("Initialized name, home terrain and spade level for giants");

        for(int i = 0; i < 3; i++){
            spadeCost[i] = new Asset(0,0,3 - i,0);
        }
        System.out.println("Initialized spadeCosts for giants");

        shippingLevel = 0;
        victoryPointsEarnedWithShippingUpgrade = new int[]{0,2,3,4};
        System.out.println("Initialized victoryPointsEarnedWithShipping for giants");

        powerbowl = new int[]{5,7,0};
        System.out.println("Initialized powerbowl for giants");

        // 15 Coins, 0 Priests, 2 Workers
        asset = new Asset(15,0,2,0);
        System.out.println("Initialized Assets for giants");

        // COSTS PER BUILDING
        costPerBuilding.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerBuilding.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerBuilding.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerBuilding.put(Structure.STRONGHOLD, new Asset(6,0,4,0));
        costPerBuilding.put(Structure.SANCTUARY, new Asset(6, 0, 4,0));
        System.out.println("Initialized costPerBuilding for giants");

        //INCOMES PER BUILDING
        incomePerBuilding.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerBuilding.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerBuilding.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerBuilding.put(Structure.STRONGHOLD, new Asset(0,0,0,4));
        incomePerBuilding.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerBuilding for giants");

        //REQUIRED SPADES FOR TERRAFORMING
        requiredSpades.put(TerrainType.DESERT, 2);
        requiredSpades.put(TerrainType.PLAINS, 2);
        requiredSpades.put(TerrainType.SWAMP, 2);
        requiredSpades.put(TerrainType.LAKES, 2);
        requiredSpades.put(TerrainType.FOREST, 2);
        requiredSpades.put(TerrainType.MOUNTAINS, 2);

        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(5,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
        System.out.println("Initialized upgrade costs for giants");
    }
}