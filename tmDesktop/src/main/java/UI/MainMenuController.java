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

	public MainMenuController() {

	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void newGameButtonClicked(ActionEvent event) throws Throwable { //the method in fxml, onAction is an event handler
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/NewGame.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void loadGameButtonClicked(ActionEvent event) throws Throwable { //the method in fxml, onAction is an event handler{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/LoadGame.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void manualButtonClicked(ActionEvent event) throws Throwable { //the method in fxml, onAction is an event handler {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/Manual.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void settingsButtonClicked(ActionEvent event) throws Throwable {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/Settings.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void historyButtonClicked(ActionEvent event) throws Throwable{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/History.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void quitButtonClicked(ActionEvent event) throws Throwable {
		//TODO - add quit popup
		System.exit(0);
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) { }

}