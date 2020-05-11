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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

	private Button loadGameButton;
	private Button gameManualButton;
	private Button settingsButton;
	private Button historyButton;

	private Stage quitPopUp;
	private Button yes;
	private Button no;

	Stage mainMenuStage;
	Scene scene;
	URL path;

	@FXML
	Button newGameButton;
	@FXML
	Button quitButton;

	public MainMenuController() { mainMenuStage = new Stage(); }

	public MainMenuController(Stage stage) throws MalformedURLException {
		mainMenuStage = stage;
		mainMenuStage.initStyle(StageStyle.UNDECORATED);
		path = (new java.io.File("src/main/java/UI/view/MainMenu.fxml")).toURI().toURL();

		scene = new Scene(setLoader());

		mainMenuStage.setScene(scene);
		mainMenuStage.setFullScreen(true);
		mainMenuStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) { }

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
	 */
	@FXML
	private void newGameButtonClicked(ActionEvent event) throws IOException {
//		EventHandler handler = new EventHandler() {
//			@Override
//			public void handle(Event event) {
//
//				System.out.println("start game clicked");
//				try {
//					NewGameController ngc = new NewGameController(mainMenuStage);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		};
//		newGameButton.setOnAction(handler);
		System.out.println("new game button clicked.");
		System.out.println(mainMenuStage==null);
		NewGameController newGameController = new NewGameController();
		mainMenuStage.setScene(newGameController.getNewGameScene());
		mainMenuStage.show();
	}

	public Stage getMainMenuStage() {
		return mainMenuStage;
	}

	/**
	 *
	 * @param event
	 */
	private void loadGameButtonClicked(MouseEvent event) {
		// TODO - implement MainMenuController.loadGameButtonClicked
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	public void gameManualButtonClicked(MouseEvent event) {
		// TODO - implement MainMenuController.gameManualButtonClicked
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	private void settingsButtonClicked(MouseEvent event) {
		// TODO - implement MainMenuController.settingsButtonClicked
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	private void historyButtonClicked(MouseEvent event) {
		// TODO - implement MainMenuController.historyButtonClicked
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void quitButtonClicked(ActionEvent event) {
		// TODO - implement MainMenuController.quitButtonClicked
		System.exit(0);
	}

}