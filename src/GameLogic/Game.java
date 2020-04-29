package GameLogic;

public class Game {

	private int currentRound;
	private int currentPhase;
	private int numberOfPlayers;
	private LinkedList<Player> players;
	private Terrain[][] terraLand;
	private ScoringTile[] scoringTiles;
	private FavorTile[] allFavorTiles;
	private TownTile[] allTownTiles;
	private BonusCard[] allBonusCards;
	private ArrayList<Integer> usedPowerActions;
	private int possibleBridgeLocations;

	public void executeSetupPhase() {
		// TODO - implement Game.executeSetupPhase
		throw new UnsupportedOperationException();
	}

	public void executeIncomePhase() {
		// TODO - implement Game.executeIncomePhase
		throw new UnsupportedOperationException();
	}

	public void executeActionPhase() {
		// TODO - implement Game.executeActionPhase
		throw new UnsupportedOperationException();
	}

	public void executeCleanupPhase() {
		// TODO - implement Game.executeCleanupPhase
		throw new UnsupportedOperationException();
	}

	public void shuffleScoringTiles() {
		// TODO - implement Game.shuffleScoringTiles
		throw new UnsupportedOperationException();
	}

	public void adjustBonusCards() {
		// TODO - implement Game.adjustBonusCards
		throw new UnsupportedOperationException();
	}

	public bool allPlayersPassed() {
		// TODO - implement Game.allPlayersPassed
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param terraLand
	 */
	public void modifyTerraland(Terrain[][] terraLand) {
		// TODO - implement Game.modifyTerraland
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param numberOfPlayers
	 * @param players
	 * @param factions
	 */
	public Game(int numberOfPlayers, Player[] players, Faction[] factions) {
		// TODO - implement Game.Game
		throw new UnsupportedOperationException();
	}

}