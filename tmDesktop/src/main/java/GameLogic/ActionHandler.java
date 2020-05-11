package GameLogic;

public class ActionHandler {

	private Player currentPlayer;
	private static ActionHandler instance = new ActionHandler();

	public static ActionHandler getInstance() {
		return instance;
	}

	/**
	 * 
	 * @param targetTerrainType
	 */
	private boolean canTerraformTerrain(TerrainType targetTerrainType, int x, int y) {
		// Check if the player has enough assets to terraform
		return true;
	}

	/**
	 * 
	 * @param terrain
	 */
	private boolean canBuildStructure(Terrain terrain) {
		// TODO - implement ActionHandler.canBuildStructure
		throw new UnsupportedOperationException();
	}

	/*
	 * @param targetTerrainType
	 * 
	 * @param x
	 * 
	 * @param y
	 */
	private void terraformAndBuild(TerrainType targetTerrainType, int x, int y) {
		// Modify the terraland
		Game.getInstance().modifyTerraland(targetTerrainType, x, y);
		// Perform transaction with the player's asset.
		int spadeCount = currentPlayer.getFaction().getRequiredSpades(targetTerrainType);

		Asset terraformCost = currentPlayer.getFaction().getSpadeCost();
		for (int i = 0; i < spadeCount; i++) {
			currentPlayer.getFaction().getAsset().performTranscation(terraformCost);
		}

		// Check if the terrain is owned
		Game.getInstance().getTerrain(x, y).getOwner();
		// Add the terrain to the controlled terrains list of the player.
		currentPlayer.getControlledTerrains().add(Game.getInstance().getTerrain(x, y));
		// Set the owner attribute of the terrain
		Game.getInstance().getTerrain(x, y).setOwner(currentPlayer);
		// Check the building on the terrain
		buildStructure(Structure.TRADINGPOST, Game.getInstance().getTerrain(x, y));
	}

	private void upgradeShipping() {
		// TODO - implement ActionHandler.upgradeShipping
		throw new UnsupportedOperationException();
	}

	private void upgradeSpades() {
		// TODO - implement ActionHandler.upgradeSpades
		throw new UnsupportedOperationException();
	}

	private void upgradeStructure() {
		// TODO - implement ActionHandler.upgradeStructure
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cultType
	 * @param priestPosition
	 */
	private void sendPriestToCultBoard(String cultType, int priestPosition) {
		// TODO - implement ActionHandler.sendPriestToCultBoard
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	private void powerAction(int id) {
		// TODO - implement ActionHandler.powerAction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	private void specialAction(int id) {
		// TODO - implement ActionHandler.specialAction
		throw new UnsupportedOperationException();
	}

	private void pass() {
		currentPlayer.setPassed(true);
	}

	/**
	 * 
	 * @param structure
	 * @param terrain
	 */
	private void buildStructure(Structure structure, Terrain terrain) {
		terrain.setStructureType(structure);
		System.out.println("The terrain " + terrain.getX() + "," + terrain.getY() + "now has " + terrain.getStructureType());
	}

	private boolean canUpgradeShipping() {
		// TODO - implement ActionHandler.canUpgradeShipping
		throw new UnsupportedOperationException();
	}

	private boolean canUpgradeSpades() {
		// TODO - implement ActionHandler.canUpgradeSpades
		throw new UnsupportedOperationException();
	}

	private boolean canUpgradeStructure() {
		// TODO - implement ActionHandler.canUpgradeStructure
		throw new UnsupportedOperationException();
	}

	private boolean canSendPriestToCultBoard() {
		// TODO - implement ActionHandler.canSendPriestToCultBoard
		throw new UnsupportedOperationException();
	}

	private boolean hasEnoughPower() {
		// TODO - implement ActionHandler.hasEnoughPower
		throw new UnsupportedOperationException();
	}

	private boolean canPerformSpeacialAction() {
		// TODO - implement ActionHandler.canPerformSpeacialAction
		throw new UnsupportedOperationException();
	}

	public boolean[] showPlayAbleActions() {
		// TODO - implement ActionHandler.showPlayAbleActions
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 */
	public void setCurrentPlayer(Player p) {
		this.currentPlayer = p;
		System.out.println("Current Player is " + p.getName());
	}

	/**
	 * 
	 * @param actionID
	 */
	public void executeAction(int actionID) {
		System.out.println("Will execute the action with ID: " + actionID);
		switch (actionID) {
			case 1:
				int terrainTypeIndex = 4;

				// Safety to prevent index out of bounds
				if (terrainTypeIndex > 7) {
					terrainTypeIndex = 7;
				} else if (terrainTypeIndex < 0) {
					terrainTypeIndex = 0;
				}

				TerrainType t = TerrainType.TERRAINS_INDEXED[terrainTypeIndex];
				int x = 0;
				int y = 0;
				terraformAndBuild(t, x, y);
				break;
			case 2:
				pass();
				break;
			case 8: // build structure. will be used in the setup phase where each player places 1/2/3 dwellings.
				break;
		}
	}

}