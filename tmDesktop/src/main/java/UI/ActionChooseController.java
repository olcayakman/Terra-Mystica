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
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/CultBoard.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		cultBoardStage = new Stage();
		cultBoardStage.setScene(scene);
		cultBoardStage.setHeight(750);
		cultBoardStage.setWidth(750);
		cultBoardStage.initStyle(StageStyle.UNDECORATED);
		cultBoardStage.initOwner(primaryStage);
		cultBoardStage.initModality(Modality.APPLICATION_MODAL);
		cultBoardStage.showAndWait();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void powerActionButtonClicked(ActionEvent event) {
		GameplayController.actionChooseStage.close();
	}


	/**
	 *
	 * @param event
	 */
	@FXML
	public void bonusCardActionButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
		bonusCardStage.showAndWait();
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	public void favorTileActionButtonClicked(ActionEvent event) throws IOException {
		GameplayController.actionChooseStage.close();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/FavorTile.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		favorTileStage = new Stage();
		favorTileStage.setScene(scene);
		favorTileStage.setHeight(400);
		favorTileStage.setWidth(600);
		favorTileStage.initStyle(StageStyle.UNDECORATED);
		favorTileStage.initOwner(primaryStage);
		favorTileStage.initModality(Modality.APPLICATION_MODAL);
		favorTileStage.showAndWait();
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