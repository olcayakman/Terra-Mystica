package UI;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
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

	static Color red = Color.RED;

	@FXML Circle firehome3;
	@FXML Circle firehome2top;
	@FXML Circle firehome2left;
	@FXML Circle firehome2right;
	@FXML Circle fireroad0;
	@FXML Circle fireroad1;
	@FXML Circle fireroad2;
	@FXML Circle fireroad3;
	@FXML Circle fireroad4;
	@FXML Circle fireroad5;
	@FXML Circle fireroad6;
	@FXML Circle fireroad7;
	@FXML Circle fireroad8;
	@FXML Circle fireroad9;
	@FXML Circle fireroad10;

	@FXML Circle earthhome3;
	@FXML Circle earthhome2top;
	@FXML Circle earthhome2left;
	@FXML Circle earthhome2right;
	@FXML Circle earthroad0;
	@FXML Circle earthroad1;
	@FXML Circle earthroad2;
	@FXML Circle earthroad3;
	@FXML Circle earthroad4;
	@FXML Circle earthroad5;
	@FXML Circle earthroad6;
	@FXML Circle earthroad7;
	@FXML Circle earthroad8;
	@FXML Circle earthroad9;
	@FXML Circle earthroad10;

	@FXML Circle waterhome3;
	@FXML Circle waterhome2top;
	@FXML Circle waterhome2left;
	@FXML Circle waterhome2right;
	@FXML Circle waterroad0;
	@FXML Circle waterroad1;
	@FXML Circle waterroad2;
	@FXML Circle waterroad3;
	@FXML Circle waterroad4;
	@FXML Circle waterroad5;
	@FXML Circle waterroad6;
	@FXML Circle waterroad7;
	@FXML Circle waterroad8;
	@FXML Circle waterroad9;
	@FXML Circle waterroad10;

	@FXML Circle windhome3;
	@FXML Circle windhome2top;
	@FXML Circle windhome2left;
	@FXML Circle windhome2right;
	@FXML Circle windroad0;
	@FXML Circle windroad1;
	@FXML Circle windroad2;
	@FXML Circle windroad3;
	@FXML Circle windroad4;
	@FXML Circle windroad5;
	@FXML Circle windroad6;
	@FXML Circle windroad7;
	@FXML Circle windroad8;
	@FXML Circle windroad9;
	@FXML Circle windroad10;



	public CultBoardController() { }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		firehome3.setVisible(false);
		firehome2top.setVisible(false);
		firehome2left.setVisible(false);
		firehome2right.setVisible(false);
		fireroad0.setVisible(false);
		fireroad1.setVisible(false);
		fireroad2.setVisible(false);
		fireroad3.setVisible(false);
		fireroad4.setVisible(false);
		fireroad5.setVisible(false);
		fireroad6.setVisible(false);
		fireroad7.setVisible(false);
		fireroad8.setVisible(false);
		fireroad9.setVisible(false);
		fireroad10.setVisible(false);

		earthhome3.setVisible(false);
		earthhome2top.setVisible(false);
		earthhome2left.setVisible(false);
		earthhome2right.setVisible(false);
		earthroad0.setVisible(false);
		earthroad1.setVisible(false);
		earthroad2.setVisible(false);
		earthroad3.setVisible(false);
		earthroad4.setVisible(false);
		earthroad5.setVisible(false);
		earthroad6.setVisible(false);
		earthroad7.setVisible(false);
		earthroad8.setVisible(false);
		earthroad9.setVisible(false);
		earthroad10.setVisible(false);

		waterhome3.setVisible(false);
		waterhome2top.setVisible(false);
		waterhome2left.setVisible(false);
		waterhome2right.setVisible(false);
		waterroad0.setVisible(false);
		waterroad1.setVisible(false);
		waterroad2.setVisible(false);
		waterroad3.setVisible(false);
		waterroad4.setVisible(false);
		waterroad5.setVisible(false);
		waterroad6.setVisible(false);
		waterroad7.setVisible(false);
		waterroad8.setVisible(false);
		waterroad9.setVisible(false);
		waterroad10.setVisible(false);

		windhome3.setVisible(false);
		windhome2top.setVisible(false);
		windhome2left.setVisible(false);
		windhome2right.setVisible(false);
		windroad0.setVisible(false);
		windroad1.setVisible(false);
		windroad2.setVisible(false);
		windroad3.setVisible(false);
		windroad4.setVisible(false);
		windroad5.setVisible(false);
		windroad6.setVisible(false);
		windroad7.setVisible(false);
		windroad8.setVisible(false);
		windroad9.setVisible(false);
		windroad10.setVisible(false);

		setPriestVisible(waterroad2, "red");
	}

	@FXML
	private void closeButtonClicked(ActionEvent event) {
		GameplayController.cultBoardStage.close();
	}

	@FXML
	private void setPriestVisible(Circle priest, String color) {

		switch(color) {
			case "green":
				priest.fillProperty().bind(Bindings.createObjectBinding(() -> Color.GREEN));
				priest.setVisible(true);
				break;
			case "yellow":
				priest.fillProperty().bind(Bindings.createObjectBinding(() -> Color.YELLOW));
				priest.setVisible(true);
				break;
			case "blue":
				priest.fillProperty().bind(Bindings.createObjectBinding(() -> Color.BLUE));
				priest.setVisible(true);
				break;
			case "brown":
				priest.fillProperty().bind(Bindings.createObjectBinding(() -> Color.BROWN));
			case "red":
				priest.fillProperty().bind(Bindings.createObjectBinding(() -> Color.RED));
				priest.setVisible(true);
				break;
			case "black":
				priest.fillProperty().bind(Bindings.createObjectBinding(() -> Color.BLACK));
				priest.setVisible(true);
				break;
			case "gray":
				priest.fillProperty().bind(Bindings.createObjectBinding(() -> Color.GRAY));
				priest.setVisible(true);
				break;
			default:
				priest.setVisible(false);
				break;
		}


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