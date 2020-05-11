package UI;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewGameController implements Initializable {

	@FXML public Button fullScreenButton;

	public NewGameController(){

	}

	/**
	 * 
	 * @param event
	 */
	private void startGameClicked(MouseEvent event) {
		// TODO - implement NewGameController.startGameClicked
		throw new UnsupportedOperationException();
	}



	/**
	 * 
	 * @param event
	 */
	public void confirmPlayerNoClicked(ActionEvent event) {
		// TODO - implement NewGameController.confirmPlayerNoClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void changePlayerNoClicked(ActionEvent event) {
		// TODO - implement NewGameController.changePlayerNoClicked
		throw new UnsupportedOperationException();
	}


	public void handle(KeyEvent t) {
		if(t.getCode()== KeyCode.ESCAPE)
		{
			fullScreenButton.setVisible(true);
		}
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void fullScreenButtonClicked(ActionEvent event) throws Throwable {
		fullScreenButton.setVisible(false);
		GameUI.stage.setFullScreen(true);
	}

	/**
	 *
	 * @param event
	 */
	@FXML
	private void backButtonClicked(ActionEvent event) throws Throwable {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/MainMenu.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			fullScreenButton.setVisible(false);
	}
}