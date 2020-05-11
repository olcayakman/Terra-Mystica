package UI;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

	@FXML public Button fullScreenButton;
	@FXML public VBox factionChooseBox;
	@FXML public HBox playerNumberBox;
	@FXML public ChoiceBox<String> choiceBox0;
	@FXML public ChoiceBox<String> choiceBox1;
	@FXML public ChoiceBox<String> choiceBox2;
	@FXML public ChoiceBox<String> choiceBox3;
	@FXML public ChoiceBox<String> choiceBox4;
	@FXML public ChoiceBox<String> choiceBox5;
	@FXML public HBox factionBox3;
	@FXML public HBox factionBox4;
	@FXML public HBox factionBox5;

	public NewGameController(){

	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	private void startGameClicked(ActionEvent event) throws Throwable {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/Gameplay.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}


	/**
	 * 
	 * @param event
	 */
	@FXML
	public void confirmPlayerNoClicked(ActionEvent event) throws Throwable {
		playerNumberBox.setVisible(false);
		factionChooseBox.setVisible(true);
	}


	/**
	 * 
	 * @param event
	 */
	@FXML
	public void changePlayerNoClicked(ActionEvent event) throws Throwable {
		playerNumberBox.setVisible(true);
		factionChooseBox.setVisible(false);
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
			factionChooseBox.setVisible(false);
			choiceBox0.setItems(FXCollections.observableArrayList("2", "3", "4", "5"));
			choiceBox1.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox2.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox3.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox4.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox5.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
	}
}