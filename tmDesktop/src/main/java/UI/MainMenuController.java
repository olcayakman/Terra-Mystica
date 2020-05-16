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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

	public static Stage quitPopUpStage;

	@FXML public Button fullScreenButton;
	@FXML private Button quitYesButton;
	@FXML private Button quitNoButton;

	public MainMenuController() { }


	@FXML
	private void newGameButtonClicked(ActionEvent event) throws Throwable { //the method in fxml, onAction is an event handler
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/NewGame.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}


	@FXML
	private void loadGameButtonClicked(ActionEvent event) throws Throwable { //the method in fxml, onAction is an event handler{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/LoadGame.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}


	@FXML
	private void manualButtonClicked(ActionEvent event) throws Throwable { //the method in fxml, onAction is an event handler {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/Manual.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}


	@FXML
	private void settingsButtonClicked(ActionEvent event) throws Throwable {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/Settings.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}


	@FXML
	private void historyButtonClicked(ActionEvent event) throws Throwable{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/History.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
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


	@FXML
	private void quitButtonClicked(ActionEvent event) throws Throwable {
		//TODO - add quit popup

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/QuitPopUp.fxml")).toURI().toURL());
		Scene quitPopUpScene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		quitPopUpStage = new Stage();
		quitPopUpStage.setScene(quitPopUpScene);
		quitPopUpStage.initStyle(StageStyle.UNDECORATED);
		quitPopUpStage.initOwner(primaryStage);
		quitPopUpStage.initModality(Modality.APPLICATION_MODAL);
		quitPopUpStage.showAndWait();

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullScreenButton.setVisible(false);
	}

}