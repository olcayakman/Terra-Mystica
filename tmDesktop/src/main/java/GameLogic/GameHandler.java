package GameLogic;

import java.util.ArrayList;

public class GameHandler {

	private Game game;
	private int numberOfPlayers;
	private ArrayList<Player> players;
	private ActionHandler actionHandler = ActionHandler.getInstance();

	public GameHandler() {
		players = new ArrayList<>();
		game = Game.getInstance();
	}

	/**
	 * 
	 * @param numberOfPlayers
	 * @param players
	 * @param factions
	 */
	public void createGame(int numberOfPlayers, ArrayList<Player> players, ArrayList<Faction> factions) {
		this.numberOfPlayers = numberOfPlayers;
		this.players = players;
		System.out.println("Stored the references of the parameters");

		game.setPlayers(players);
		game.setNumberOfPlayers(numberOfPlayers);
		System.out.println("Initiliazed the players of the game and the number of players");

		// Set the factions for each player
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.printf("Initialized the factions for each player");
			players.get(i).setFaction(factions.get(i));
			System.out.println(
					"Player: " + players.get(i).getName() + " controls " + players.get(i).getFaction().getName());
		}

		// Initialize TerraLand
		initializeTerraLand();

	}

	public void pauseGame() {
		// TODO - implement GameHandler.pauseGame
		throw new UnsupportedOperationException();
	}

	public void continueGame() {
		// TODO - implement GameHandler.continueGame
		throw new UnsupportedOperationException();
	}

	public void endGame() {
		// TODO - implement GameHandler.endGame
		throw new UnsupportedOperationException();
	}

	public Player[] calculateScores() {
		// TODO - implement GameHandler.calculateScores
		throw new UnsupportedOperationException();
	}

	public Player declareWinner() {
		// TODO - implement GameHandler.declareWinner
		throw new UnsupportedOperationException();
	}

	public void executeSetupPhase() {
		// Each player will build 2 dwellings on their home terrains
		for (int i = 0; i < numberOfPlayers; i++) {
			actionHandler.setCurrentPlayer(players.get(i));
			actionHandler.executeAction(8);
		}
	}
	
	public void executeIncomePhase() {
		// for(int i = 0; i < numberOf)
	}
	
	public void executeActionPhase() {
		
		actionHandler.setCurrentPlayer(players.get(0));
		for(int i = 1; i < 5; i++){
			actionHandler.executeAction(i);
		}
		actionHandler.executeAction(7);

	}

	public void executeCleanupPhase() {
		// TODO - implement GameHandler.executeCleanupPhase
		throw new UnsupportedOperationException();
	}

	// Initializes the terrains for the TerraLand
	public void initializeTerraLand(){
		// ti = terrainIndex
		for(int ti = 0; ti < 117; ti++){ 
			if(ti == 0 || ti == 6 || ti == 16 || ti == 50 || ti == 53 || ti == 57 || ti == 74 || ti == 76 || ti == 93 || ti == 101 || ti == 111){
				game.modifyTerraland(TerrainType.PLAINS, ti / 13, ti % 13);
			}
			else if(ti == 1 || ti == 30 || ti == 36 || ti == 58 || ti == 65 || ti == 75 || ti == 81 || ti == 100 || ti == 102 || ti == 106 || ti == 112){
				game.modifyTerraland(TerrainType.MOUNTAINS, ti / 13, ti % 13);
			}
			else if(ti == 2 || ti == 9 || ti == 32 || ti == 34 || ti == 39 || ti == 62 || ti == 66 || ti == 70 || ti == 85 || ti == 109 || ti == 115){
				game.modifyTerraland(TerrainType.FOREST, ti / 13, ti % 13);
			}
			else if(ti == 3 || ti == 10 || ti == 40 || ti == 45 || ti == 55 || ti == 65 || ti == 89 || ti == 92 || ti == 97 || ti == 107 || ti == 114 ){
				game.modifyTerraland(TerrainType.LAKES, ti / 13, ti % 13);
			}
			else if(ti == 4 || ti == 13 || ti == 20 || ti == 24 || ti == 41 || ti == 59 || ti == 69 || ti == 87 || ti == 90 || ti == 91 || ti == 110){
				game.modifyTerraland(TerrainType.DESERT, ti / 13, ti % 13); 
			}
			else if(ti == 5 || ti == 8 || ti == 11 || ti == 44 || ti == 47 || ti == 49 || ti == 54 || ti == 83 || ti == 104 || ti == 108 || ti == 116){
				game.modifyTerraland(TerrainType.WASTELAND, ti / 13, ti % 13);
			}
			else if(ti == 7 || ti == 12 || ti == 17 || ti == 21 || ti == 28 || ti == 52 || ti == 56 || ti == 63 || ti == 88 || ti == 98 || ti == 105){
				game.modifyTerraland(TerrainType.SWAMP, ti / 13, ti % 13);
			}
			else{
				game.modifyTerraland(TerrainType.RIVER, ti / 13, ti % 13);
			}
		}
	}

	@Override
	public String toString() {
		return "";
	}
}