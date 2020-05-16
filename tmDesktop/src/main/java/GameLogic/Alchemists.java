package GameLogic;

public class Alchemists extends Faction {
    public Alchemists() {

        super();

        name = "Alchemists"; 
		homeTerrain = TerrainType.SWAMP;
        System.out.println("Initialized name, homeTerrain, spadeLevel for alchemists");
        
        // SHIPPING LEVEL & POINTS EARNED WITH SHIPPING UPGRADE
        shippingLevel = 0;
        victoryPointsEarnedWithSpadeUpgrade = new int[]{0,6,6};
        
        // SPADE LEVEL & POINTS EARNED WITH SHIPPING UPGRADE
        spadeLevel = 0;
        for(int i = 0; i < 3; i++){
            spadeCost[i] = new Asset(0,0,3 - i,0);
        }
        System.out.println("Initialized spadeCosts alchemists");
        victoryPointsEarnedWithShippingUpgrade = new int[]{0,2,3,4};

        // STARTING POWERBOWL STATE
        powerbowl = new int[]{5,7,0};
        System.out.println("Initialized powerbowl alchemists");
        for(int i = 0; i < 3; i++){
            System.out.println("Bowl" + String.valueOf(i+1) + " : " + powerbowl[i]);
        }

        // STARTING INCOME : 15 Coins, 0 Priests, 3 Workers
        asset = new Asset(15,0,3,0);
        System.out.println("Initialized Assets alchemists");

        //COSTS PER STRUCTURE FOR ALCHEMISTS
        costPerStructure.put(Structure.DWELLING, new Asset(2,0,1,0));
        costPerStructure.put(Structure.TRADINGPOST, new Asset(3,0,2,0));
        costPerStructure.put(Structure.TEMPLE, new Asset(5,0,2,0));
        costPerStructure.put(Structure.STRONGHOLD, new Asset(6,0,4,0));
        costPerStructure.put(Structure.SANCTUARY, new Asset(6,0,4,0));

        //INCOMES PER Structure FOR ALCHEMISTS
        incomePerStructure.put(Structure.DWELLING, new Asset(0,0,1,0));
        incomePerStructure.put(Structure.TRADINGPOST, new Asset(2,0,0,1));
        incomePerStructure.put(Structure.TEMPLE, new Asset(0,1,0,0));
        incomePerStructure.put(Structure.STRONGHOLD, new Asset(6,0,0,12));
        incomePerStructure.put(Structure.SANCTUARY, new Asset(0, 1, 0,0));
        System.out.println("Initialized incomePerStructure alchemists");

        //REQUIRED SPADES FOR TERRAFORMING
        requiredSpades.put(TerrainType.LAKES, 1);
        requiredSpades.put(TerrainType.FOREST, 2);
        requiredSpades.put(TerrainType.MOUNTAINS, 3);
        requiredSpades.put(TerrainType.WASTELAND, 3);
        requiredSpades.put(TerrainType.DESERT, 2);
        requiredSpades.put(TerrainType.PLAINS, 1);
        System.out.println("Initialized requiredSpades alchemists");

        //UPGRADE COSTS
        spadeUpgradeCost = new Asset(5,1,2,0);
        shippingUpgradeCost = new Asset(4,1,0,0);

        //INITIAL POSITION ON CULT BOARD
        startingCultBonus.put(Cult.FIRE, 1);
        startingCultBonus.put(Cult.EARTH, 0);
        startingCultBonus.put(Cult.WATER,1 );
        startingCultBonus.put(Cult.AIR, 0);

    }

    @Override
    public void activateStrongholdAbility() {
        super.activateStrongholdAbility();
        this.incrementPower(12);

    }
}