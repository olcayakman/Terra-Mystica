package GameLogic;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {

	final int NUMBER_OF_BONUS_CARDS = 9;
	final int NUMBER_OF_ROWS = 9;
	final int NUMBER_OF_COLUMNS = 13;
	final int NUMBER_OF_TERRAINS = 117;
	final int NUMBER_OF_TOWNTILES = 10;

	private int currentRound;
	private int currentPhase;
	private Player currentPlayer;
	private ArrayList<Player> players;
	private Terrain[][] terraLand = new Terrain[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
	private ScoringTile[] scoringTiles;
	private FavorTile[] FavorTileDeck;
	private TownTile[] townTileDeck = new TownTile[NUMBER_OF_TOWNTILES];
	private BonusCard[] bonusCardDeck = new BonusCard[NUMBER_OF_BONUS_CARDS];
	private Terrain[] possibleBridgeLocations = new Terrain[1];
	private double avgScore;
	private boolean isFinished;
	private String name;
	private CultBoard cultBoard;
	private static Game instance = new Game();


	private Game() {}

	public static Game getInstance() {
		return instance;
	}

	public void  fillFavorTileDeck(){

		for(int i = 0; i < 12; i++){
			FavorTileDeck[i] = new FavorTile(i);
		}
		//there are 3 of some tiles
		for(int i = 0; i < 8; i++){
			FavorTileDeck[i] = new FavorTile(i + 4);
		}
		for(int i = 0; i < 8; i++){
			FavorTileDeck[i] = new FavorTile(i + 4);
		}

	}

	public void fillTownTileDeck() {
		for(int i = 0; i < 10; i++){
			townTileDeck[i] = new TownTile(i % 5); //there are 2 of each card (ex: 1st & 6st card are the same)
		}
	}

	public int getNumberOfTerrain(){
		return NUMBER_OF_TERRAINS;
	}

	public void shuffleScoringTiles() {
		// TODO - implement Game.shuffleScoringTiles
		throw new UnsupportedOperationException();
	}

	public void fillBonusCardDeck() {
		for(int i = 0; i < NUMBER_OF_BONUS_CARDS; i++){
			bonusCardDeck[i] = new BonusCard(i);
		}	
	}

	public void putChoosingBonus(){
		for(int i = 0; i < NUMBER_OF_BONUS_CARDS; i++){
			if (!bonusCardDeck[i].isSelected()){
				bonusCardDeck[i].getChoosingBonus().performIncrementalTransaction(new Asset(1,0,0,0));
			}
		}
	}

	public boolean allPlayersPassed() {
		for (Player p: players){
			if(p.isPassed()){
				return true;
			}
		}
		return false;
	}

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

	public void setCurrentPhase(int phase){
		this.currentPhase = phase;
	}

	public int getCurrentPhase(){
		return currentPhase;
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

	public BonusCard retrieveBonusCard(int cardIndex){
		return bonusCardDeck[cardIndex];
	}

	public TownTile selectTownTile(int townTileIndex ){
		townTileDeck[townTileIndex].setSelected(true);
		return townTileDeck[townTileIndex];
	}

	public FavorTile selectFavorTile(int favorTileIndex){
		FavorTileDeck[favorTileIndex].setSelected(true);
		return  FavorTileDeck[favorTileIndex];
	}
	public FavorTile[] getFavorTileDeck() {
		return FavorTileDeck;
	}

	public void setFavorTileDeck(FavorTile[] favorTileDeck) {
		FavorTileDeck = favorTileDeck;
	}

}