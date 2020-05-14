package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import javax.print.DocFlavor;
import java.util.ResourceBundle;

public class RoundTileController {

	private Pane roundTile;
	@FXML
	private Button closeButton;

	@FXML
	private void closeBonusButtonClicked(ActionEvent event) {
		GameplayController.roundTileStage.close();
	}

	public void updateRoundTiles() {
		// TODO - implement RoundTileController.updateRoundTiles
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void exitClicked(ActionEvent event) {
		// TODO - implement RoundTileController.exitClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param url
	 * @param resourceBundle
	 */
	public void initialize(DocFlavor.URL url, ResourceBundle resourceBundle) {
		// TODO - implement RoundTileController.initialize
		throw new UnsupportedOperationException();
	}

}