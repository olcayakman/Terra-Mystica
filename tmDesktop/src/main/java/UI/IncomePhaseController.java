package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import GameLogic.GameHandler;
import javafx.scene.control.Label;

public class IncomePhaseController {

    GameplayController gameplayController = new GameplayController();

    @FXML
    private void initContinueButtonClicked(ActionEvent event) throws Throwable {
        GameplayController.incomePhaseStage.close();
        GameHandler.getInstance().executeIncomePhase();
        NewGameController.gamePlayController.updateLabels();
        GameplayController.actionPhaseStage.show();
    }
}
