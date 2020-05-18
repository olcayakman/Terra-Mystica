package UI;

import GameLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import javax.print.DocFlavor;
import javax.swing.text.html.ImageView;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class BonusCardController<playerNo> implements Initializable {

	@FXML public Button closeButton;

	@FXML public Button select0;
	@FXML public Button select1;
	@FXML public Button select2;
	@FXML public Button select3;
	@FXML public Button select4;
	@FXML public Button select5;
	@FXML public Button select6;
	@FXML public Button select7;
	@FXML public Button select8;
	@FXML Label playerNameLabel;

	Player currentPlayer;
	Game g = Game.getInstance();

	int bonusCardSelectCounter = 0;

	public int getBonusCardSelectCounter()
	{
		return bonusCardSelectCounter;
	}
	public void decreaseBonusCardSelectCounter (){
		bonusCardSelectCounter--;
	}

	int playerIndex = 0;
	ActionHandler ah = ActionHandler.getInstance();
	GameHandler gh = GameHandler.getInstance();
	int playerNo = gh.getNumberOfPlayer();
	// For each player set it to the currentPlayer for the actionHandler

	@FXML
	private void select0Clicked(ActionEvent event) {
		System.out.println("0 clicked");
		bonusCardSelectCounter++;

		//playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		System.out.println(currentPlayer.getName());
		playerIndex++;


		select0.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 0 ");

		currentPlayer.chooseBonusCard(0);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select1Clicked(ActionEvent event) {
		System.out.println("1 clicked");

		bonusCardSelectCounter++;

		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select1.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 1 " );
		currentPlayer.chooseBonusCard(1);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			playerNameLabel.setText("");
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select2Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select2.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 2 ");
		currentPlayer.chooseBonusCard(2);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			playerNameLabel.setText("");
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select3Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
//		int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select3.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 3 " );
		currentPlayer.chooseBonusCard(3);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			playerNameLabel.setText("");
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select4Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select4.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 4 ");
		currentPlayer.chooseBonusCard(4);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			playerNameLabel.setText("");
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select5Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select5.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 5 " );
		currentPlayer.chooseBonusCard(5);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			playerNameLabel.setText("");
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select6Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
		//int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select6.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 6 " );
		currentPlayer.chooseBonusCard(6);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			playerNameLabel.setText("");
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select7Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select7.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 7 ");
		currentPlayer.chooseBonusCard(7);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			playerNameLabel.setText("");
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}

	@FXML
	private void select8Clicked(ActionEvent event) {
		bonusCardSelectCounter++;
	//	int playerIndex = bonusCardSelectCounter % GameHandler.getInstance().getNumberOfPlayer();
		currentPlayer = gh.getPlayers().get(playerIndex);
		playerIndex++;

		select8.setVisible(false);

		playerNameLabel.setText(currentPlayer.getName() + ": NO 8" );
		currentPlayer.chooseBonusCard(8);
		closeButton.setVisible(true);
		if(bonusCardSelectCounter == playerNo) {
			playerNameLabel.setText("");
			GameplayController.bonusCardStage.close();
			GameplayController.incomePhaseStage.show();
		}
	}




	@FXML
	private void closeButtonClicked(ActionEvent event) {
		if(bonusCardSelectCounter == playerNo) {
			GameplayController.bonusCardStage.close();
		}
	}


	public void updateBonusCards() {
		// TODO - implement BonusCardController.updateBonusCards
		throw new UnsupportedOperationException();
	}






	@Override
	public void initialize(URL location, ResourceBundle resources) {

		closeButton.setVisible(false);
	//	bonusCardSelectCounter = 0;
	}
}