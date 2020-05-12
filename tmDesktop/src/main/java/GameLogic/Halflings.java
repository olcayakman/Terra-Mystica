package GameLogic;

public class Halflings extends Faction {
    public Halflings() {

        super();

        name = "Halflings";
        homeTerrain = TerrainType.PLAINS;
        spadeLevel = 0;
        System.out.println("Initialized name, home terrain and spade level for halflings");

        for(int i = 0; i < 3; i++){
            spadeCost[i] = new Asset(0,0,3 - i,0);
        }
        System.out.println("Initialized spadeCosts for halflings");

        shippingLevel = 0;
        victoryPointsEarnedWithShippingUpgrade = new int[]{0,2,3,4};
        System.out.println("Initialized victoryPointsEarnedWithShipping for Nomads");

        powerbowl = new int[]{3,9,0};
        System.out.println("Initialized powerbowl for halflings");

        // 15 Coins, 0 Priests, 3 Workers
        asset = new Asset(15,0,3,0);
        System.out.println("Initialized Assets for halflings");

        // COSTS PER BUILDING
        costPerBuilding.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerBuilding.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerBuilding.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerBuilding.put(Structure.STRONGHOLD, new Asset(8,0,4,0));
        costPerBuilding.put(Structure.SANCTUARY, new Asset(6, 0, 4,0));
        System.out.println("Initialized costPerBuilding for halflings");

        //INCOMES PER BUILDING
        incomePerBuilding.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerBuilding.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerBuilding.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerBuilding.put(Structure.STRONGHOLD, new Asset(0,0,0,2));
        incomePerBuilding.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerBuilding for halflings");

        //REQUIRED SPADES FOR TERRAFORMING
        requiredSpades.put(TerrainType.SWAMP, 1);
        requiredSpades.put(TerrainType.LAKES, 2);
        requiredSpades.put(TerrainType.FOREST, 3);
        requiredSpades.put(TerrainType.MOUNTAINS, 3);
        requiredSpades.put(TerrainType.WASTELAND, 2);
        requiredSpades.put(TerrainType.DESERT, 1);

        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(1,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
        System.out.println("Initialized upgrade costs for halflings");
    }
}