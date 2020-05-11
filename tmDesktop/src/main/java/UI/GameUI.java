package UI;

import com.sun.tools.javac.Main;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameUI extends Application {

	private Stage stage;

	/**
	 * 
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
//		primaryStage.setTitle("Hello World!");
//		Button btn = new Button();
//		btn.setText("Exit App");
//		btn.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				System.exit(0);
//			}
//		});
//
//		StackPane root = new StackPane();
//		root.getChildren().add(btn);
//		primaryStage.setScene(new Scene(root, 300, 250));
//		primaryStage.setFullScreen(true);
//		primaryStage.initStyle(StageStyle.UNDECORATED);
//		primaryStage.show();

		MainMenuController mc = new MainMenuController(primaryStage);
		primaryStage = mc.getMainMenuStage();
		primaryStage.show();

	}

	public void main(String[] args) {
		launch(args);
	}

}