package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameplayController  implements Initializable {

	public static Stage cultBoardStage;
	public static Stage favorTileStage;
	public static Stage roundTileStage;
	public static Stage actionChooseStage;
	public static Stage bonusCardStage;
	public static Stage townTileStage;

	@FXML public Button backButton;
	@FXML public Button cultBoardButton;

	@FXML Group mapGroup;

	private KeyCombination fullScreenExitKeyCombination;

	//**Player Panes
	@FXML public AnchorPane player1Pane;
	@FXML public AnchorPane player2Pane;
	@FXML public AnchorPane player3Pane;
	@FXML public AnchorPane player4Pane;
	@FXML public AnchorPane player5Pane;

	//Instances for Hexagon Map
	private final static double r = 36; // the inner radius from hexagon center to outer corner
	private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
	private final static double TILE_HEIGHT = 2 * r;
	private final static double TILE_WIDTH = 2 * n;
	public static Tile[][] tileArr = new Tile[9][13];

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
		cultBoardStage.showAndWait();
	}

	@FXML
	public void bonusCardButtonClicked(ActionEvent event) throws IOException {
		bonusCardStage.showAndWait();
	}


	@FXML
	private void favorTileButtonClicked(ActionEvent event) throws IOException {
		favorTileStage.showAndWait();
	}

	@FXML
	private void actionChooseButtonClicked(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation((new java.io.File("src/main/java/UI/view/ActionChoose.fxml")).toURI().toURL());
		Scene scene = new Scene(loader.load());

		Stage primaryStage = GameUI.stage;
		actionChooseStage = new Stage();
		actionChooseStage.setScene(scene);
		actionChooseStage.setHeight(500);
		actionChooseStage.setWidth(755);
		actionChooseStage.initStyle(StageStyle.UNDECORATED);
		actionChooseStage.initOwner(primaryStage);
		actionChooseStage.initModality(Modality.APPLICATION_MODAL);
		actionChooseStage.showAndWait();
	}

	@FXML
	private void townTileButtonClicked(ActionEvent event) throws IOException {
		townTileStage.showAndWait();
	}

	@FXML
	private void roundCardButtonClicked(ActionEvent event) throws IOException {
		roundTileStage.showAndWait();
	}

	public static AnchorPane createMap() {
		AnchorPane tileMap = new AnchorPane();
		int rowCount = 9; // how many rows of tiles should be created
		int tilesPerRow = 13; // the amount of tiles that are contained in each row
		double xStartOffset = 30; // offsets the entire field to the right
		double yStartOffset = 30;// offsets the entire fields downwards

		for (int x = 0; x < tilesPerRow; x++) {
			for (int y = 0; y < rowCount; y++) {
				double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
				double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
				Polygon tile = new Tile(xCoord, yCoord);
				tileArr[y][x] = (Tile) tile;
				tile.setFill(Color.ANTIQUEWHITE);
				if (x == 12) {
					if (y == 1 || y == 3 || y == 5 || y == 7)
						tile.setVisible(false);
				}
				tileMap.getChildren().add(tile);
			}
		}
		//Adjusting starting state colors of the map
		for (int x = 0; x < tilesPerRow; x++) {
			for (int y = 0; y < rowCount; y++) {
				double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
				double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
				Polygon tile = new Tile(xCoord, yCoord);
				tileArr[y][x] = (Tile) tile;
				tile.setFill(Color. ANTIQUEWHITE);
				if (x == 12) {
					if (y == 1 || y == 3 || y == 5 || y == 7)
						tile.setVisible(false);
				}
				tileMap.getChildren().add(tile);
			}
		}
		for(int x = 0; x < 9; x++) {
			for (int y = 0; y < 13; y++) {
				if (x == 0) {
					if (y == 0 || y == 6)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if (y == 1)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if (y == 2 || y == 9)
						tileArr[x][y].setFill(Color.rgb(95, 145, 25)); //green
					if (y == 3 || y == 10)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if (y == 4)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if (y == 5 || y == 8 || y == 11)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					if (y == 7 || y == 12)
						tileArr[x][y].setFill(Color.rgb(86, 86, 63)); //dark grey
				}
				if(x == 1){
					if(y == 3)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if(y == 0 || y == 7 || y == 11 )
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 4 || y == 8)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 2){
					if(y == 4 || y == 10)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 6 || y == 8)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 2)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 3){
					if(y == 11)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if(y == 0)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 1 || y == 6)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 2)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 5 || y == 8 || y == 10)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
				}

				if(x == 4){
					if(y == 1 || y == 5)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if(y == 6)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 10)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 3 || y == 12)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 7)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 2)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					if(y == 0 || y == 4 || y == 11)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 5){
					if(y == 9 || y == 11)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if(y == 0 || y == 10)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 1 ||y == 5)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 4)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
				}

				if(x == 6){
					if(y == 3)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 7)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 11)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 12)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 5)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					if(y == 10)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 7){
					if(y == 2 || y == 10)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					if( y == 9 || y == 11)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 1 || y == 6)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 0)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 7)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
				}

				if(x == 8){
					if(y == 2 || y == 8)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					if(y == 5 || y == 11)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					if(y == 3 || y == 10)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					if(y == 6)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					if(y == 0 || y == 4 || y == 7 || y == 12)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					if(y == 1) {
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
					}
				}
			}
		}
		return tileMap;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		fullScreenExitKeyCombination = GameUI.stage.getFullScreenExitKeyCombination();
		GameUI.stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
		mapGroup.getChildren().add(createMap());

		////*********
		FXMLLoader loader = new FXMLLoader();
		try {
			loader.setLocation((new java.io.File("src/main/java/UI/view/BonusCard.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene = null;
		try {
			scene = new Scene(loader.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		bonusCardStage = new Stage();
		bonusCardStage.setScene(scene);
		bonusCardStage.setHeight(466);
		bonusCardStage.setWidth(1103);
		bonusCardStage.initStyle(StageStyle.UNDECORATED);
		bonusCardStage.initOwner(GameUI.stage);
		bonusCardStage.initModality(Modality.APPLICATION_MODAL);

		//******

		FXMLLoader loader2 = new FXMLLoader();
		try {
			loader2.setLocation((new java.io.File("src/main/java/UI/view/CultBoard.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene2 = null;
		try {
			scene2 = new Scene(loader2.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		cultBoardStage = new Stage();
		cultBoardStage.setScene(scene2);
		cultBoardStage.setHeight(750);
		cultBoardStage.setWidth(750);
		cultBoardStage.initStyle(StageStyle.UNDECORATED);
		cultBoardStage.initOwner(GameUI.stage);
		cultBoardStage.initModality(Modality.APPLICATION_MODAL);

		//********

		FXMLLoader loader3 = new FXMLLoader();
		try {
			loader3.setLocation((new java.io.File("src/main/java/UI/view/FavorTile.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene3 = null;
		try {
			scene3 = new Scene(loader3.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		favorTileStage = new Stage();
		favorTileStage.setScene(scene3);
		favorTileStage.setHeight(400);
		favorTileStage.setWidth(600);
		favorTileStage.initStyle(StageStyle.UNDECORATED);
		favorTileStage.initOwner(GameUI.stage);
		favorTileStage.initModality(Modality.APPLICATION_MODAL);

		//********

		FXMLLoader loader4 = new FXMLLoader();
		try {
			loader4.setLocation((new java.io.File("src/main/java/UI/view/TownTile.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene4 = null;
		try {
			scene4 = new Scene(loader4.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		townTileStage = new Stage();
		townTileStage.setScene(scene4);
		townTileStage.setHeight(300);
		townTileStage.setWidth(800);
		townTileStage.initStyle(StageStyle.UNDECORATED);
		townTileStage.initOwner(GameUI.stage);
		townTileStage.initModality(Modality.APPLICATION_MODAL);

		//*********

		FXMLLoader loader5 = new FXMLLoader();
		try {
			loader5.setLocation((new java.io.File("src/main/java/UI/view/RoundCard.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene5 = null;
		try {
			scene5 = new Scene(loader5.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		roundTileStage = new Stage();
		roundTileStage.setScene(scene5);
		roundTileStage.setHeight(600);
		roundTileStage.setWidth(600);
		roundTileStage.initStyle(StageStyle.UNDECORATED);
		roundTileStage.initOwner(GameUI.stage);
		roundTileStage.initModality(Modality.APPLICATION_MODAL);

		if(NewGameController.playerNumber == 2){
			player1Pane.setVisible(false);
			player3Pane.setVisible(false);
			player5Pane.setVisible(false);
		}
		else if(NewGameController.playerNumber == 3){
			player2Pane.setVisible(false);
			player4Pane.setVisible(false);
		}
		else if(NewGameController.playerNumber == 4)
			player3Pane.setVisible(false);
	}
}