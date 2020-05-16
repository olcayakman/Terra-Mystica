package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import javax.print.DocFlavor;
import java.util.ResourceBundle;

public class TownTileController {

	private Button select;
	private Pane townTile;
	@FXML
	private Button closeButton;
	@FXML
	private Button selectButton;

	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.townTileStage.close();
	}
	@FXML
	private void selectButtonClicked(ActionEvent event) {
		GameplayController.townTileStage.close();
	}

	public void updateTownTiles() {
		// TODO - implement TownTileController.updateTownTiles
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void selectClicked(ActionEvent event) {
		// TODO - implement TownTileController.selectClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void exitClicked(ActionEvent event) {
		// TODO - implement TownTileController.exitClicked
		throw new UnsupportedOperationException();
	}

	public boolean showSelect() {
		// TODO - implement TownTileController.showSelect
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param url
	 * @param resourceBundle
	 */
	public void initialize(DocFlavor.URL url, ResourceBundle resourceBundle) {
		// TODO - implement TownTileController.initialize
		throw new UnsupportedOperationException();
	}

}