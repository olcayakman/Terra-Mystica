package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;

public class ManualController {

	private Button backButton;
	private ScrollBar scrollBar;
	//private PdfDecoder pdf;

	private void displayManual() {
		// TODO - implement ManualController.displayManual
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	private void scrollBarUsed(MouseEvent event) {
		// TODO - implement ManualController.scrollBarUsed
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
		// TODO - implement ManualController.exitClicked
		throw new UnsupportedOperationException();
	}

}