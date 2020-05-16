package GameLogic;

import java.util.HashMap;

public class CultBoard {

	private HashMap<Cult, int[]> priestLocations;

	public CultBoard() {

		priestLocations = new HashMap<Cult, int[]>();
		int[] noPriests = {0,0,0,0};
		// Set all priest locations empty
		priestLocations.put(Cult.AIR, noPriests);
		priestLocations.put(Cult.EARTH, noPriests);
		priestLocations.put(Cult.WATER, noPriests);
		priestLocations.put(Cult.FIRE, noPriests);

	}

	public HashMap<Cult, int[]> getPriestLocations() {
		return this.priestLocations;
	}

	/**
	 * 
	 * @param priestLocations
	 */
	public void setPriestLocations(HashMap<Cult, int[]> priestLocations) {
		this.priestLocations = priestLocations;
	}

	public boolean hasEmptyPriestLocation( Cult cultType ){

		for(int i = 0; i < 4; i++){
			if(priestLocations.get(cultType)[i] == 0){
				return true;
			}
		}

		return false;
	}

}