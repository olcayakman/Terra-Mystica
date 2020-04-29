package GameLogic;

public class History {

	private Game game;
	private Date date;
	private static int gamesPlayed;
	private static int gamesFinished;

	public Game getGame() {
		return this.game;
	}

	/**
	 * 
	 * @param aGame
	 */
	public void setGame(Game aGame) {
		this.game = aGame;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param aDate
	 */
	public void setDate(Date aDate) {
		this.date = aDate;
	}

	public static int getGamesPlayed() {
		return this.gamesPlayed;
	}

	/**
	 * 
	 * @param aGamesPlayed
	 */
	public static void setGamesPlayed(int aGamesPlayed) {
		this.gamesPlayed = aGamesPlayed;
	}

	public static int getGamesFinished() {
		return this.gamesFinished;
	}

	/**
	 * 
	 * @param aGamesFinished
	 */
	public static void setGamesFinished(int aGamesFinished) {
		this.gamesFinished = aGamesFinished;
	}

	/**
	 * 
	 * @param aGame
	 * @param aDate
	 */
	public History(Game aGame, Date aDate) {
		// TODO - implement History.History
		throw new UnsupportedOperationException();
	}

}