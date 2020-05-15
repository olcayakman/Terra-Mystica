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

	private Button select;
	private Pane bonusCard;

	@FXML
	private Button closeBonusButton;

	@FXML
	private Button selectBonusButton;

	@FXML
	private void closeBonusButtonClicked(ActionEvent event) {
		GameplayController.bonusCardStage.close();
	}

	@FXML
	private void selectButtonClicked(ActionEvent event) {
		GameplayController.bonusCardStage.close();
	}

	public void updateBonusCards() {
		// TODO - implement BonusCardController.updateBonusCards
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void selectClicked(ActionEvent event) {
		// TODO - implement BonusCardController.selectClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void backClicked(ActionEvent event) {
		// TODO - implement BonusCardController.backClicked
		throw new UnsupportedOperationException();
	}

	public boolean showSelect() {
		// TODO - implement BonusCardController.showSelect
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param event
	 */
	public void exitClicked(ActionEvent event) {
		// TODO - implement BonusCardController.exitClicked
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

	}
}