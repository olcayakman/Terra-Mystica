package GameLogic;

import java.util.Map;

public abstract class Faction {

	private String name;
	private TerrainType homeTerrain;
	private int spadeLevel;
	private int[] spadeCost;
	private int shippingLevel;
	private int[] shippingCost;
	private int[] powerbowl;
	private Map<Structure, Asset> incomePerBuilding;
	private Map<Structure, Asset> costPerBuilding;
	private Asset spadeUpgradeCost;
	private Asset shippingUpgradeCost;
	private Asset asset;

	public Faction() {
		// TODO - implement Faction.Faction
		throw new UnsupportedOperationException();
	}

	public void activateStrongholdAbility() {
		// TODO - implement Faction.activateStrongholdAbility
		throw new UnsupportedOperationException();
	}

	public int getPriest() {
		// TODO - implement Faction.getPriest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param priest
	 */
	public void setPriest(int priest) {
		// TODO - implement Faction.setPriest
		throw new UnsupportedOperationException();
	}

	public int getCoin() {
		// TODO - implement Faction.getCoin
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param coin
	 */
	public void setCoin(int coin) {
		// TODO - implement Faction.setCoin
		throw new UnsupportedOperationException();
	}

	public int getWorker() {
		// TODO - implement Faction.getWorker
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param worker
	 */
	public void setWorker(int worker) {
		// TODO - implement Faction.setWorker
		throw new UnsupportedOperationException();
	}

	public int getSpadeLevel() {
		return this.spadeLevel;
	}

	/**
	 * 
	 * @param spadeLevel
	 */
	public void setSpadeLevel(int spadeLevel) {
		this.spadeLevel = spadeLevel;
	}

	public int getShippingLevel() {
		return this.shippingLevel;
	}

	/**
	 * 
	 * @param shippingLevel
	 */
	public void setShippingLevel(int shippingLevel) {
		this.shippingLevel = shippingLevel;
	}

	public Asset getAsset() {
		return this.asset;
	}

	/**
	 * 
	 * @param asset
	 */
	public void setAsset(Asset asset) {
		this.asset = asset;
	}

}