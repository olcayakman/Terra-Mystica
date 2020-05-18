package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ActionPhaseController {
    @FXML
    private void continueButtonClicked(ActionEvent event) throws Throwable {
        GameplayController.actionPhaseStage.close();
    }

}
