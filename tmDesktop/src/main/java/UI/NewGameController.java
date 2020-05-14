package UI;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

	@FXML public Button fullScreenButton;
	@FXML public Button confirmPlayerNoButton;
	@FXML public VBox factionChooseBox;
	@FXML public HBox playerNumberBox;
	@FXML public ChoiceBox<Integer> choiceBox0;
	@FXML public ChoiceBox<String> choiceBox1;
	@FXML public ChoiceBox<String> choiceBox2;
	@FXML public ChoiceBox<String> choiceBox3;
	@FXML public ChoiceBox<String> choiceBox4;
	@FXML public ChoiceBox<String> choiceBox5;
	@FXML public HBox factionBox3;
	@FXML public HBox factionBox4;
	@FXML public HBox factionBox5;
	int playerNumber;

	public NewGameController(){

	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	private void startGameClicked(ActionEvent event) throws Throwable {
		if(!isValid()){
			return;
		}
		Group rootGroup = new Group();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/Gameplay.fxml")).toURI().toURL());
		rootGroup.getChildren().add(GameplayController.createMap());
		rootGroup.getChildren().add(loader.load());
		Scene scene = new Scene(rootGroup);
		scene.setFill(Color.ANTIQUEWHITE);
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	private boolean isValid(){
		String[] arr = new String[5];
		arr[0] = choiceBox1.getValue();
		arr[1] = choiceBox2.getValue();
		arr[2] = choiceBox3.getValue();
		arr[3] = choiceBox4.getValue();
		arr[4] = choiceBox5.getValue();
		for(int i = 0; i < playerNumber - 1; i++){
			for(int j = i + 1; j < playerNumber; j++){
				if(arr[i].equals(arr[j]))
					return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	public void confirmPlayerNoClicked(ActionEvent event) throws Throwable {
		getPlayerNoChoice(choiceBox0);
		playerNumberBox.setVisible(false);
		factionChooseBox.setVisible(true);
	}

	private void getPlayerNoChoice(ChoiceBox<Integer> choiceBox){
		playerNumber = choiceBox.getValue();
		if(playerNumber == 2) {
			factionBox3.setVisible(false);
			factionBox4.setVisible(false);
			factionBox5.setVisible(false);
		}
		if(playerNumber == 3) {
			factionBox3.setVisible(true);
			factionBox4.setVisible(false);
			factionBox5.setVisible(false);
		}
		if(playerNumber == 4) {
			factionBox3.setVisible(true);
			factionBox4.setVisible(true);
			factionBox5.setVisible(false);
		}
		if(playerNumber == 5) {
			factionBox3.setVisible(true);
			factionBox4.setVisible(true);
			factionBox5.setVisible(true);
		}
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
			choiceBox0.setItems(FXCollections.observableArrayList(2, 3, 4, 5));
			choiceBox0.setValue(2);
			choiceBox1.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox1.setValue("a");
			choiceBox2.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox2.setValue("a");
			choiceBox3.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox3.setValue("a");
			choiceBox4.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox4.setValue("a");
			choiceBox5.setItems(FXCollections.observableArrayList("a", "b", "c", "d"));
			choiceBox5.setValue("a");
	}
}