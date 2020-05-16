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

	public void setNoOfStructures() {
		// TODO - implement Player.setNoOfStructures
		throw new UnsupportedOperationException();
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