package GameLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GameHandler {

	private Game game;
	private int numberOfPlayers;
	private ArrayList<Faction> factions;
	private ArrayList<Player> players;
	private ActionHandler actionHandler = ActionHandler.getInstance();

	public GameHandler() {
		factions = new ArrayList<Faction>();
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
		this.factions = factions;
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
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 13; j++) {
				game.modifyTerraland(TerrainType.TERRAINS_INDEXED[j % 7], i, j);
			}
		}
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
	}

	public void executeIncomePhase() {
		// for(int i = 0; i < numberOf)
	}

	public void executeActionPhase() {

		actionHandler.setCurrentPlayer(players.get(0));

		int actionID = 1;
		actionHandler.executeAction(actionID);

	}

	public void executeCleanupPhase() {
		// TODO - implement GameHandler.executeCleanupPhase
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return "";
	}
}