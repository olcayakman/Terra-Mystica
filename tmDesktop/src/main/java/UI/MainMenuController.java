package UI;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

	private Button loadGameButton;
	private Button gameManualButton;
	private Button settingsButton;
	private Button historyButton;

	private Stage quitPopUp;
	private Button yes;
	private Button no;

	Stage stage;
	Scene mainMenuScene;
	URL path;

	@FXML
	Button newGameButton;
	@FXML
	Button quitButton;

	public MainMenuController() {

	}

	/**
	 *
	 */
	@FXML
	private void newGameButtonClicked(ActionEvent event) throws IOException {
		//TODO - create new game
		/*
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/NewGame.fxml")).toURI().toURL());
		Scene newGameScene = new Scene(loader.load());
		*/
	}

	/**
	 *
	 * @param event
	 */
	private void loadGameButtonClicked(MouseEvent event) {
		// TODO - implement MainMenuController.loadGameButtonClicked
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	public void gameManualButtonClicked(MouseEvent event) {
		// TODO - implement MainMenuController.gameManualButtonClicked
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	private void settingsButtonClicked(MouseEvent event) {
		// TODO - implement MainMenuController.settingsButtonClicked
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	private void historyButtonClicked(MouseEvent event) {
		// TODO - implement MainMenuController.historyButtonClicked
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void quitButtonClicked(ActionEvent event) {
		//TODO - add quit popup
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) { }

}