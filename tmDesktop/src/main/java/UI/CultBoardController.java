package UI;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class CultBoardController implements Initializable {

	@FXML private ImageView priest;

	public CultBoardController() { }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setPriestColor();
	}

	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.cultBoardStage.close();
	}

	@FXML
	private void setPriestColor() {
		ColorAdjust monochrome = new ColorAdjust();
		monochrome.setSaturation(-1.0);

		Blend blush = new Blend(
				BlendMode.MULTIPLY,
				monochrome,
				new ColorInput(
						0,
						0,
						priest.getImage().getWidth(),
						priest.getImage().getHeight(),
						Color.RED
				)
		);


		priest.effectProperty().bind(
				Bindings
					.when(priest.visibleProperty())
						.then((Effect) blush)
						.otherwise((Effect) null)
		);

		priest.setCache(true);
		priest.setCacheHint(CacheHint.SPEED);
	}







	private Button select;
	private HBox cult1Box;
	private HBox cult2Box;
	private HBox cult3Box;
	private HBox cult4Box;
	private Circle[] priestPlace1;
	private Circle[] priestPlace2;
	private Circle[] priestPlace3;
	private Circle[] priestPlace4;

	public void updateCultBoard() {
		// TODO - implement CultBoardController.updateCultBoard
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param event
	 */
	public void selectClicked(ActionEvent event) {
		// TODO - implement CultBoardController.selectClicked
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cult
	 * @param place
	 */
	public void priestPlaceClicked(Box cult, Circle place) {
		// TODO - implement CultBoardController.priestPlaceClicked
		throw new UnsupportedOperationException();
	}

	public boolean showSelect() {
		// TODO - implement CultBoardController.showSelect
		throw new UnsupportedOperationException();
	}


}