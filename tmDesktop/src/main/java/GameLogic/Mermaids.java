package GameLogic;

public class Mermaids extends Faction {
    public Mermaids() {

        super();

        name = "Mermaids";
        homeTerrain = TerrainType.LAKES;
        spadeLevel = 0;
        System.out.println("Initialized name, home terrain and spade level for mermaids");

        for(int i = 0; i < 3; i++){
            spadeCost[i] = new Asset(0,0,3 - i,0);
        }
        System.out.println("Initialized spadeCosts for mermaids");

        shippingLevel = 0;
        victoryPointsEarnedWithShippingUpgrade = new int[]{0,2,3,4,5}; //mermaids have five levels of shipping
        System.out.println("Initialized victoryPointsEarnedWithShipping for mermaids");

        powerbowl = new int[]{3,9,0};
        System.out.println("Initialized powerbowl for mermaids");

        // 15 Coins, 0 Priests, 3 Workers
        asset = new Asset(15,0,3,0);
        System.out.println("Initialized Assets for mermaids");

        // COSTS PER BUILDING
        costPerBuilding.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerBuilding.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerBuilding.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerBuilding.put(Structure.STRONGHOLD, new Asset(6,0,4,0));
        costPerBuilding.put(Structure.SANCTUARY, new Asset(8, 0, 4,0));
        System.out.println("Initialized costPerBuilding for mermaids");

        //INCOMES PER BUILDING
        incomePerBuilding.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerBuilding.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerBuilding.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerBuilding.put(Structure.STRONGHOLD, new Asset(0,0,0,4));
        incomePerBuilding.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerBuilding for mermaids");

        //REQUIRED SPADES FOR TERRAFORMING
        requiredSpades.put(TerrainType.FOREST, 1);
        requiredSpades.put(TerrainType.MOUNTAINS, 2);
        requiredSpades.put(TerrainType.WASTELAND, 3);
        requiredSpades.put(TerrainType.DESERT, 3);
        requiredSpades.put(TerrainType.PLAINS, 2);
        requiredSpades.put(TerrainType.SWAMP, 1);

        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(5,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
        System.out.println("Initialized upgrade costs for mermaids");
    }
}