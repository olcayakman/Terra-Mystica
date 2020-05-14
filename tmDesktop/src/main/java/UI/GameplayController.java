package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameplayController  implements Initializable {

	public static Stage cultBoardStage;
	public static Stage bonusCardStage;
	public static Stage favorTileStage;

	@FXML
	public Button backButton;
	@FXML
	public Button cultBoardButton;

	@FXML
	Group mapRoot;

	private KeyCombination fullScreenExitKeyCombination;

	//Instances for Hexagon Map
	private final static double r = 36; // the inner radius from hexagon center to outer corner
	private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
	private final static double TILE_HEIGHT = 2 * r;
	private final static double TILE_WIDTH = 2 * n;

	public GameplayController() {
	}


	@FXML
	private void backButtonClicked(ActionEvent event) throws Throwable {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/MainMenu.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());
		GameUI.stage.setFullScreenExitKeyCombination(fullScreenExitKeyCombination);
		GameUI.stage.setScene(scene);
		GameUI.stage.setFullScreen(true);
	}

	@FXML
	private void cultBoardButtonClicked(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/CultBoard.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		cultBoardStage = new Stage();
		cultBoardStage.setScene(scene);
		cultBoardStage.setHeight(750);
		cultBoardStage.setWidth(750);
		cultBoardStage.initStyle(StageStyle.UNDECORATED);
		cultBoardStage.initOwner(primaryStage);
		cultBoardStage.initModality(Modality.APPLICATION_MODAL);
		cultBoardStage.showAndWait();
	}

	@FXML
	private void bonusCardButtonClicked(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/BonusCard.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		bonusCardStage = new Stage();
		bonusCardStage.setScene(scene);
		bonusCardStage.setHeight(466);
		bonusCardStage.setWidth(1103);
		bonusCardStage.initStyle(StageStyle.UNDECORATED);
		bonusCardStage.initOwner(primaryStage);
		bonusCardStage.initModality(Modality.APPLICATION_MODAL);
		bonusCardStage.showAndWait();
	}
	@FXML
	private void favorTileButtonClicked(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/FavorTile.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		favorTileStage = new Stage();
		favorTileStage.setScene(scene);
		favorTileStage.setHeight(400);
		favorTileStage.setWidth(600);
		favorTileStage.initStyle(StageStyle.UNDECORATED);
		favorTileStage.initOwner(primaryStage);
		favorTileStage.initModality(Modality.APPLICATION_MODAL);
		favorTileStage.showAndWait();
	}



	public static AnchorPane createMap() {

		AnchorPane tileMap = new AnchorPane();
		Tile[][] tileArr = new Tile[9][13];
		int rowCount = 9; // how many rows of tiles should be created
		int tilesPerRow = 13; // the amount of tiles that are contained in each row
		int xStartOffset = 300; // offsets the entire field to the right
		int yStartOffset = 100; // offsets the entire fields downwards

		for (int x = 0; x < tilesPerRow; x++) {
			for (int y = 0; y < rowCount; y++) {
				double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
				double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
				Polygon tile = new Tile(xCoord, yCoord);
				tileArr[y][x] = (Tile) tile;
				tile.setFill(Color.WHITE);
				if (x == 12) {
					if (y == 1 || y == 3 || y == 5 || y == 7)
						tile.setVisible(false);
				}
				tileMap.getChildren().add(tile);
			}
		}
		return tileMap;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullScreenExitKeyCombination = GameUI.stage.getFullScreenExitKeyCombination();
		GameUI.stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
	}


	private static class Tile extends Polygon {

		Tile(double x, double y) {
			// creates the polygon using the corner coordinates
			getPoints().addAll(
					x, y,
					x, y + r,
					x + n, y + r * 1.5,
					x + TILE_WIDTH, y + r,
					x + TILE_WIDTH, y,
					x + n, y - r * 0.5
			);

			setStrokeWidth(1);
			setStroke(Color.BLACK);
			setOnMouseClicked(e -> System.out.println("Clicked: " + this));
		}

	}
}