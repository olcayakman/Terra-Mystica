package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class IncomePhaseController {

    @FXML
    private void initContinueButtonClicked(ActionEvent event) throws Throwable {
        GameplayController.incomePhaseStage.close();
        GameplayController.actionPhaseStage.show();
    }
}
