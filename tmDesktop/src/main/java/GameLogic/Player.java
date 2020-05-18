package GameLogic;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {

	private Faction faction;
	private int victoryPoints;
	private HashMap<Cult, Integer> positionOnCultBoard;
	private ArrayList<FavorTile> favorTiles;
	private ArrayList<TownTile> townTiles;
	private ArrayList<Terrain> townCenters;
	private int remainingBridges;
	private String name;
	private int id;
	private boolean passed;
	private HashMap<Structure, Integer> numberOfStructures;
	private ArrayList<Terrain> controlledTerrains;
	private ArrayList<Boolean> townKeyUsed;
	private int powerRequiredToFoundTown;
	private Asset incomeFromBonusCard;
	private BonusCard chosenBonusCard;
	private boolean[] earnedVictoryPointBonus;
	private Asset incomeFromTiles;

	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		passed = false;
		victoryPoints = 0;
		positionOnCultBoard = new HashMap<Cult, Integer>();

		favorTiles = new ArrayList<FavorTile>();

		townTiles = new ArrayList<TownTile>();

		remainingBridges = 4; // Double check

		// Initialize the number of structures as 0 for each type
		numberOfStructures = new HashMap<>();
		for (int i = 0; i < Structure.NUMBER_OF_STRUCTURE_TYPES; i++) {
			numberOfStructures.put(Structure.STRUCTURES_INDEXED[i], 0);
		}
		controlledTerrains = new ArrayList<Terrain>();
		townKeyUsed = new ArrayList<Boolean>();
		townCenters = new ArrayList<Terrain>();

		powerRequiredToFoundTown = 7;
		earnedVictoryPointBonus = new boolean[4];

	}

	public void chooseBonusCard(int bonusCardId) {
		chosenBonusCard = Game.getInstance().retrieveBonusCard(bonusCardId);
		chosenBonusCard.setSelected(true);
		incomeFromBonusCard = chosenBonusCard.getIncome();
		// Will be decremented when the player returns the bonus card.
		if (bonusCardId == 3) {
			faction.shippingLevel++;
		}

	}

	public void chooseFavorTile(int id){
		FavorTile choosenTile = Game.getInstance().selectFavorTile(id);
		favorTiles.add(choosenTile);
		// additional income gained for income phase
		incomeFromTiles.performIncrementalTransaction( choosenTile.getIncome() );

	}

	public void chooseTownTile(int id){
		//add town tile to the deck
		TownTile choosentile = Game.getInstance().selectTownTile(id);
		townTiles.add( choosentile ) ;

		//Increment asset
		this.faction.getAsset().performIncrementalTransaction(choosentile.getIncome());
		
		// Add a new key to town keys 
		townKeyUsed.add(false);

		//Increment victory points according to tile 
		switch(id) {
			case 0:
				this.incrementVictoryPoints(9);
				break;
			case 1:
				this.incrementVictoryPoints(8);				
				break;
			case 2:
				this.incrementVictoryPoints(7);
				break;
			case 3:
				this.incrementVictoryPoints(6);
				break;
			case 4:
				this.incrementVictoryPoints(5);
				break;
		}
	}

	public int getVictoryPoints() {
		return this.victoryPoints;
	}

	public boolean isPassed() {
		return this.passed;
	}

	public void setPassed(boolean pass) {
		this.passed = pass;
	}

	/**
	 * 
	 * @param point
	 */
	public void setVictoryPoints(int point) {
		this.victoryPoints = point;
	}

	public int getRemainingBridge() {
		return this.remainingBridges;
	}

	public void setRemainingBridge() {
	}

	public String getName() {
		return this.name;
	}

	public Faction getFaction() {
		return this.faction;
	}

	/**
	 * 
	 * @param faction
	 */
	public void setFaction(Faction faction) {
		this.faction = faction;
	}

	/**
	 * 
	 * @param positionOnCultBoard
	 */
	public void setPositionOnCultBoard(HashMap<Cult, Integer> positionOnCultBoard) {
		this.positionOnCultBoard = positionOnCultBoard;
	}

	public HashMap<Cult, Integer> getPositionOnCultBoard() {
		return positionOnCultBoard;
	}

	public ArrayList<Terrain> getControlledTerrains() {
		return this.controlledTerrains;
	}

	/**
	 * 
	 * @param controlledTerrains
	 */
	public void setControlledTerrains(ArrayList<Terrain> controlledTerrains) {
		this.controlledTerrains = controlledTerrains;
	}

	public void incrementVictoryPoints(int point) {
		victoryPoints += point;
		earnVictoryPointBonus();
	}

	public void earnVictoryPointBonus(){
		Asset vpBonus;
		// Player earns 3 Coins and a Worker after surpassing 30 Victory Points
		if(!earnedVictoryPointBonus[0] && victoryPoints >= 30){
			vpBonus = new Asset(2,0,1,0);
			faction.asset.performIncrementalTransaction(vpBonus);
			earnedVictoryPointBonus[0] = true;
		}
		// Player earns 1 Priest and 2 Power after surpassing 60 Victory Points
		else if(!earnedVictoryPointBonus[1] && victoryPoints >= 60){
			vpBonus = new Asset(0,1,0,2);
			faction.asset.performIncrementalTransaction(vpBonus);
			faction.incrementPower(vpBonus.getPower());
			earnedVictoryPointBonus[1] = true;
		}
		// Player earns 3 Coins, 1 Priest, 2 Workers and 1 Power
		else if(!earnedVictoryPointBonus[2] && victoryPoints >= 90){
			vpBonus = new Asset(3,1,2,1);
			faction.asset.performIncrementalTransaction(vpBonus);
			faction.incrementPower(vpBonus.getPower());
			earnedVictoryPointBonus[2] = true;
		}
		// Player earns 7 Coins, 3 Priests, 4 Workers and 4 Power
		else if(!earnedVictoryPointBonus[3] && victoryPoints >= 120){
			vpBonus = new Asset(7,3,4,4);
			faction.asset.performIncrementalTransaction(vpBonus);
			faction.incrementPower(vpBonus.getPower());
			earnedVictoryPointBonus[3] = true;
		}
	}

	public int getNumberOfStructures(Structure s) {
		return numberOfStructures.get(s);
	}

	public void updateNumberOfStructures(Structure s, int value) {
		numberOfStructures.put(s, numberOfStructures.get(s) + value);
	}

	public ArrayList<Boolean> getTownKeyUsed() {
		return this.townKeyUsed;
	}

	public void setTownKeyUsed(ArrayList<Boolean> townKeyUsed) {
		this.townKeyUsed = townKeyUsed;
	}

	public void printPositionOnCultBoard() {
		for (int i = 0; i < 4; i++) {
			System.out.println(Cult.CULTS_INDEXED + " : " + positionOnCultBoard.get(Cult.CULTS_INDEXED[i]));
		}
	}

	public void setPowerRequiredToFoundTown(int number) {
		this.powerRequiredToFoundTown = number;
	}

	public int getRequiredPowerToFoundTown() {
		return this.powerRequiredToFoundTown;
	}

	public ArrayList<Terrain> getTownCenters() {
		return this.townCenters;
	}

	public void returnBonusCard() {
		int chosenCardId = chosenBonusCard.getId();
		Game.getInstance().retrieveBonusCard(chosenCardId).setSelected(false);
		switch (chosenCardId) {
			case 3:
				faction.shippingLevel--;
				break;
			case 6:
				incrementVictoryPoints(numberOfStructures.get(Structure.DWELLING));
				break;
			case 7:
				incrementVictoryPoints(numberOfStructures.get(Structure.TRADINGPOST));
				break;
			case 8:
				if (numberOfStructures.get(Structure.STRONGHOLD) == 1) {
					incrementVictoryPoints(4);
				}
				if (numberOfStructures.get(Structure.SANCTUARY) == 1) {
					incrementVictoryPoints(4);
				}
				break;
		}
	}
}