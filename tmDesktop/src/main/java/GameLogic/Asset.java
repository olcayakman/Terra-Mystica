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

	/**
	 * @return power
	 */
	public int getPower(){
		return power;
	}

	public void performDecrementalTransaction(Asset a){
		this.coin -= a.getCoin();
		this.priest -= a.getPriest();
		this.worker -= a.getWorker();
	}

	public void performIncrementalTransaction(Asset a){
		this.coin += a.getCoin();
		this.priest += a.getPriest();
		this.worker += a.getWorker();
	}

	public boolean canPerformDecrementalTransaction(Asset a){
		if (this.coin >= a.coin && this.priest >= a.priest && this.worker >= a.worker){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 *
	 * @param power
	 */
	public void incrementPower(int power){
		for(int i = 0; i < power; i++){
			if(powerbowl[0] != 0){
				powerbowl[0]--;
				powerbowl[1]++;
			}
			else if( powerbowl[1] != 0){
				powerbowl[1]--;
				powerbowl[2]++;
			}
		}
	}

	/**
	 *
	 * @param power
	 */
	public void spendPower( int power ){
		for(int i = 0; i < power; i++){
			if(powerbowl[2] != 0){
				powerbowl[2]--;
					powerbowl[0]++;
			}
			else if( powerbowl[1] >= 2 ) {
				powerbowl[1] -= 2;
				powerbowl[0]++;
			}
		}
	}

	/**
	 *
	 * @param power
	 * @return canSpendPower
	 */
	public boolean canSpendPower( int power ){
		if ( powerbowl[2] >= power){ 
			return true; 
		} //has enough power in bowl 3
		else if ( (powerbowl[1] * 2) >= (power - powerbowl[2]) ) { 
			return true;
		} // can sacrifice power in bowl 2
		else{ 
			return false; 
		}
	}

	@Override
	public String toString(){
		return  this.coin + "Coins, " + this.priest + " Priests, " + this.worker + " Workers.";
	}
}