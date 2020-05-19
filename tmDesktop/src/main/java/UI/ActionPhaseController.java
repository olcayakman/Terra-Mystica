package UI;

import GameLogic.GameHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ActionPhaseController implements Initializable {

    @FXML Button chooseActionButton;
    @FXML Label playerNameLabel;

    GameHandler gh = GameHandler.getInstance();



    @FXML
    private void chooseActionButtonClicked(ActionEvent event) throws Throwable {
        GameplayController.actionPhaseStage.close();

        FXMLLoader loader9 = new FXMLLoader();
        try {
            loader9.setLocation((new java.io.File("src/main/java/UI/view/ActionChoose.fxml")).toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Scene scene9 = null;
        try {
            scene9 = new Scene(loader9.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        GameplayController.actionChooseStage = new Stage();
        GameplayController.actionChooseStage.setScene(scene9);
        GameplayController.actionChooseStage.setHeight(500);
        GameplayController.actionChooseStage.setWidth(755);
        GameplayController.actionChooseStage.initStyle(StageStyle.UNDECORATED);
        GameplayController.actionChooseStage.initOwner(GameUI.stage);
        GameplayController.actionChooseStage.initModality(Modality.APPLICATION_MODAL);
        GameplayController.actionChooseStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        playerNameLabel.setText(gh.nextPlayer().getName() + "!");
    }
}
