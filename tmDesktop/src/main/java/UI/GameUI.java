package UI;

import GameLogic.Faction;
import GameLogic.GameHandler;
import GameLogic.Player;
import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class GameUI extends Application {

	public static Stage stage;

	static GameHandler gh;
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Faction> factions = new ArrayList<>();

	/**
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		gh = new GameHandler();


		stage = primaryStage;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/MainMenu.fxml")).toURI().toURL());
		Scene newMainMenuScene = new Scene(loader.load());
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setFullScreen(true);
		stage.setScene(newMainMenuScene);
		stage.show();

		

	}

	public void main(String[] args) {
		launch(args);
	}

}