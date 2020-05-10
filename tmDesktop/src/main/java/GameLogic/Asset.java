package GameLogic;

public class Asset {

	private int coin;
	private int priest;
	private int worker;

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

	/**
	 * 
	 * @param coin
	 * @param priest
	 * @param worker
	 */
	public Asset(int coin, int priest, int worker) {
		// TODO - implement Asset.Asset
		throw new UnsupportedOperationException();
	}

}