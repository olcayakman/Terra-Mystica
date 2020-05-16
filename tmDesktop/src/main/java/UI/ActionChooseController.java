package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static UI.GameplayController.*;

public class ActionChooseController implements Initializable {

    @FXML public AnchorPane shippingPane;
	@FXML public AnchorPane specialActionsPane;
	@FXML public AnchorPane spadePane;


	/**
	 *
	 * @param event
	 */
	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
	}


	/**
	 *
	 * @param event
	 */
	@FXML
	public void terraformAndBuildButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
	}


	@FXML
	private void sendPriestToCultButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
		cultBoardStage.show();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void powerActionButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
		GameplayController.powerActionStage.show();
	}


	/**
	 *
	 * @param event
	 */
	@FXML
	public void bonusCardActionButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
		GameplayController.bonusCardStage.show();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void favorTileActionButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
		favorTileStage.show();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void upgradeShippingButtonClicked (ActionEvent event) {
		spadePane.setVisible(false);
		specialActionsPane.setVisible(false);
		shippingPane.setVisible(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void upgradeSpadeButtonClicked(ActionEvent event) {
		specialActionsPane.setVisible(false);
		shippingPane.setVisible(false);
		spadePane.setVisible(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void upgradeStructureButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void specialActionsButtonClicked (ActionEvent event) {
		spadePane.setVisible(false);
		shippingPane.setVisible(false);
		specialActionsPane.setVisible(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void passButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shippingPane.setVisible(false);
		specialActionsPane.setVisible(false);
		spadePane.setVisible(false);
	}
}