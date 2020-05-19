package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class FirstActController {


    @FXML
    private void continueButtonClicked(ActionEvent event) throws Throwable {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation((new java.io.File("src/main/java/UI/view/PlaceDwellingPrompt.fxml")).toURI().toURL());
        GameplayController.firstActStage.setScene(new Scene(loader.load()));

//        GameplayController.firstActStage.close();

//        GameplayController.bonusCardStage.show();
    }



}
