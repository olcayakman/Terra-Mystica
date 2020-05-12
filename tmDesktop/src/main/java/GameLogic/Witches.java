package GameLogic;

public class Witches extends Faction {
    public Witches() {

        super();

        name = "Witches";
        homeTerrain = TerrainType.FOREST;
        spadeLevel = 0;
        System.out.println("Initialized name, home terrain and spade level for witches");

        for(int i = 0; i < 3; i++){
            spadeCost[i] = new Asset(0,0,3 - i,0);
        }
        System.out.println("Initialized spadeCosts for witches");

        shippingLevel = 0;
        victoryPointsEarnedWithSpadeUpgrade = new int[]{0,6,6};
        victoryPointsEarnedWithShippingUpgrade = new int[]{0,2,3,4};
        System.out.println("Initialized victoryPointsEarnedWithShipping for witches");

        powerbowl = new int[]{5,7,0};
        System.out.println("Initialized powerbowl for witches");

        // 15 Coins, 0 Priests, 3 Workers
        asset = new Asset(15,0,3,0);
        System.out.println("Initialized Assets for witches");

        // COSTS PER BUILDING FOR WITCHES
        costPerBuilding.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerBuilding.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerBuilding.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerBuilding.put(Structure.STRONGHOLD, new Asset(6,0,4,0));
        costPerBuilding.put(Structure.SANCTUARY, new Asset(6, 1, 4,0));
        System.out.println("Initialized costPerBuilding for witches");

        //INCOMES PER BUILDING FOR WITCHES
        incomePerBuilding.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerBuilding.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerBuilding.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerBuilding.put(Structure.STRONGHOLD, new Asset(0,0,0,2));
        incomePerBuilding.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerBuilding");

        //REQUIRED SPADES FOR TERRAINS
        requiredSpades.put(TerrainType.MOUNTAINS, 1);
        requiredSpades.put(TerrainType.WASTELAND, 2);
        requiredSpades.put(TerrainType.DESERT, 3);
        requiredSpades.put(TerrainType.PLAINS, 3);
        requiredSpades.put(TerrainType.SWAMP, 2);
        requiredSpades.put(TerrainType.LAKES, 1);
        System.out.println("Initialized requiredSpades for witches");


        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(5,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
        System.out.println("Initialized upgrade costs for witches");
    }
}