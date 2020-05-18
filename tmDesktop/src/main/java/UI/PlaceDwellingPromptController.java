package UI;

import GameLogic.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
// import GameLogic.Faction;
// import GameLogic.Terrain;

public class PlaceDwellingPromptController implements Initializable {

    @FXML Label playerNameLabel;
    @FXML Button placeDwellingButton;


    ActionHandler ah = ActionHandler.getInstance();
    Game g = Game.getInstance();
    GameHandler gh = GameHandler.getInstance();
    Player currentPlayer;

    int clickedX;
    int clickedY;

    boolean tileClicked;

    @FXML
    private void placeDwellingButtonClicked(ActionEvent event) {
        GameplayController.placeDwellingButtonCounter++;
        GameplayController.firstActStage.close();


            // For each player set it to the currentPlayer for the actionHandler
//            int playerIndex = GameplayController.placeDwellingButtonCounter % GameHandler.getInstance().getNumberOfPlayer();
//            Player currentPlayer = gh.getPlayers().get(playerIndex);


            // Find the terrains that have the same home terrain 
            for(int j = 0; j < Game.getInstance().getNumberOfTerrain(); j++) {
                // Highlight those terrains 
                if (g.getTerrain(j / 13, j % 13).getType() == currentPlayer.getFaction().getTerrainType() && (g.getTerrain(j /13, j % 13).getStructureType() == (Structure.EMPTY))) {
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
                            tileClicked = true;
                            ah.executeAction();

                            //draw the dwelling on given terrain..
                            //GameplayController.adjustStructure(true, clickedX, clickedY, Structure.DWELLING, currentPlayer.getFaction().getTerrainType());
                            GameplayController.adjustStructure(true, clickedX, clickedY, Structure.DWELLING);

                            FXMLLoader loader = new FXMLLoader();
                            try {
                                loader.setLocation((new java.io.File("src/main/java/UI/view/PlaceDwellingPrompt.fxml")).toURI().toURL());
                            } catch (MalformedURLException ex) {
                                ex.printStackTrace();
                            }
                            GameplayController.firstActStage = new Stage();
                            try {
                                GameplayController.firstActStage.setScene(new Scene(loader.load()));
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }

                            for (int k = 0; k < Game.getInstance().getNumberOfTerrain(); k++) {
                                // Highlight those terrains
                                if (g.getTerrain(k / 13, k % 13).getType() == currentPlayer.getFaction().getTerrainType()) {
                                    GameplayController.tileArr[k / 13][k % 13].setEffect(null);
                                }
                            }


                            if (GameplayController.placeDwellingButtonCounter < (GameHandler.getInstance().getNumberOfPlayer() * 2)) {
                                GameplayController.firstActStage.setHeight(450);
                                GameplayController.firstActStage.setWidth(700);
                                GameplayController.firstActStage.initStyle(StageStyle.UNDECORATED);
                                GameplayController.firstActStage.initOwner(GameUI.stage);
                                GameplayController.firstActStage.initModality(Modality.APPLICATION_MODAL);
                                GameplayController.firstActStage.show();
                            } else {
                                //set not clickable for tiles.
                                for (Player p: gh.getPlayers()) {
                                    for (int m = 0; m < Game.getInstance().getNumberOfTerrain(); m++) {
                                        if (g.getTerrain(m / 13, m % 13).getType() == p.getFaction().getTerrainType()) {
                                            GameplayController.tileArr[m / 13][m % 13].setOnMouseClicked(null);
                                        }
                                    }
                                }

                                GameplayController.isPlaceDwellingPhaseOver = true;
                                GameplayController.bonusCardStage.setHeight(466);
                                GameplayController.bonusCardStage.setWidth(1103);
                                GameplayController.bonusCardStage.initStyle(StageStyle.UNDECORATED);
                                GameplayController.bonusCardStage.initOwner(GameUI.stage);
                                GameplayController.bonusCardStage.initModality(Modality.APPLICATION_MODAL);
                                GameplayController.bonusCardStage.showAndWait();
                            }

                        });

                }
            }

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        int playerIndex = GameplayController.placeDwellingButtonCounter % GameHandler.getInstance().getNumberOfPlayer();
        currentPlayer = gh.getPlayers().get(playerIndex);
        ah.setCurrentPlayer(currentPlayer);
        //set playerNameLabel to current player's name
        playerNameLabel.setText(currentPlayer.getName() + "!");
    }



}



