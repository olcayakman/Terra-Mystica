package GameLogic;

public class ActionHandler {

	private Player currentPlayer;
	private static ActionHandler actionHandler;

	/**
	 * 
	 * @param targetTerrainType
	 * @param x
	 * @param y
	 */
	private void terraformAndBuild(TerrainType targetTerrainType, int x, int y) {
		// TODO - implement ActionHandler.terraformAndBuild
		throw new UnsupportedOperationException();
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
		// TODO - implement ActionHandler.pass
		throw new UnsupportedOperationException();
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

	private ActionHandler() {
		// TODO - implement ActionHandler.ActionHandler
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param p
	 */
	public void setCurrentPlayer(Player p) {
		this.currentPlayer = p;
	}

	/**
	 * 
	 * @param actionID
	 */
	public void executeAction(int actionID) {
		// TODO - implement ActionHandler.executeAction
		throw new UnsupportedOperationException();
	}

	public static ActionHandler getInstance() {
		// TODO - implement ActionHandler.getInstance
		throw new UnsupportedOperationException();
	}

}