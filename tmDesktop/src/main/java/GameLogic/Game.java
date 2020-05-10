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
	private Player currentPlayer;
	private static Game game;

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
	private Game(int numberOfPlayers, Player[] players, Faction[] factions) {
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

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	/**
	 * 
	 * @param currentPlayer
	 */
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public Terrain getTerrain(int x, int y) {
		// TODO - implement Game.getTerrain
		throw new UnsupportedOperationException();
	}

	public static Game getInstance() {
		// TODO - implement Game.getInstance
		throw new UnsupportedOperationException();
	}

}