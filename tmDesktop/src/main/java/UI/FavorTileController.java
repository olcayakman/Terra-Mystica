package UI;

import GameLogic.ActionHandler;
import GameLogic.Game;
import GameLogic.GameHandler;
import GameLogic.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import javax.print.DocFlavor;
import java.util.ResourceBundle;

public class FavorTileController {

    private Pane favorTile;
    @FXML
    public Button closeButton;
    @FXML
    public Button select0;
    @FXML
    public Button select1;
    @FXML
    public Button select2;
    @FXML
    public Button select3;
    @FXML
    public Button select4;
    @FXML
    public Button select5;
    @FXML
    public Button select6;
    @FXML
    public Button select7;
    @FXML
    public Button select8;
    @FXML
    public Button select9;
    @FXML
    public Button select10;
    @FXML
    public Button select11;

    @FXML public Label left0;
    @FXML public Label left1;
    @FXML public Label left2;
    @FXML public Label left3;
    @FXML public Label left4;
    @FXML public Label left5;
    @FXML public Label left6;
    @FXML public Label left7;
    @FXML public Label left8;
    @FXML public Label left9;
    @FXML public Label left10;
    @FXML public Label left11;
    @FXML public Label warning;

    int label0 = 1, label1 = 1, label2 = 1, label3 = 1,
            label4 = 3, label5 = 3, label6 = 3, label7 = 3, label8 = 3, label9 = 3, label10 = 3, label11 = 3;



    public void updateLabels () {
        warning.setVisible(false);
        left0.setText("Left : " + label0);
        left1.setText("Left : " + label1);
        left2.setText("Left : " + label2);
        left3.setText("Left : " + label3);
        left4.setText("Left : " + label4);
        left5.setText("Left : " + label5);
        left6.setText("Left : " + label6);
        left7.setText("Left : " + label7);
        left8.setText("Left : " + label8);
        left9.setText("Left : " + label9);
        left10.setText("Left : " + label10);
        left11.setText("Left : " + label11);
    }

    Game g = Game.getInstance();
    GameHandler gh = GameHandler.getInstance();
    Player currentPlayer = g.getCurrentPlayer();

    @FXML
    private void select0Clicked(ActionEvent event) {
        if(label0 > 0) {
            label0--;
            currentPlayer.chooseFavorTile(0);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select1Clicked(ActionEvent event) {
        if(label1 > 0) {
            label1--;
            currentPlayer.chooseFavorTile(1);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }
    @FXML
    private void select2Clicked(ActionEvent event) {
        if(label2 > 0) {
            label2--;
            currentPlayer.chooseFavorTile(2);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select3Clicked(ActionEvent event) {
        if(label3 > 0) {
            label3--;
            currentPlayer.chooseFavorTile(3);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select4Clicked(ActionEvent event) {
        if(label4 > 0) {
            label4--;
            currentPlayer.chooseFavorTile(4);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select5Clicked(ActionEvent event) {
        if(label5 > 0) {
            label5--;
            currentPlayer.chooseFavorTile(5);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select6Clicked(ActionEvent event) {
        if(label6 > 0) {
            label6--;
            currentPlayer.chooseFavorTile(6);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select7Clicked(ActionEvent event) {
        if(label7 > 0) {
            label7--;
            currentPlayer.chooseFavorTile(7);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select8Clicked(ActionEvent event) {
        if(label8 > 0) {
            label8--;
            currentPlayer.chooseFavorTile(8);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select9Clicked(ActionEvent event) {
        if(label9 > 0) {
            label9--;
            currentPlayer.chooseFavorTile(9);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select10Clicked(ActionEvent event) {
        if(label10 > 0) {
            label10--;
            currentPlayer.chooseFavorTile(10);
            updateLabels();
            GameplayController.favorTileStage.close();
        }
        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void select11Clicked(ActionEvent event) {
        if(label11 > 0) {
            label11--;
            currentPlayer.chooseFavorTile(11);
            updateLabels();
            GameplayController.favorTileStage.close();
        }

        else
        {
            warning.setVisible(true);
        }
    }

    @FXML
    private void closeButtonClicked(ActionEvent event) {
        GameplayController.favorTileStage.close();
    }

    public void updateFavorTiles() {
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
        updateLabels();
        // TODO - implement RoundTileController.initialize
        throw new UnsupportedOperationException();
    }


}