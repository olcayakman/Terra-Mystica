package GameLogic;


public class ActionHandler {

	private Player currentPlayer;
	private static ActionHandler instance = new ActionHandler();

	/* These variables will be passed as arguments to the actions.*/
	private int terrainXPosition;
	private int terrainYPosition;
	private int terrainTypeIndex;
	/* The controller will set the values of these variables with its setter methods. */
	
	public static ActionHandler getInstance() {
		return instance;
	}

	public int getTerrainXPosition(){
		return this.terrainXPosition;
	}

	public void setTerrainXPosition(int x){
		terrainXPosition = x;
	}

	public int getTerrainYPosition(){
		return this.terrainYPosition;
	}

	public void setTerrainYPosition(int y){
		terrainYPosition = y;
	}

	public int getTerrainTypeIndex(){
		return terrainTypeIndex;
	}

	public void setTerrainTypeIndex(int index){
		terrainTypeIndex = index;
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

	/** 
	 * 
	 * Case 1
	 * @param targetTerrainType
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
		System.out.println("Cost of the terraform :" + spadeCount + " x " + terraformCost);
		System.out.println("Player now has : " + currentPlayer.getFaction().asset);
		// Check if the terrain is owned. Will be used in canTerraformAndBuild
		Game.getInstance().getTerrain(x, y).getOwner();
		// Add the terrain to the controlled terrains list of the player.
		currentPlayer.getControlledTerrains().add(Game.getInstance().getTerrain(x, y));
		// Set the owner attribute of the terrain
		Game.getInstance().getTerrain(x, y).setOwner(currentPlayer);
		// Check the building on the terrain
		buildStructure(Structure.TRADINGPOST, Game.getInstance().getTerrain(x, y));
	}

	private void upgradeShipping() {
		Asset shippingUpgradeCost = currentPlayer.getFaction().spadeUpgradeCost;
		System.out.println("Cost of the shipping upgrade: " + shippingUpgradeCost);
		currentPlayer.getFaction().asset.performTranscation(shippingUpgradeCost);
		System.out.println("Player now has : " + currentPlayer.getFaction().asset);
		currentPlayer.getFaction().shippingLevel++;
		System.out.println("Current shipping level : " + currentPlayer.getFaction().shippingLevel);
	}

	private void upgradeSpades() {
		// Spade level for a faction is a protected value, thus it can be reached inside any class in the same package.
		Asset spadeUpgradeCost = currentPlayer.getFaction().getSpadeUpgradeCost();
		System.out.println("Cost of the spade upgrade: " + spadeUpgradeCost);
		currentPlayer.getFaction().getAsset().performTranscation(spadeUpgradeCost);
		System.out.println("Player now has : " + currentPlayer.getFaction().asset);
		currentPlayer.getFaction().spadeLevel++;
		System.out.println("Spade Level : " + currentPlayer.getFaction().spadeLevel);
	}

	private void upgradeStructure(int x, int y) {
		Structure structureOnTerrain = Game.getInstance().getTerrain(x,y).getStructureType();
		if (structureOnTerrain == Structure.DWELLING){
			// Get the upgrade cost for trading post depending on the adjacency
			// Make the transaction
			// Do the transaction
			// Update incomePerBuilding for the currentPlayer
			System.out.println("TODO: Implement upgradeStructure");
		}
		// Do the same for the other buildings.
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
		System.out.println(currentPlayer.getName() + " passed");
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
			case 1: // Terraform and build
				setTerrainTypeIndex(4);
				TerrainType t = TerrainType.TERRAINS_INDEXED[terrainTypeIndex];
				setTerrainXPosition(0);
				setTerrainYPosition(0);

				terraformAndBuild(t, terrainXPosition, terrainYPosition);
				break;
			case 2: // Upgrade Structure
				upgradeStructure(terrainXPosition, terrainYPosition);
				break;
			case 3: // Upgrade spade level
				upgradeSpades();
				break;
			case 4: // Upgrade shipping level
				upgradeShipping();
				break;
			case 7:
				pass();
				break;
			case 8: // build structure. will be used in the setup phase where each player places 1/2/3 dwellings.
				break;
		}
	}

}