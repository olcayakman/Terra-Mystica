package GameLogic;

public class Nomads extends Faction {
    public Nomads() {

        super();

        name = "Nomads";
        homeTerrain = TerrainType.DESERT;
        spadeLevel = 0;
        System.out.println("Initialized name, home terrain and spade level for nomads");

        for(int i = 0; i < 3; i++){
            spadeCost[i] = new Asset(0,0,3 - i,0);
        }
        System.out.println("Initialized spadeCosts for nomads");

        shippingLevel = 0;
        victoryPointsEarnedWithShippingUpgrade = new int[]{0,2,3,4};
        System.out.println("Initialized victoryPointsEarnedWithShipping for Nomads");

        powerbowl = new int[]{5,7,0};
        System.out.println("Initialized powerbowl for nomads");

        // 15 Coins, 0 Priests, 2 Workers
        asset = new Asset(15,0,2,0);
        System.out.println("Initialized Assets for nomads");

        // COSTS PER BUILDING FOR NOMADS
        costPerBuilding.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerBuilding.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerBuilding.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerBuilding.put(Structure.STRONGHOLD, new Asset(8,0,4,0));
        costPerBuilding.put(Structure.SANCTUARY, new Asset(6, 0, 4,0));
        System.out.println("Initialized costPerBuilding for nomads");

        //INCOMES PER BUILDING FOR NOMADS
        incomePerBuilding.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerBuilding.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerBuilding.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerBuilding.put(Structure.STRONGHOLD, new Asset(0,0,0,2));
        incomePerBuilding.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerBuilding for nomads");

        //REQUIRED SPADES FOR TERRAFORMING
        requiredSpades.put(TerrainType.PLAINS, 1);
        requiredSpades.put(TerrainType.SWAMP, 2);
        requiredSpades.put(TerrainType.LAKES, 3);
		requiredSpades.put(TerrainType.FOREST, 3);
        requiredSpades.put(TerrainType.MOUNTAINS, 2);
        requiredSpades.put(TerrainType.WASTELAND, 1);

        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(5,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
        System.out.println("Initialized upgrade costs for nomads");
    }
}