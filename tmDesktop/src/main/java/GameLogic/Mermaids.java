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

        // COSTS PER Structure
        costPerStructure.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerStructure.put(Structure.TRADINGPOST, new Asset(3,0,2,0)); // or 6 coins ????
        costPerStructure.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerStructure.put(Structure.STRONGHOLD, new Asset(6,0,4,0));
        costPerStructure.put(Structure.SANCTUARY, new Asset(8, 0, 4,0));
        System.out.println("Initialized costPerStructure for mermaids");

        //INCOMES PER Structure
        incomePerStructure.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerStructure.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerStructure.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerStructure.put(Structure.STRONGHOLD, new Asset(0,0,0,4));
        incomePerStructure.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerStructure for mermaids");

        //REQUIRED SPADES FOR TERRAFORMING
        requiredSpades.put(TerrainType.FOREST, 1);
        requiredSpades.put(TerrainType.MOUNTAINS, 2);
        requiredSpades.put(TerrainType.WASTELAND, 3);
        requiredSpades.put(TerrainType.DESERT, 3);
        requiredSpades.put(TerrainType.PLAINS, 2);
        requiredSpades.put(TerrainType.SWAMP, 1);
        requiredSpades.put(TerrainType.RIVER, 0);
        requiredSpades.put(TerrainType.LAKES, 0);

        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(5,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);
        System.out.println("Initialized upgrade costs for mermaids");

        //INITIAL POSITION ON CULT BOARD
        startingCultBonus.put(Cult.FIRE, 0);
        startingCultBonus.put(Cult.EARTH, 0);
        startingCultBonus.put(Cult.WATER,2 );
        startingCultBonus.put(Cult.AIR, 0);
    }

    @Override
    public void activateStrongholdAbility() {
        super.activateStrongholdAbility();
        shippingLevel++;
    }
}