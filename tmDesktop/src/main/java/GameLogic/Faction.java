package GameLogic;

import java.util.HashMap;

public abstract class Faction {

	protected String name;
	protected TerrainType homeTerrain;
	protected int spadeLevel;
	protected Asset[] spadeCost;
	protected int shippingLevel;
	protected int[] victoryPointsEarnedWithShipping;
	protected int[] powerbowl;
	protected HashMap<Structure, Asset> incomePerBuilding;
	protected HashMap<Structure, Asset> costPerBuilding;
	protected Asset spadeUpgradeCost;
	protected Asset shippingUpgradeCost;
	protected Asset asset;
	protected HashMap<TerrainType, Integer> requiredSpades;

	// TODO: Add remaining parameters
	public Faction() 
	{
		spadeCost = new Asset[3];
		incomePerBuilding = new HashMap<Structure, Asset>();
		costPerBuilding = new HashMap<Structure, Asset>();
		requiredSpades = new HashMap<TerrainType, Integer>();
	}

	public void activateStrongholdAbility(){}

	public int getRequiredSpades(TerrainType target){
		return requiredSpades.get(target);
	}

	public String getName(){
		return this.name;
	}

	public TerrainType getTerrainType(){
		return this.homeTerrain;
	}

	public Asset getSpadeCost(){
		return this.spadeCost[spadeLevel];
	}

	public int getSpadeLevel() {
		return this.spadeLevel;
	}

	public int getShippingLevel() {
		return this.shippingLevel;
	}

	
	public int[] getPowerBowl(){
		return this.powerbowl;
	}

	public HashMap<Structure, Asset> getIncomePerBuilding(){
		return this.incomePerBuilding;
	}

	public HashMap<Structure, Asset> getCostPerBuilding(){
		return this.costPerBuilding;
	}

	public Asset getSpadeUpgradeCost(){
		return this.spadeUpgradeCost;
	}
	public Asset getShippingUpgradeCost(){
		return this.shippingUpgradeCost;
	}

	public Asset getAsset() {
		return this.asset;
	}

	/**
	 * 
	 * @param shippingLevel
	 */
	public void setShippingLevel(int shippingLevel) {
		this.shippingLevel = shippingLevel;
	}

	/**
	 * 
	 * @param spadeLevel
	 */
	public void setSpadeLevel(int spadeLevel) {
		this.spadeLevel = spadeLevel;
	}

	/**
	 * 
	 * @param asset
	 */
	public void setAsset(Asset asset) {
		this.asset = asset;
	}


}