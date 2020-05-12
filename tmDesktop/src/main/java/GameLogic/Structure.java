package GameLogic;

public enum Structure {
	DWELLING,
	TRADINGPOST,
	TEMPLE,
	SANCTUARY,
	STRONGHOLD,
	EMPTY;

	public static Structure[] STRUCTURES_INDEXED = 
	new Structure[] {DWELLING,TRADINGPOST,TEMPLE,SANCTUARY,STRONGHOLD};

	public static final int NUMBER_OF_STRUCTURE_TYPES = 5;
}