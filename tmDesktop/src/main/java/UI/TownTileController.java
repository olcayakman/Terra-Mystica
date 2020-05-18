package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class TownTileController implements Initializable {

	@FXML public Button selectButton;
	@FXML public Button select0;
	@FXML public Button select1;
	@FXML public Button select2;
	@FXML public Button select3;
	@FXML public Button select4;

	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.townTileStage.close();
	}

	@FXML
	private void select0Clicked(ActionEvent event) {
		GameplayController.townTileStage.close();
	}

	@FXML
	private void select1Clicked(ActionEvent event) {
		GameplayController.townTileStage.close();
	}

	@FXML
	private void select2Clicked(ActionEvent event) {
		GameplayController.townTileStage.close();
	}

	@FXML
	private void select3Clicked(ActionEvent event) {
		GameplayController.townTileStage.close();
	}

	@FXML
	private void select4Clicked(ActionEvent event) {
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

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		//selectButton.setVisible(false);
	}

}