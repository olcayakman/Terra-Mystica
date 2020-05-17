package UI;

import javafx.event.ActionEvent;
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
// import GameLogic.Faction;
// import GameLogic.Terrain;

public class PlaceDwellingPromptController implements Initializable {

    @FXML Label playerNameLabel;
    @FXML Button placeDwellingButton;

    int placeDwellingButtonCounter = 0;
    int clickedX;
    int clickedY;

    @FXML
    private void placeDwellingButtonClicked(ActionEvent event) {
        placeDwellingButtonCounter++;
        GameplayController.firstActStage.close();
        ActionHandler ah = ActionHandler.getInstance();
        Game g = Game.getInstance();
        GameHandler gh = GameHandler.getInstance();
        while (placeDwellingButtonCounter < 2 * GameHandler.getInstance().getNumberOfPlayer()){

            // For each player set it to the currentPlayer for the actionHandler
            int playerIndex = placeDwellingButtonCounter % GameHandler.getInstance().getNumberOfPlayer();
            Player currentPlayer = gh.getPlayers().get(playerIndex);

            ah.setCurrentPlayer(currentPlayer);
            // Find the terrains that have the same home terrain 
            for(int j = 0; j < Game.getInstance().getNumberOfTerrain(); j++){
                // Highlight those terrains 
                if (g.getTerrain(j / 13, j % 13).getType() == currentPlayer.getFaction().getTerrainType()){
                    GameplayController.tileArr[j / 13][j % 13].setGlow();

                    GameplayController.tileArr[j / 13][j % 13].setOnMouseClicked((e) -> {
                        GameplayController.tileArr[j / 13][j % 13].setEffect(null);
                        clickedX = 0;
                        clickedY = 0;
                        ah.setTerrainXPosition(clickedX);
                        ah.setTerrainYPosition(clickedX);
                        ah.setActionID(8);
                        // Execute action for the user 
                        ah.executeAction();
                    });
                }
            }

            // Get the click index and set terrainX and terrainY 
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



}
