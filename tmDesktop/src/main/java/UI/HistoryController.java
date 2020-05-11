package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import javax.print.DocFlavor;
import javax.swing.text.html.ListView;
import java.util.ResourceBundle;

public class HistoryController {

	private ListView historyList;
	private TextArea historyDisplay;
	private Button mainMenuButton;

	private void displayHistory() {
		// TODO - implement HistoryController.displayHistory
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	private void historyListComponentClicked(MouseEvent event) {
		// TODO - implement HistoryController.historyListComponentClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	private void mainMenuButtonClicked(MouseEvent event) {
		// TODO - implement HistoryController.mainMenuButtonClicked
		throw new UnsupportedOperationException();
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

	/**
	 * 
	 * @param url
	 * @param resourceBundle
	 */
	public void initialize(DocFlavor.URL url, ResourceBundle resourceBundle) {
		// TODO - implement HistoryController.initialize
		throw new UnsupportedOperationException();
	}

}