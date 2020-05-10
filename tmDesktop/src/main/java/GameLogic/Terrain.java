package GameLogic;

public class Terrain {

	private int x;
	private int y;
	private TerrainType type;
	private Structure structureType;
	private Player owner;

	public int getX() {
		return this.x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	public TerrainType getType() {
		return this.type;
	}

	/**
	 * 
	 * @param tType
	 */
	public void setType(TerrainType tType) {
		this.type = tType;
	}

	/**
	 * 
	 * @param aPlayer
	 */
	public void setOwner(Player aPlayer) {
		this.owner = aPlayer;
	}

	public Player getOwner() {
		if(owner == null){
			System.out.println("Location " + x + "," + y + " has no owner");
		}
		else{
			System.out.println("Location " + x + "," + y + " is owned by " + owner.getName());
		}
		return this.owner;
		
	}

	/**
	 * 
	 * @param Structure
	 */
	public void setStructureType(Structure sType) {
		this.structureType = sType;
	}

	public Structure getStructureType() {
		return this.structureType;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param type
	 */
	public Terrain(int x, int y, TerrainType type) {
		this.x = x;
		this.y = y;
		this.type = type;
		this.structureType = Structure.EMPTY;
	}

}