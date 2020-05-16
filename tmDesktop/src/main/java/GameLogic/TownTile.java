package GameLogic;

public class TownTile {

	private int id;
	private boolean selected;
	private Asset income;

	/**
	 * 
	 * @param id
	 */
	public TownTile(int id) {
		this.id = id;
		selected = false;

		switch(id) {
			case 0:
				income = new Asset(0,1,0,0);
				break;
			case 1:
				income = new Asset(0,0,0,0);
				break;
			case 2:
				income = new Asset(0,0,2,0);
				break;
			case 3:
				income = new Asset(0,0,0,8);
				break;
			case 4:
				income = new Asset(6,0,0,0);
				break;
		
		}

	}

	public Asset getIncome() {
		return this.income;
	}

	/**
	 * 
	 * @param income
	 */
	public void setIncome(Asset income) {
		this.income = income;
	}

	public void setSelected( boolean selected ){
		this.selected = selected;
	}

	public boolean getSelected(){
		return selected;
	}

}