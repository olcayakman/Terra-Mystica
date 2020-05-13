package GameLogic;

import java.util.HashMap;

public abstract class Faction {

	/**The variables are declared protected, thus they can be accessed from the subclasses 
	 * and from the classes inside the GameLogic package.
	 * The accessor and mutator methods are/should be provided for the UI, since they will need them for access.
	 * */
	protected String name;
	protected TerrainType homeTerrain;
	protected int spadeLevel;
	protected Asset[] spadeCost;
	protected int[] victoryPointsEarnedWithSpadeUpgrade;
	protected int shippingLevel;
	protected int[] victoryPointsEarnedWithShippingUpgrade;
	protected int[] powerbowl;
	protected HashMap<Structure, Asset> incomePerStructure;
	protected HashMap<Structure, Asset> costPerStructure;
	protected Asset spadeUpgradeCost;
	protected Asset shippingUpgradeCost;
	protected Asset asset;
	protected HashMap<TerrainType, Integer> requiredSpades;
	protected HashMap<Cult, Integer> startingCultBonus;


	public Faction() 
	{
		spadeCost = new Asset[3];
		incomePerStructure = new HashMap<Structure, Asset>();
		costPerStructure = new HashMap<Structure, Asset>();
		requiredSpades = new HashMap<TerrainType, Integer>();
		startingCultBonus = new HashMap<Cult, Integer>();
	}

	public void activateStrongholdAbility(){}

	public int getRequiredSpades(TerrainType target){
		return requiredSpades.get(target);
	}

	public String getName(){
		return this.name;
	}

	public TerrainType getTerrainType(){
		return this.homeTerrain;
	}

	public Asset getSpadeCost(){
		return this.spadeCost[spadeLevel];
	}

	public int getSpadeLevel() {
		return this.spadeLevel;
	}

	public int getShippingLevel() {
		return this.shippingLevel;
	}

	
	public int[] getPowerBowl(){
		return this.powerbowl;
	}

	public Asset getIncomePerStructure(Structure s){
		return this.incomePerStructure.get(s);
	}

	public HashMap<Structure, Asset> getCostPerStructure(){
		return this.costPerStructure;
	}

	public Asset getSpadeUpgradeCost(){
		return this.spadeUpgradeCost;
	}
	public Asset getShippingUpgradeCost(){
		return this.shippingUpgradeCost;
	}

	public int getVictoryPointsEarnedWithSpadeUpgrade(){
		return victoryPointsEarnedWithSpadeUpgrade[spadeLevel];
	}

	public int getVictoryPointsEarnedWithShippingUpgrade(){
		return victoryPointsEarnedWithShippingUpgrade[shippingLevel];
	}

	public Asset getAsset() {
		return this.asset;
	}

	/**
	 * 
	 * @param shippingLevel
	 */
	public void setShippingLevel(int shippingLevel) {
		this.shippingLevel = shippingLevel;
	}

	/**
	 * 
	 * @param spadeLevel
	 */
	public void setSpadeLevel(int spadeLevel) {
		this.spadeLevel = spadeLevel;
	}

	/**
	 * 
	 * @param asset
	 */
	public void setAsset(Asset asset) {
		this.asset = asset;
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
	 * @return starting cult bonus
	 */
	public HashMap<Cult,Integer> getStartingCultBonus(){
		return startingCultBonus;
	}

	/**
	 *
	 * @param startingCultBonus
	 */
	public void setStartingCultBonus( HashMap<Cult,Integer> startingCultBonus){
		this.startingCultBonus = startingCultBonus;
	}

	public void printPowerBowl(){
		for(int i = 0; i < 3; i++){
			System.out.println("Bowl" + (i + 1) + powerbowl[i]);
		}
	}

}