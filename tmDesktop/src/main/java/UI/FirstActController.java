package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class FirstActController {


    @FXML
    private void continueButtonClicked(ActionEvent event) throws Throwable {
        GameplayController.firstActStage.close();
        GameplayController.bonusCardStage.show();
    }

}
