package GameLogic;

import java.util.HashMap;

public abstract class Faction {

	private String name;
	private TerrainType homeTerrain;
	private int spadeLevel;
	private int[] spadeCost;
	private int shippingLevel;
	private int[] shippingCost;
	private int[] powerbowl;
	private HashMap<Structure, Asset> incomePerBuilding;
	private HashMap<Structure, Asset> costPerBuilding;
	private Asset spadeUpgradeCost;
	private Asset shippingUpgradeCost;
	private Asset asset;

	// TODO: Add remaining parameters
	public Faction(String name, TerrainType homeTerrain, int spadeLevel, int[] spadeCost, 
					int shippingLevel, int[] shippingCost, int[] powerbowl, 
					 Asset asset) 
	{
		this.name = name; 
		this.homeTerrain = homeTerrain;
		this.spadeLevel = spadeLevel;
		this.spadeCost = spadeCost;
		this.shippingLevel = shippingLevel;
		this.shippingCost = shippingCost;
		this.powerbowl = powerbowl;
		this.asset = asset;
	}

	public void activateStrongholdAbility(){}

	public String getName(){
		return this.name;
	}

	public TerrainType getTerrainType(){
		return this.homeTerrain;
	}

	public int getSpadeCost(){
		return this.spadeCost[spadeLevel];
	}

	public int getSpadeLevel() {
		return this.spadeLevel;
	}

	public int getShippingLevel() {
		return this.shippingLevel;
	}

	public int getShippingCost(){
		return this.shippingCost[shippingLevel];
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