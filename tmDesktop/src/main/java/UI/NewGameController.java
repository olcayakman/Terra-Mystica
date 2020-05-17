package UI;

import GameLogic.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
	@FXML public TextField player1TextField;
	@FXML public TextField player2TextField;
	@FXML public TextField player3TextField;
	@FXML public TextField player4TextField;
	@FXML public TextField player5TextField;
	public static int playerNumber; //***


	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Faction> factions = new ArrayList<>();

	ArrayList<String> playerNames = new ArrayList<>();

	String[] arr = new String[5];

	public NewGameController(){ }

	/**
	 * 
	 * @param event
	 */
	@FXML
	private void startGameClicked(ActionEvent event) throws Throwable {
		if(!isValid()){
			return;
		}

		GameHandler gh = GameHandler.returnInstance();



		playerNames.add(player1TextField.getText());
		playerNames.add(player2TextField.getText());
		playerNames.add(player3TextField.getText());
		playerNames.add(player4TextField.getText());
		playerNames.add(player5TextField.getText());

		for (int i = 0; i < playerNames.size(); i++) {
			System.out.println("player name; " + playerNames.get(i));
			if (!playerNames.get(i).equals("")) {
				players.add(new Player(i,playerNames.get(i)));
			}
		}

		for (int i = 0; i < playerNumber; i++) {
			System.out.println("faction name: " + arr[i]);
				factions.add(createFaction(arr[i]));
		}


		gh.createGame(playerNumber, players, factions);



		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/Gameplay.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);

	}

	private boolean isValid(){

		arr[0] = choiceBox1.getValue();
		System.out.println("choicebox1 value " + arr[0]);
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

	private Faction createFaction(String fName) {
		switch(fName) {
			case "Witches":
				return new Witches();
			case "Alchemists":
				return new Alchemists();
			case "Halflings":
				return new Halflings();
			case "Mermaids":
				return new Mermaids();
			case "Giants":
				return new Giants();
			case "Nomads":
				return new Nomads();
			default: return null;
		}
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

	/*
	* return the no of players chosen
	 */
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
			choiceBox1.setItems(FXCollections.observableArrayList("Witches", "Alchemists", "Halflings", "Mermaids", "Giants", "Nomads"));
			choiceBox1.setValue("Auren");
			choiceBox2.setItems(FXCollections.observableArrayList("Witches", "Alchemists", "Halflings", "Mermaids", "Giants", "Nomads"));
			choiceBox2.setValue("Auren");
			choiceBox3.setItems(FXCollections.observableArrayList("Witches", "Alchemists", "Halflings", "Mermaids", "Giants", "Nomads"));
			choiceBox3.setValue("Auren");
			choiceBox4.setItems(FXCollections.observableArrayList("Witches", "Alchemists", "Halflings", "Mermaids", "Giants", "Nomads"));
			choiceBox4.setValue("Auren");
			choiceBox5.setItems(FXCollections.observableArrayList("Witches", "Alchemists", "Halflings", "Mermaids", "Giants", "Nomads"));
			choiceBox5.setValue("Auren");
	}
}