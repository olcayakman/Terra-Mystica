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
	 * @param x
	 * @param y
	 */
	private void terraformAndBuild(TerrainType targetTerrainType, int x, int y) {
		// Calculate the cost
		int terraformCost = 1 * currentPlayer.getFaction().getSpadeCost();
		// Modify the terraland
		Game.getInstance().modifyTerraland(targetTerrainType, x, y);
		// Perform transaction with the player's asset.
		currentPlayer.getFaction().getAsset().setCoin(-1 * terraformCost);
		// Check if the terrain is owned
		Game.getInstance().getTerrain(x, y).getOwner();
		// Add the terrain to the controlled terrains list of the player.
		currentPlayer.getControlledTerrains().add(Game.getInstance().getTerrain(x, y));
		// Set the owner attribute of the terrain
		Game.getInstance().getTerrain(x, y).setOwner(currentPlayer);
		//Get the owner of the terrain
		Game.getInstance().getTerrain(x, y).getOwner();
		// Check the building on the terrain
		System.out.println("The structure has " + Game.getInstance().getTerrain(x, y).getStructureType());
		Game.getInstance().getTerrain(x, y).setStructureType(Structure.TRADINGPOST);
		System.out.println("The structure now has " + Game.getInstance().getTerrain(x, y).getStructureType());

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
	 * @param targetTerrainType
	 */
	private boolean canTerraformTerrain(String targetTerrainType) {
		// TODO - implement ActionHandler.canTerraformTerrain
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param terrain
	 */
	private boolean canBuildStructure(Terrain terrain) {
		// TODO - implement ActionHandler.canBuildStructure
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param structure
	 */
	private void buildStructure(Structure structure) {
		// TODO - implement ActionHandler.buildStructure
		throw new UnsupportedOperationException();
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
				for (int i = 0; i < 7; i++) {
					System.out.print(TerrainType.TERRAINS_INDEXED[i] + ",");
				}
				System.out.println();

				System.out.println("Enter the index of the terrain that you want");
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
		}
	}

}