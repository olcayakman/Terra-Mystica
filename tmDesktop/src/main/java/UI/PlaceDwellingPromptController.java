package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

import GameLogic.GameHandler;
import GameLogic.ActionHandler;
import GameLogic.Game;
import GameLogic.Player;
import javafx.scene.input.MouseEvent;
// import GameLogic.Faction;
// import GameLogic.Terrain;

public class PlaceDwellingPromptController implements Initializable {

    @FXML Label playerNameLabel;
    @FXML Button placeDwellingButton;

    int placeDwellingButtonCounter = 0;
    int clickedX;
    int clickedY;

    boolean tileClicked;

    @FXML
    private void placeDwellingButtonClicked(ActionEvent event) {
        placeDwellingButtonCounter++;
        GameplayController.firstActStage.close();
        ActionHandler ah = ActionHandler.getInstance();
        Game g = Game.getInstance();
        GameHandler gh = GameHandler.getInstance();
       for (int i = 0; i < gh.getNumberOfPlayer()*2;i++){

            // For each player set it to the currentPlayer for the actionHandler
            int playerIndex = i % GameHandler.getInstance().getNumberOfPlayer();
            Player currentPlayer = gh.getPlayers().get(playerIndex);

            ah.setCurrentPlayer(currentPlayer);
            // Find the terrains that have the same home terrain 
            for(int j = 0; j < Game.getInstance().getNumberOfTerrain(); j++) {
                // Highlight those terrains 
                if (g.getTerrain(j / 13, j % 13).getType() == currentPlayer.getFaction().getTerrainType()) {
                    GameplayController.tileArr[j / 13][j % 13].setGlow();
                }
            }

            for (int j = 0; j < Game.getInstance().getNumberOfTerrain(); j++) {
                if (g.getTerrain(j / 13, j % 13).getType() == currentPlayer.getFaction().getTerrainType()) {
                    final int jTemp = j;
                    GameplayController.tileArr[j / 13][j % 13].setOnMouseClicked((e) -> {
                        GameplayController.tileArr[jTemp / 13][jTemp % 13].setEffect(null);
                        clickedX = jTemp / 13;
                        clickedY = jTemp % 13;
                        ah.setTerrainXPosition(clickedX);
                        ah.setTerrainYPosition(clickedY);
                        ah.setActionID(8);
                        // Execute action for the user
//                        ah.executeAction();
                        //clicked.
                        tileClicked = true;
                        ah.executeAction();
                        GameplayController.firstActStage.show();
                    });
                }
                //until action, wait
            }

            if (tileClicked) {


            }
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



}
