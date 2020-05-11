package UI;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

	private Pane choosePlayerNo;
	private ChoiceBox noOfPlayersSelector;
	private Button confirmPlayerNo;
	private TextField player1NameField;
	private ChoiceBox factionSelector1;
	private TextField player2NameField;
	private ChoiceBox factionSelector2;
	private TextField player3NameField;
	private ChoiceBox factionSelector3;
	private TextField player4NameField;
	private ChoiceBox factionSelector4;
	private TextField player5NameField;
	private ChoiceBox factionSelector5;
	private Pane playerInfoAndFaction;
	private Button changePlayerNo;
	private Button startGame;

	Stage newGameStage;
	Scene oldScene;
	Scene scene;
	URL path;

	public NewGameController() throws MalformedURLException { setNewGameScene(); }

//	public NewGameController(Stage stage) throws IOException {
////		oldScene = stage.getScene();
////		newGameStage = stage;
////		newGameStage.initStyle(StageStyle.UNDECORATED);
////		System.out.println("olay");
////
////		System.out.println("olay1");
//
//		scene = setNewGameScene();
//
////		newGameStage.setScene(scene);
////		newGameStage.show();
//	}

	private Scene setNewGameScene() throws MalformedURLException {
		path = (new java.io.File("src/main/java/UI/view/NewGame.fxml")).toURI().toURL();
		return new Scene(setLoader());
	}

	public Scene getNewGameScene() {
		return scene;
	}

	public Stage getNewGameStage() {
		return newGameStage;
	}

	private Parent setLoader() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(path);
		AnchorPane aPane = null;
		try {
			aPane = (AnchorPane)loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aPane;
	}


	/**
	 * 
	 * @param event
	 */
	private void startGameClicked(MouseEvent event) {
		// TODO - implement NewGameController.startGameClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	private void exitClicked(ActionEvent event) throws Throwable {
		scene = oldScene;
		newGameStage.setScene(scene);
		newGameStage.show();
	}

	/**
	 * 
	 * @param event
	 */
	public void confirmPlayerNoClicked(ActionEvent event) {
		// TODO - implement NewGameController.confirmPlayerNoClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void changePlayerNoClicked(ActionEvent event) {
		// TODO - implement NewGameController.changePlayerNoClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param url
	 * @param resourceBundle
	 */
	public void initialize(DocFlavor.URL url, ResourceBundle resourceBundle) {
		// TODO - implement NewGameController.initialize
		throw new UnsupportedOperationException();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}