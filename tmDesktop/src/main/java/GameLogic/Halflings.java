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

        // COSTS PER Structure
        costPerStructure.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerStructure.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerStructure.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerStructure.put(Structure.STRONGHOLD, new Asset(8,0,4,0));
        costPerStructure.put(Structure.SANCTUARY, new Asset(6, 0, 4,0));
        System.out.println("Initialized costPerStructure for halflings");

        //INCOMES PER Structure
        incomePerStructure.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerStructure.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerStructure.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerStructure.put(Structure.STRONGHOLD, new Asset(0,0,0,2));
        incomePerStructure.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerStructure for halflings");

        //REQUIRED SPADES FOR TERRAFORMING
        requiredSpades.put(TerrainType.SWAMP, 1);
        requiredSpades.put(TerrainType.LAKES, 2);
        requiredSpades.put(TerrainType.FOREST, 3);
        requiredSpades.put(TerrainType.MOUNTAINS, 3);
        requiredSpades.put(TerrainType.WASTELAND, 2);
        requiredSpades.put(TerrainType.DESERT, 1);
        requiredSpades.put(TerrainType.PLAINS, 0);

        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(1,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
        System.out.println("Initialized upgrade costs for halflings");

        //INITIAL POSITION ON CULT BOARD
        startingCultBonus.put(Cult.FIRE, 0);
        startingCultBonus.put(Cult.EARTH, 1);
        startingCultBonus.put(Cult.WATER,0 );
        startingCultBonus.put(Cult.AIR, 1);
    }
}