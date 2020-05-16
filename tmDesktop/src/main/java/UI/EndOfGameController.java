package UI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class EndOfGameController implements Initializable {

    @FXML
    Button fullScreenButton;

    public EndOfGameController() {}


    


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fullScreenButton.setVisible(false);
    }
}
