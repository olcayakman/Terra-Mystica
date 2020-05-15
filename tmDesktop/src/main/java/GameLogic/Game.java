package GameLogic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Collections;

public class Game {

	private int currentRound;
	private int currentPhase;
	private int numberOfPlayers;
	private ArrayList<Player> players;
	private Terrain[][] terraLand = new Terrain[9][13];
	private ScoringTile[] scoringTiles;
	private FavorTile[] allFavorTiles;
	private TownTile[] allTownTiles;
	private BonusCard[] allBonusCards;
	private ArrayList<Integer> usedPowerActions;
	private Terrain[] possibleBridgeLocations = new Terrain[1];
	private double avgScore;
	private boolean isFinished;
	private String name;
	private Player currentPlayer;
	private CultBoard cultBoard;
	private static Game instance = new Game();

	/**
	 * 
	 * @param numberOfPlayers
	 * @param players
	 * @param factions
	 */
	private Game() {}

	public static Game getInstance() {
		return instance;
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
		for (Player p: players){
			if(p.isPassed()){
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param terraLand
	 */
	public void modifyTerraland(TerrainType terrainType, int x, int y) {
		if(terraLand[x][y] == null){
			terraLand[x][y] = new Terrain(x, y, terrainType);
		}
		else{
			System.out.println("Terrain type of location " + x + "," + y + 
				" was :" + terraLand[x][y].getType());
			terraLand[x][y].setType(terrainType);
			System.out.println("Terrain type of location " + x + "," + y + 
				" is modified to :" + terraLand[x][y].getType());
		}
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
		return terraLand[x][y];
	}

	public Terrain[][] getTerraLand(){
		return terraLand;
	}

	public void setPlayers(ArrayList<Player> players){
		this.players = players;
	}

	public void setNumberOfPlayers(int numberOfPlayers){
		this.numberOfPlayers = numberOfPlayers;
	}

	/**
	 *
	 * @return cultBoard
	 */
	public CultBoard getCultBoard() { return cultBoard; }

	/**
	 *
	 * @param cultBoard
	 */
	public void setCultBoard(CultBoard cultBoard) { this.cultBoard = cultBoard; }
}