package GameLogic;

import java.util.ArrayList;
import java.util.LinkedList;

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
	private Terrain[] possibleBridgeLocations;
	private double avgScore;
	private boolean isFinished;
	private String name;

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

	public boolean allPlayersPassed() {
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

	public double getAvgScore() {
		return this.avgScore;
	}

	/**
	 * 
	 * @param players
	 */
	public void calculateAvgScore(LinkedList<Player> players) {
		// TODO - implement Game.calculateAvgScore
		throw new UnsupportedOperationException();
	}

	public boolean getIsFinished() {
		return this.isFinished;
	}

	/**
	 * 
	 * @param isFinished
	 */
	public void setIsFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}