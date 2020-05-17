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

	static boolean gameCreateable = false;

	Player player1;
	Player player2;
	Player player3;
	Player player4;
	Player player5;

	String player1Name;
	String player2Name;
	String player3Name;
	String player4Name;
	String player5Name;

	Faction player1Faction;
	Faction player2Faction;
	Faction player3Faction;
	Faction player4Faction;
	Faction player5Faction;

	static Player[] playersArray;
	static Faction[] factionsArray;

	String[] arr = new String[5];

	public NewGameController(){

	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	private void startGameClicked(ActionEvent event) throws Throwable {
/*
		playersArray = new Player[playerNumber];
		factionsArray = new Faction[playerNumber];

		player1Name = player1TextField.getText();
		player2Name = player2TextField.getText();
		player3Name= player3TextField.getText();
		player4Name = player4TextField.getText();
		player5Name = player5TextField.getText();


		if (playerNumber == 2) {


			player1 = new Player(1, player1Name);
			player2 = new Player(2, player2Name);

			playersArray[0] = player1;
			playersArray[1] = player2;

			factionsArray[0] = createFaction(arr[0].toString());
			factionsArray[1] = createFaction(arr[1].toString());


		} else if (playerNumber == 3) {
			player1 = new Player(1, player1Name);
			player2 = new Player(2, player2Name);
			player3 = new Player(3, player3Name);

			playersArray[0] = player1;
			playersArray[1] = player2;
			playersArray[2] = player3;

			factionsArray[0] = createFaction(arr[0].toString());
			factionsArray[1] = createFaction(arr[1].toString());
			factionsArray[2] = createFaction(arr[2].toString());


		} else if (playerNumber == 4) {
			player1 = new Player(1, player1Name);
			player2 = new Player(2, player2Name);
			player3 = new Player(3, player3Name);
			player4 = new Player(4, player4Name);

			playersArray[0] = player1;
			playersArray[1] = player2;
			playersArray[2] = player3;
			playersArray[3] = player4;

			factionsArray[0] = createFaction(arr[0].toString());
			factionsArray[1] = createFaction(arr[1].toString());
			factionsArray[2] = createFaction(arr[2].toString());
			factionsArray[3] = createFaction(arr[3].toString());


		} else if(playerNumber == 5) {
			player1 = new Player(1, player1Name);
			player2 = new Player(2, player2Name);
			player3 = new Player(3, player3Name);
			player4 = new Player(4, player4Name);
			player5 = new Player(5, player5Name);

			playersArray[0] = player1;
			playersArray[1] = player2;
			playersArray[2] = player3;
			playersArray[3] = player4;
			playersArray[4] = player5;

			factionsArray[0] = createFaction(arr[0].toString());
			factionsArray[1] = createFaction(arr[1].toString());
			factionsArray[2] = createFaction(arr[2].toString());
			factionsArray[3] = createFaction(arr[3].toString());
			factionsArray[4] = createFaction(arr[4].toString());

		}

*/
		if(!isValid()){
			return;
		}
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/Gameplay.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);

		gameCreateable = true;
	}

	private boolean isValid(){

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
/*
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

	public ArrayList getPlayers() {
		if (!gameCreateable) {
			System.out.println("oh no - getPlayers returned null");
			return null;

		}

		ArrayList p = new ArrayList<Player>();
		for (int i = 0; i < playerNumber; i++) {
			p.add(playersArray[i]);
		}
		return p;
	}

	public ArrayList getFactions() {
		if (!gameCreateable) {
			System.out.println("oh no - getFactions returned null");
			return null;
		}

		ArrayList f = new ArrayList<Faction>();
		for (int i = 0; i < playerNumber; i++) {
			f.add(factionsArray[i]);
		}
		return f;
	}
*/
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