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
        costPerStructure.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerStructure.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerStructure.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerStructure.put(Structure.STRONGHOLD, new Asset(6,0,4,0));
        costPerStructure.put(Structure.SANCTUARY, new Asset(6, 0, 4,0));
        System.out.println("Initialized costPerStructure for witches");

        //INCOMES PER Structure FOR WITCHES
        incomePerStructure.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerStructure.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerStructure.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerStructure.put(Structure.STRONGHOLD, new Asset(0,0,0,2));
        incomePerStructure.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerStructure");

        //REQUIRED SPADES FOR TERRAFORMING
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

        //INITIAL POSITION ON CULT BOARD
        startingCultBonus.put(Cult.FIRE, 0);
        startingCultBonus.put(Cult.EARTH, 0);
        startingCultBonus.put(Cult.WATER,0 );
        startingCultBonus.put(Cult.AIR, 2);


    }
}