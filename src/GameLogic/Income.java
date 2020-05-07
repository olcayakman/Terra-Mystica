package GameLogic;

import java.util.HashMap;

public class Income {

	private int priest;
	private HashMap<String, int[]> cultBonus;
	private int worker;
	private int coin;
	private int power;

	public int getPriest() {
		return this.priest;
	}

	/**
	 * 
	 * @param priest
	 */
	public void setPriest(int priest) {
		this.priest = priest;
	}

	public HashMap<String, int[]> getCultBonus() {
		return this.cultBonus;
	}

	/**
	 * 
	 * @param cultBonus
	 */
	public void setCultBonus(HashMap<String, int[]> cultBonus) {
		this.cultBonus = cultBonus;
	}

	public int getWorker() {
		return this.worker;
	}

	/**
	 * 
	 * @param worker
	 */
	public void setWorker(int worker) {
		this.worker = worker;
	}

	public int getCoin() {
		return this.coin;
	}

	/**
	 * 
	 * @param coin
	 */
	public void setCoin(int coin) {
		this.coin = coin;
	}

	public void getPower() {
		// TODO - implement Income.getPower
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param power
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * 
	 * @param priest
	 * @param cultBonus
	 * @param worker
	 * @param coin
	 * @param power
	 */
	public Income(int priest, HashMap<String, int[]> cultBonus, int worker, int coin, int power) {
		// TODO - implement Income.Income
		throw new UnsupportedOperationException();
	}

}