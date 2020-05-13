package UI;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class CultBoardController implements Initializable {

	@FXML private Shape earthhome3;
	@FXML ObjectProperty<Paint> earthhome3fill;

	public CultBoardController() { }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		earthhome3.setFill(Color.RED);
//		earthhome3.fillProperty().bindBidirectional(earthhome3fill);
	}

	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.cultBoardStage.close();
	}










//	@FXML
//	private void setCircleColor() {
//		ColorAdjust monochrome = new ColorAdjust();
//		monochrome.setSaturation(-1.0);
//
//		Blend blush = new Blend(
//				BlendMode.MULTIPLY,
//				monochrome,
//				new ColorInput(
//						0,
//						0,
//						earthhome3.getImage().getWidth(),
//						earthhome3.getImage().getHeight(),
//						Color.RED
//				)
//		);
//
//
//		earthhome3.effectProperty().bind(
//				Bindings
//					.when(priest.visibleProperty())
//						.then((Effect) blush)
//						.otherwise((Effect) null)
//		);
//
//		earthhome3.setCache(true);
//		earthhome3.setCacheHint(CacheHint.SPEED);
//	}



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