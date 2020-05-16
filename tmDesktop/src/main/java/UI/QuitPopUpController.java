package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class QuitPopUpController {


    @FXML
    private Button quitYesButton;
    @FXML private Button quitNoButton;

    public QuitPopUpController() { }


    @FXML
    private void quitYesButtonClicked() {
        System.exit(0);
    }

    @FXML
    private void quitNoButtonClicked() {
        MainMenuController.quitPopUpStage.close();
    }




}
