package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class SettingsController {

	private Button muteButton;
	private Slider soundSlider;

	/**
	 * 
	 * @param event
	 */
	private void muteButtonClicked(MouseEvent event) {
		// TODO - implement SettingsController.muteButtonClicked
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
	 * @param event
	 */
	private void exitClicked(MouseEvent event) {
		// TODO - implement SettingsController.exitClicked
		throw new UnsupportedOperationException();
	}

}