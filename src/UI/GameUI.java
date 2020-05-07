package UI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class GameUI extends Application {

	private Stage stage;

	@Override
	public void start(Stage primaryStage) throws IOException {

		primaryStage.setTitle("Terra Mystica");

		FXMLLoader loader = new FXMLLoader();

		String fxmlDocPath = "view/Manual.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);

		VBox root = loader.load(fxmlStream);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		primaryStage.show();

	}

	/**
	 * 
	 * @param args
	 */
	public void main(String[] args) {
		launch(args);
	}

}