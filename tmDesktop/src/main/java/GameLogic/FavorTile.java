package GameLogic;

public class FavorTile {

	private int id;
	private boolean selected;
	private Asset income;
	private Cult cultBonusType;
	private int cultMove;

/*
	public void performFavorLeft() {
		// TODO - implement FavorTile.performFavorLeft
		throw new UnsupportedOperationException();
	}

	public void performFavorRight() {
		// TODO - implement FavorTile.performFavorRight
		throw new UnsupportedOperationException();
	}
*/
	/**
	 * 
	 * @param id
	 */
	public FavorTile(int id) {

		this.id = id;
		selected = false;

		switch(id) {
			case 0:
				cultBonusType = Cult.FIRE;
				cultMove = 3;
				income = new Asset(0,0,0,0);
				break;
			case 1:
				cultBonusType = Cult.WATER;
				cultMove = 3;
				income = new Asset(0,0,0,0);
				break;
			case 2:
				cultBonusType = Cult.AIR;
				cultMove = 3;
				income = new Asset(0,0,0,0);
				break;
			case 3:
				cultBonusType = Cult.EARTH;
				cultMove = 3;
				income = new Asset(0,0,0,0);
				break;
			case 4:
				cultBonusType = Cult.FIRE;
				cultMove = 2;
				income = new Asset(0,0,0,0);
				//decrase power needed to build a town for that player (done)
				break;
			case 5:
				cultBonusType = Cult.WATER;
				cultMove = 2;
				income = new Asset(0,0,0,0);
				//once per action phase advance on cult board
				break;
			case 6:
				cultBonusType = Cult.AIR;
				cultMove = 2;
				income = new Asset(0,0,0,4);
				break;
			case 7:
				cultBonusType = Cult.EARTH;
				income = new Asset(0,0,1,1);
				break;
			case 8:
				cultBonusType = Cult.FIRE;
				cultMove = 1;
				income = new Asset(3,0,0,0);
				break;
			case 9:
				cultBonusType = Cult.WATER;
				cultMove = 1;
				income = new Asset(0,0,0,0);
				//if upgrade to trading house ---> get 3 victory points
				break;
			case 10:
				cultBonusType = Cult.AIR;
				cultMove = 1;
				income = new Asset(0,0,0,0);
				break;
			case 11:
				cultBonusType = Cult.EARTH;
				cultMove = 1;
				income = new Asset(0,0,0,0);
				// if build dwelling ----> get 2 victory points
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

	public int getCultMove() {
		return cultMove;
	}

	/**
	 *
	 * @param cultMove
	 */
	public void setCultMove(int cultMove) {
		this.cultMove = cultMove;
	}

	/**
	 *
	 * @return cultBonusType
	 */
	public Cult getCultBonusType() {
		return cultBonusType;
	}

	/**
	 *
	 * @param cultBonusType
	 */
	public void setCultBonusType(Cult cultBonusType) {
		this.cultBonusType = cultBonusType;
	}

	/**
	 *
	 * @param selected
	 */
	public void setSelected( boolean selected ){ this.selected = selected; }

	/**
	 *
	 * @return selected
	 */
	public boolean getSelected(){ return  selected; }

	/**
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 *
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}



}

