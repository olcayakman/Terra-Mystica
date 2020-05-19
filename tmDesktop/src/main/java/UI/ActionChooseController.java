package UI;

import GameLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static UI.GameplayController.*;

public class ActionChooseController implements Initializable {

	public static Stage chooseStructureStage;
    @FXML public AnchorPane shippingPane;
	@FXML public AnchorPane specialActionsPane;
	@FXML public AnchorPane spadePane;

	ArrayList<GameplayController.Tile> glowingTerrains = new ArrayList<>();

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
		for(int j = 0; j < gh.getCurrentPlayer().getControlledTerrains().size(); j++) {
			Terrain curr = gh.getCurrentPlayer().getControlledTerrains().get(j);
			int x = curr.getX();
			int y = curr.getY();

			ah.setCurrentPlayer(gh.getCurrentPlayer());

			//x-1, y
			ah.setTerrainXPosition(x-1);
			ah.setTerrainYPosition(y);
			ah.setActionID(10); //canTerraformTerrain
			ah.setTerrainToBeModified(g.getTerrain(x-1,y));
			ah.setTargetTerrainType(curr.getType());
			ah.setActionIndex(0);
			ah.executeAction();
			if ( ah.getPerformableActionId() ) {
				GameplayController.tileArr[x-1][y].setGlow();
			}

			//x-1,y+1
			ah.setTerrainXPosition(x-1);
			ah.setTerrainYPosition(y+1);
			ah.setActionID(10); //canTerraformTerrain
			ah.setTerrainToBeModified(g.getTerrain(x-1,y+1));
			ah.setTargetTerrainType(curr.getType());
			ah.setActionIndex(0);
			ah.executeAction();
			if ( ah.getPerformableActionId() ) {
				GameplayController.tileArr[x-1][y+1].setGlow();
			}

			//x,y-1
			ah.setTerrainXPosition(x);
			ah.setTerrainYPosition(y-1);
			ah.setActionID(10); //canTerraformTerrain
			ah.setTerrainToBeModified(g.getTerrain(x,y-1));
			ah.setTargetTerrainType(curr.getType());
			ah.setActionIndex(0);
			ah.executeAction();
			if ( ah.getPerformableActionId() ) {
				GameplayController.tileArr[x][y-1].setGlow();
			}

			//x,y+1
			ah.setTerrainXPosition(x);
			ah.setTerrainYPosition(y+1);
			ah.setActionID(10); //canTerraformTerrain
			ah.setTerrainToBeModified(g.getTerrain(x,y+1));
			ah.setTargetTerrainType(curr.getType());
			ah.setActionIndex(0);
			ah.executeAction();
			if ( ah.getPerformableActionId() ) {
				GameplayController.tileArr[x][y+1].setGlow();
			}

			//x+1, y+1
			ah.setTerrainXPosition(x+1);
			ah.setTerrainYPosition(y+1);
			ah.setActionID(10); //canTerraformTerrain
			ah.setTerrainToBeModified(g.getTerrain(x+1,y+1));
			ah.setTargetTerrainType(curr.getType());
			ah.setActionIndex(0);
			ah.executeAction();
			if ( ah.getPerformableActionId() ) {
				GameplayController.tileArr[x+1][y+1].setGlow();
			}

			//x+1,y
			ah.setTerrainXPosition(x+1);
			ah.setTerrainYPosition(y);
			ah.setActionID(10); //canTerraformTerrain
			ah.setTerrainToBeModified(g.getTerrain(x+1,y));
			ah.setTargetTerrainType(curr.getType());
			ah.setActionIndex(0);
			ah.executeAction();
			if ( ah.getPerformableActionId() ) {
				GameplayController.tileArr[x+1][y].setGlow();
			}


		}

	//for each glowing tile in tileArr

			for (int xMap = 0; xMap < 9; xMap++) {
				for (int yMap = 0; yMap < 13; yMap++) {
					final int xMapFinal = xMap;
					final int yMapFinal = yMap;
					if (tileArr[xMap][yMap].isGlow) {
						GameplayController.tileArr[xMapFinal][yMapFinal].setOnMouseClicked((e) -> {
							System.out.println("hoba");
							ah.setTerrainXPosition(g.getTerrain(xMapFinal, yMapFinal).getX());
							ah.setTerrainYPosition(g.getTerrain(xMapFinal, yMapFinal).getY());
							ah.setActionID(0);
							ah.setTerrainToBeModified(Game.getInstance().getTerrain(xMapFinal, yMapFinal));
							ah.executeAction();
							Color color;
							tileArr[xMapFinal][yMapFinal].disableGlow();
							switch (gh.getCurrentPlayer().getFaction().getTerrainType()) {
								case PLAINS:
									color = Color.rgb(166, 127, 119); //brown
									break;
								case LAKES:
									color = Color.rgb(4, 150, 176); //blue
									break;
								case FOREST:
									color = Color.rgb(95,145,25); //green
									break;
								case SWAMP:
									color = Color.rgb(86, 86, 63); //dark grey
									break;
								case MOUNTAINS:
									color = Color.rgb(191, 191, 191); //grey
									break;
								case WASTELAND:
									color = Color.rgb(235, 0, 31); //red
									break;
								case DESERT:
									color = Color.rgb(252, 252, 75); //yellow
									break;
								default:
									System.out.println("bok");
									color = Color.rgb(255, 255, 255); //white
							}
							GameplayController.tileArr[xMapFinal][yMapFinal].setFill(color);
							adjustStructure(true, xMapFinal, yMapFinal, Structure.DWELLING);
//							ah.setActionID(3);
//							ah.executeAction();
//							adjustStructure(true, xMapFinal, yMapFinal, Structure.TRADINGPOST);
						});
					}
				}
			}

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
		GameplayController.favorTileController.updateLabels();
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
			//if adjust
			chooseStructureStage.show();
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
		bonusCardController.decreaseBonusCardSelectCounter();
	//	int curBonusId = 0;
		int curBonusId = gh.getCurrentPlayer().getChosenBonusCard().getId();
		System.out.println(curBonusId);
		System.out.println(gh.getCurrentPlayer().getName());
		gh.getCurrentPlayer().returnBonusCard();
		gh.getCurrentPlayer().setPassed(true);

		bonusCardStage.showAndWait();

		if ( curBonusId == 0)
			bonusCardController.select0.setVisible(true);
		else if ( curBonusId == 1)
			bonusCardController.select1.setVisible(true);
		else if ( curBonusId == 2)
			bonusCardController.select2.setVisible(true);
		else if ( curBonusId == 3)
			bonusCardController.select3.setVisible(true);
		else if ( curBonusId == 4)
			bonusCardController.select4.setVisible(true);
		else if ( curBonusId == 5)
			bonusCardController.select5.setVisible(true);
		else if ( curBonusId == 6)
			bonusCardController.select6.setVisible(true);
		else if ( curBonusId == 7)
			bonusCardController.select7.setVisible(true);
		else
			bonusCardController.select8.setVisible(true);

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shippingPane.setVisible(false);
		specialActionsPane.setVisible(false);
		spadePane.setVisible(false);


		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation((new java.io.File("src/main/java/UI/view/ChooseStructure.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene = null;
		try {
			scene = new Scene(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		chooseStructureStage = new Stage();
		chooseStructureStage.setScene(scene);
		chooseStructureStage.setHeight(400);
		chooseStructureStage.setWidth(250);
		chooseStructureStage.initStyle(StageStyle.UNDECORATED);
		chooseStructureStage.initOwner(GameUI.stage);
		chooseStructureStage.initModality(Modality.APPLICATION_MODAL);
	}
}