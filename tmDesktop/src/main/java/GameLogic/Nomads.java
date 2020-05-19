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

        // COSTS PER Structure FOR NOMADS
        costPerStructure.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerStructure.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerStructure.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerStructure.put(Structure.STRONGHOLD, new Asset(8,0,4,0));
        costPerStructure.put(Structure.SANCTUARY, new Asset(6, 0, 4,0));
        System.out.println("Initialized costPerStructure for nomads");

        //INCOMES PER Structure FOR NOMADS
        incomePerStructure.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerStructure.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerStructure.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerStructure.put(Structure.STRONGHOLD, new Asset(0,0,0,2));
        incomePerStructure.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerStructure for nomads");

        //REQUIRED SPADES FOR TERRAFORMING
        requiredSpades.put(TerrainType.PLAINS, 1);
        requiredSpades.put(TerrainType.SWAMP, 2);
        requiredSpades.put(TerrainType.LAKES, 3);
		requiredSpades.put(TerrainType.FOREST, 3);
        requiredSpades.put(TerrainType.MOUNTAINS, 2);
        requiredSpades.put(TerrainType.WASTELAND, 1);
        requiredSpades.put(TerrainType.DESERT, 0);

        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(5,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
        System.out.println("Initialized upgrade costs for nomads");

        //INITIAL POSITION ON CULT BOARD
        startingCultBonus.put(Cult.FIRE, 1);
        startingCultBonus.put(Cult.EARTH, 1);
        startingCultBonus.put(Cult.WATER,0 );
        startingCultBonus.put(Cult.AIR, 0);
    }
}