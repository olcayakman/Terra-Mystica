package UI;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ResourceBundle;

public class ManualController implements Initializable {


	final StringProperty textValue = new SimpleStringProperty("initial value");

	@FXML
	Label lblLabel;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		System.out.println("You clicked continue!");
		setTextValue("continue clicked");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblLabel.textProperty().bind(textValueProperty());
	}

	public String getTextValue() {
		return textValue.get();
	}

	public StringProperty textValueProperty() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue.set(textValue);
	}




//	private Button backButton;
//	private ScrollBar scrollBar;
//	//private PdfDecoder pdf;
//
//	private void displayManual() {
//		// TODO - implement ManualController.displayManual
//		throw new UnsupportedOperationException();
//	}
//
//	/**
//	 *
//	 * @param event
//	 */
//	private void scrollBarUsed(MouseEvent event) {
//		// TODO - implement ManualController.scrollBarUsed
//		throw new UnsupportedOperationException();
//	}
//
//	/**
//	 *
//	 * @param event
//	 */
//	private void exitClicked(MouseEvent event) {
//		// TODO - implement ManualController.exitClicked
//		throw new UnsupportedOperationException();
//	}

}