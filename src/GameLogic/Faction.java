package GameLogic;

import java.util.Map;

public abstract class Faction {

	private String name;
	private String homeTerrain;
	private int spade_level;
	private int[] spade_cost;
	private int shipping_level;
	private int[] shipping_cost;
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

	public int getSpade_level() {
		return this.spade_level;
	}

	/**
	 * 
	 * @param spade_level
	 */
	public void setSpade_level(int spade_level) {
		this.spade_level = spade_level;
	}

	public int getShipping_level() {
		return this.shipping_level;
	}

	/**
	 * 
	 * @param shipping_level
	 */
	public void setShipping_level(int shipping_level) {
		this.shipping_level = shipping_level;
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