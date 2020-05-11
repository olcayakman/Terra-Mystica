package UI;

import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;

public class GameUI extends Application {

	private Stage stage;

	/**
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		URL path = (new java.io.File("src/main/java/UI/view/MainMenu.fxml")).toURI().toURL();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(path);
		AnchorPane aPane = null;
		try {
			aPane = (AnchorPane)loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		primaryStage.setScene(new Scene(aPane));



		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setFullScreen(true);
		primaryStage.show();

	}

	public void main(String[] args) {
		launch(args);
	}

}