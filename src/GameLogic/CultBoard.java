package GameLogic;

public class CultBoard {

	private HashMap<String, int[]> priestLocations;

	public CultBoard() {
		// TODO - implement CultBoard.CultBoard
		throw new UnsupportedOperationException();
	}

	public HashMap<String, int[]> getPriestLocations() {
		return this.priestLocations;
	}

	/**
	 * 
	 * @param priestLocations
	 */
	public void setPriestLocations(HashMap<String, int[]> priestLocations) {
		this.priestLocations = priestLocations;
	}

}