package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class GameplayController  implements Initializable {

	@FXML  public Button backButton;
	@FXML public Button fullScreenButton;

	private Polygon[] trains;
	private Button chooseAction;
	private Button pauseGame;
	private Button cultBoard;
	private Button bonusCards;
	private Button townTiles;
	private Button roundTiles;
	private Pane playerInfo;
	private Label factionName;
	private Label playerName;


	/**
	 * 
	 * @param event
	 */
	public void exitClicked(ActionEvent event) {
		// TODO - implement GameplayController.exitClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void pauseGameClicked(ActionEvent event) {
		// TODO - implement GameplayController.pauseGameClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void townTilesClicked(ActionEvent event) {
		// TODO - implement GameplayController.townTilesClicked
		throw new UnsupportedOperationException();
	}

	public void updatePlayerTurn() {
		// TODO - implement GameplayController.updatePlayerTurn
		throw new UnsupportedOperationException();
	}

	public void updatePlayerLabels() {
		// TODO - implement GameplayController.updatePlayerLabels
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void chooseActionClicked(ActionEvent event) {
		// TODO - implement GameplayController.chooseActionClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void updateFaction(ActionEvent event) {
		// TODO - implement GameplayController.updateFaction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void cultBoardClicked(ActionEvent event) {
		// TODO - implement GameplayController.cultBoardClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void roundTilesClicked(ActionEvent event) {
		// TODO - implement GameplayController.roundTilesClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void bonusCardsClicked(ActionEvent event) {
		// TODO - implement GameplayController.bonusCardsClicked
		throw new UnsupportedOperationException();
	}


	public void handle(KeyEvent t) {
		if(t.getCode()== KeyCode.ESCAPE)
		{
			fullScreenButton.setVisible(true);
		}
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void fullScreenButtonClicked(ActionEvent event) throws Throwable {
		fullScreenButton.setVisible(false);
		GameUI.stage.setFullScreen(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void backButtonClicked(ActionEvent event) throws Throwable {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/MainMenu.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullScreenButton.setVisible(false);
	}

}