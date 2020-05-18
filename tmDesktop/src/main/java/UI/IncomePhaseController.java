package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import GameLogic.GameHandler;

public class IncomePhaseController {

    @FXML
    private void initContinueButtonClicked(ActionEvent event) throws Throwable {
        GameplayController.incomePhaseStage.close();
        GameHandler.getInstance().executeIncomePhase();
        GameplayController.actionPhaseStage.show();
    }
}
