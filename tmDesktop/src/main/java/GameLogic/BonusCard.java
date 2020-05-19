package GameLogic;

public class BonusCard {

	private int id;
	private boolean selected;
	private Asset income;
	private Asset choosingBonus;

	/**
	 * 
	 * @param id
	 */
	public BonusCard(int id) {
		this.id = id;
		selected = false;
		switch (id) {
			case 0:
				income = new Asset(0,1,0,0);
				break;
			case 1:
				income = new Asset(0,0,3,1);
				break;
			case 2:
				income = new Asset(6,0,0,0);
				break;
			case 3:
				income = new Asset(0,0,0,3);
				break;
			case 4:
				income = new Asset(2,0,0,0);
				break;
			case 5:
				income = new Asset(4,0,0,0);
				break;
			case 6:
				income = new Asset(2,0,0,0);
				break;
			case 7:
				income = new Asset(0,0,1,0);
				break;
			case 8:
				income = new Asset(0,0,2,0);
				break;
		}
		choosingBonus = new Asset(0,0,0,0);
	}

	public Asset getIncome() {
		return this.income;
	}

	/**
	 * 
	 * @param income
	 */
	public void setAsset(Asset income) {
		this.income = income;
	}

	public void setSelected(boolean selected){
		this.selected = selected;
	}

	public boolean isSelected(){
		return this.selected;
	}

	public int getId(){
		return this.id;
	}

	public Asset getChoosingBonus(){
		return this.choosingBonus;
	}
}