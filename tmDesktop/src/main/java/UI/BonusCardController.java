package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import javax.print.DocFlavor;
import java.net.URL;
import java.util.ResourceBundle;

public class BonusCardController implements Initializable {

	@FXML
	public Button closeButton;

	@FXML public Button selectButton;

	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.bonusCardStage.close();
	}

	@FXML
	private void selectButtonClicked(ActionEvent event) {
		GameplayController.bonusCardStage.close();
		selectButton.setVisible(false);
		closeButton.setVisible(true);
	}

	public void updateBonusCards() {
		// TODO - implement BonusCardController.updateBonusCards
		throw new UnsupportedOperationException();
	}



	/**
	 *
	 * @param url
	 * @param resourceBundle
	 */
	public void initialize(DocFlavor.URL url, ResourceBundle resourceBundle) {
		// TODO - implement BonusCardController.initialize
		throw new UnsupportedOperationException();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		closeButton.setVisible(false);
	}
}