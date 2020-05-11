package GameLogic;

public class Asset {
	
	private int coin;
	private int priest;
	private int worker;
	private int power;
	
	/**
	 * 
	 * @param coin
	 * @param priest
	 * @param worker
	 */
	public Asset(int coin, int priest, int worker, int power) {
		this.coin = coin;
		this.priest = priest;
		this.worker = worker;
		this.power = power;
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

	public void performTranscation(Asset a){
		this.coin -= a.getCoin();
		this.priest -= a.getPriest();
		this.worker -= a.getWorker();
	}

	@Override
	public String toString(){
		return "Coins : " + this.coin + " Priests : " + this.priest + " Workers: " + this.worker;
	}
}