package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javax.print.DocFlavor;
import javax.swing.text.html.ListView;
import java.net.URL;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

	private ListView historyList;
	private TextArea historyDisplay;
	private Button mainMenuButton;

	@FXML public Button fullScreenButton;

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

	/**
	 * 
	 * @param url
	 * @param resourceBundle
	 */
	public void initialize(DocFlavor.URL url, ResourceBundle resourceBundle) {
		// TODO - implement HistoryController.initialize
		throw new UnsupportedOperationException();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullScreenButton.setVisible(false);
	}

}