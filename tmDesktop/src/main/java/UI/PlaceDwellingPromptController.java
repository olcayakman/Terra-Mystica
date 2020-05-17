package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.ResourceBundle;

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

        //highlight all the terrains the user can place a dwelling on the map
        GameplayController.tileArr[0][0].setGlow();
        GameplayController.tileArr[0][0].setOnMouseClicked((e) -> {
           GameplayController.tileArr[0][0].setEffect(null);
           clickedX = 0;
           clickedY = 0;
        });
        

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



}
