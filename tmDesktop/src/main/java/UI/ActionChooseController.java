package UI;

import GameLogic.ActionHandler;
import GameLogic.Game;
import GameLogic.GameHandler;
import GameLogic.Structure;
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

	GameHandler gh = GameHandler.getInstance();
	ActionHandler ah = ActionHandler.getInstance();
	Game g = Game.getInstance();


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
	//action id 0
	@FXML
	public void terraformAndBuildButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
		for(int j = 0; j < g.getNumberOfTerrain(); j++) {
			// Highlight those terrains
			ah.setActionID(10); //canTerraformTerrain
			ah.setTerrainXPosition(j / 13);
			ah.setTerrainYPosition(j % 13);
			ah.setTargetTerrainType(gh.nextPlayer().getFaction().getTerrainType());
			ah.setActionIndex(0);
			if ( ah.getPerformableActionId() ) {
				GameplayController.tileArr[j / 13][j % 13].setGlow();
			}
		}
		gh.executeActionPhase(0);
	}

	//action id 4
	@FXML
	private void sendPriestToCultButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
		cultBoardStage.show();
	}

	/**
	 *
	 * @param event
	 */
	//action id 5 -- powerAction id will be set.
	@FXML
	public void powerActionButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
		powerActionController.selectButton.setVisible(true);
		GameplayController.powerActionStage.show();
	}


	/**
	 *
	 * @param event
	 */
	@FXML
	public void bonusCardActionButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
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
	//action id 1
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
	//action id 2
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
	//action id 3
	@FXML
	public void upgradeStructureButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
		
	}

	/**
	 *
	 * @param event
	 */
	//action id 6
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
	//action id 7
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