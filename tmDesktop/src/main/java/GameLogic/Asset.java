package GameLogic;

public class Asset {
	
	private int coin;
	private int priest;
	private int worker;
	
	/**
	 * 
	 * @param coin
	 * @param priest
	 * @param worker
	 */
	public Asset(int coin, int priest, int worker) {
		this.coin = coin;
		this.priest = priest;
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
		this.coin += 1 * coin;
	}

	public int getPriest() {
		return this.priest;
	}

	/**
	 * 
	 * @param priest
	 */
	public void setPriest(int priest) {
		this.priest += 1 * priest;
	}

	public int getWorker() {
		return this.worker;
	}

	/**
	 * 
	 * @param worker
	 */
	public void setWorker(int worker) {
		this.worker += 1 * worker;
	}


}