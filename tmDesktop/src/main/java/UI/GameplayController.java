package UI;

import GameLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.LightBase;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.shape.Shape;

import javax.print.attribute.standard.Media;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

public class GameplayController<MediaPlayer> implements Initializable {

	public static BonusCardController bonusCardController;
	public static PowerActionController powerActionController;
	public static TownTileController townTileController;
	public static FavorTileController favorTileController;

	public static Stage cultBoardStage;
	public static Stage favorTileStage;
	public static Stage roundTileStage;
	public static Stage actionChooseStage;
	public static Stage bonusCardStage;
	public static Stage townTileStage;
	public static Stage powerActionStage;

	public static Stage firstActStage;
	public static Stage incomePhaseStage;
	public static Stage actionPhaseStage;

	@FXML public Button backButton;
	@FXML public Button cultBoardButton;
	@FXML Group mapGroup;

	private KeyCombination fullScreenExitKeyCombination;

	static int placeDwellingButtonCounter = 0;
	static boolean isPlaceDwellingPhaseOver;

	//**Player Panes
	@FXML public AnchorPane player1Pane;
	@FXML public AnchorPane player2Pane;
	@FXML public AnchorPane player3Pane;
	@FXML public AnchorPane player4Pane;
	@FXML public AnchorPane player5Pane;

	//******labels
	@FXML public Label name1Label;
	@FXML public Label faction1Label;
	@FXML public Label name2Label;
	@FXML public Label faction2Label;
	@FXML public Label name3Label;
	@FXML public Label faction3Label;
	@FXML public Label name4Label;
	@FXML public Label faction4Label;
	@FXML public Label name5Label;
	@FXML public Label faction5Label;
	@FXML public Label coin1;
	@FXML public Label coin2;
	@FXML public Label coin3;
	@FXML public Label coin4;
	@FXML public Label coin5;
	@FXML public Label worker1;
	@FXML public Label worker2;
	@FXML public Label worker3;
	@FXML public Label worker4;
	@FXML public Label worker5;
	@FXML public Label shipping1;
	@FXML public Label shipping2;
	@FXML public Label shipping3;
	@FXML public Label shipping4;
	@FXML public Label shipping5;
	@FXML public Label spade1;
	@FXML public Label spade2;
	@FXML public Label spade3;
	@FXML public Label spade4;
	@FXML public Label spade5;
	@FXML public Label power11;
	@FXML public Label power12;
	@FXML public Label power13;
	@FXML public Label power21;
	@FXML public Label power22;
	@FXML public Label power23;
	@FXML public Label power31;
	@FXML public Label power32;
	@FXML public Label power33;
	@FXML public Label power41;
	@FXML public Label power42;
	@FXML public Label power43;
	@FXML public Label power51;
	@FXML public Label power52;
	@FXML public Label power53;
	@FXML public Label dweling2;
	@FXML public Label dweling4;
	@FXML public Label trading2;
	@FXML public Label trading4;
	@FXML public Label temple2;
	@FXML public Label temple4;
	@FXML public Label sanctuary2;
	@FXML public Label sanctuary4;
	@FXML public Label stronghold2;
	@FXML public Label stronghold4;
	@FXML public Label victory2;
	@FXML public Label victory4;
	//******

	public static boolean isPlaceDwellingButtonClicked;

	//Instances for Hexagon Map
	private final static double r = 36; // the inner radius from hexagon center to outer corner
	private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
	private final static double TILE_HEIGHT = 2 * r;
	private final static double TILE_WIDTH = 2 * n;
	public static Tile[][] tileArr = new Tile[9][13];

	public static Group[][] structureGroup = new Group[9][13];

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
	private void powerActionsButtonClicked(ActionEvent event) throws Throwable {
		powerActionStage.showAndWait();
	}

	@FXML
	private void cultBoardButtonClicked(ActionEvent event) throws IOException {
		cultBoardStage.showAndWait();
	}

	@FXML
	public void bonusCardButtonClicked(ActionEvent event) throws IOException {
		bonusCardStage.show();
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
		townTileController.select0.setVisible(false);
		townTileController.select1.setVisible(false);
		townTileController.select2.setVisible(false);
		townTileController.select3.setVisible(false);
		townTileController.select4.setVisible(false);
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
				tileArr[y][x].tileX = y;
				tileArr[y][x].tileY = x;
				tile.setFill(Color.rgb(200, 250, 248));
				if (x == 12) {
					if (y == 1 || y == 3 || y == 5 || y == 7)
						tile.setVisible(false);
				}
				tileMap.getChildren().add(tile);

				//*******index 0 DWELLING - 1 for TRADING HOUSE - 2 TEMPLE- 3 SANCTUARY - 4 STRONGHOLD*******
				//Dwelling - Tiny Rectangle
				Rectangle dwelling = new Rectangle();
				dwelling.setX(xCoord+12);
				dwelling.setY(yCoord+10);
				dwelling.setWidth(35);
				dwelling.setHeight(15);
				dwelling.setArcWidth(1);
				dwelling.setArcHeight(1);
				dwelling.setVisible(false);

				//Trading House - Triangle
				Polygon tradingHouse = new Polygon();
				tradingHouse.getPoints().addAll(new Double[]{
						xCoord + 30.0, yCoord,
						xCoord + 45.0, yCoord + 27.0,
						xCoord + 15.0, yCoord + 27.0 });
				tradingHouse.setVisible(false);

				//Temple - Circle
				Circle temple = new Circle(xCoord + 30, yCoord + 20, 15.f);
				temple.setVisible(false);

				//Sanctuary
				Rectangle sanctuary = new Rectangle();
				sanctuary.setX(xCoord+10);
				sanctuary.setY(yCoord+10);
				sanctuary.setWidth(40);
				sanctuary.setHeight(22);
				sanctuary.setArcWidth(25);
				sanctuary.setArcHeight(25);
				sanctuary.setVisible(false);

				//Stronghold
				Rectangle stronghold = new Rectangle();
				stronghold.setX(xCoord+20);
				stronghold.setY(yCoord+10);
				stronghold.setWidth(21);
				stronghold.setHeight(21);
				stronghold.setArcWidth(1);
				stronghold.setArcHeight(1);
				stronghold.setVisible(false);

				// create a Group
				Group group = new Group(dwelling);
				group.getChildren().add(temple);
				group.getChildren().add(tradingHouse);
				group.getChildren().add(sanctuary);
				group.getChildren().add(stronghold);

				//Modify for map
				if (x == 12) {
					if (y == 1 || y == 3 || y == 5 || y == 7)
						group.setVisible(false);
				}
				tileMap.getChildren().add(group);
				structureGroup[y][x] = group; //GROUP FOR BUILDINGS ****
				//	structureGroup[y][x].getChildren().get(0).setVisible(true);

			}
		}

		for(int x = 0; x < 9; x++) {
			for (int y = 0; y < 13; y++) {
				if (x == 0) {
					if (y == 0 || y == 6)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					else if (y == 1)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					else if (y == 2 || y == 9)
						tileArr[x][y].setFill(Color.rgb(95, 145, 25)); //green
					else if (y == 3 || y == 10)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					else if (y == 4)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					else if (y == 5 || y == 8 || y == 11)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					else if (y == 7 || y == 12)
						tileArr[x][y].setFill(Color.rgb(86, 86, 63)); //dark grey
					else
						tileArr[x][y].isRiver = true;
				}
				if(x == 1){
					if(y == 3)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					else if(y == 0 || y == 7 || y == 11 )
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					else if(y == 4 || y == 8)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
					else
						tileArr[x][y].isRiver = true;
				}

				if(x == 2){
					if(y == 4 || y == 10)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					else if(y == 6 || y == 8)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					else if(y == 2)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
					else
						tileArr[x][y].isRiver = true;
				}

				if(x == 3){
					if(y == 11)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					else if(y == 0)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					else if(y == 1 || y == 6)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					else if(y == 2)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					else if(y == 5 || y == 8 || y == 10)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					else
						tileArr[x][y].isRiver = true;
				}

				if(x == 4){
					if(y == 1 || y == 5)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					else if(y == 6)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					else if(y == 10)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					else if(y == 3 || y == 12)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					else if(y == 7)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					else if(y == 2)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					else if(y == 0 || y == 4 || y == 11)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
					else
						tileArr[x][y].isRiver = true;
				}

				if(x == 5){
					if(y == 9 || y == 11)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					else if(y == 0 || y == 10)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					else if(y == 1 ||y == 5)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					else if(y == 4)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					else
						tileArr[x][y].isRiver = true;
				}

				if(x == 6){
					if(y == 3)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					else if(y == 7)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					else if(y == 11)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					else if(y == 12)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					else if(y == 5)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					else if(y == 10)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
					else
						tileArr[x][y].isRiver = true;
				}

				if(x == 7){
					if(y == 2 || y == 10)
						tileArr[x][y].setFill(Color.rgb(166, 127, 119)); //brown
					else if( y == 9 || y == 11)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					else if(y == 1 || y == 6)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					else if(y == 0)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					else if(y == 7)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
					else
						tileArr[x][y].isRiver = true;
				}

				if(x == 8){
					if(y == 2 || y == 8)
						tileArr[x][y].setFill(Color.rgb(191, 191, 191)); //grey
					else if(y == 5 || y == 11)
						tileArr[x][y].setFill(Color.rgb(95,145,25)); //green
					else if(y == 3 || y == 10)
						tileArr[x][y].setFill(Color.rgb(4, 150, 176)); //blue
					else if(y == 6)
						tileArr[x][y].setFill(Color.rgb(252, 252, 75)); //yellow
					else if(y == 0 || y == 4 || y == 7 || y == 12)
						tileArr[x][y].setFill(Color.rgb(235, 0, 31)); //red
					else if(y == 1)
						tileArr[x][y].setFill(Color.rgb(86,86,63)); //dark grey
					else
						tileArr[x][y].isRiver = true;
				}
			}
		}
		//	adjustStructure(true, 7, 7 , Structure.DWELLING, Color.CYAN ); //Example Usage
		return tileMap;
	}

	//*********HELPER METHOD FOR STRUCTURES*******
	public static void adjustStructure(boolean visible, int x, int y, Structure s){ //TerrainType t
		for(int i = 0; i < 5; i++)
			structureGroup[x][y].getChildren().get(i).setVisible(false);

		/*
		Color color;
		switch(t) {
			case PLAINS:
				color = Color.rgb(166, 127, 119); //brown
			case LAKES:
				color = Color.rgb(4, 150, 176); //blue
			case FOREST:
				color = Color.GREEN; //green
			case SWAMP:
				color = Color.rgb(86, 86, 63); //dark grey
			case MOUNTAINS:
				color = Color.rgb(191, 191, 191); //grey
			case WASTELAND:
				color = Color.rgb(235, 0, 31); //red
			case DESERT:
				color = Color.rgb(252, 252, 75); //yellow
			default:
				color = Color.rgb(255,255,255); //white

		}
		*/

		//DropShadow ds = new DropShadow(15, Color.DARKGREEN);

		if(!visible){
			return;
		}

		if(s == Structure.DWELLING){
			structureGroup[x][y].getChildren().get(0).setVisible(true);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setFill(color);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStrokeWidth(1);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStroke(Color.BLACK);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setEffect(ds);
		}
		else if(s == Structure.TRADINGPOST){
			structureGroup[x][y].getChildren().get(1).setVisible(true);
			//((Polygon)(structureGroup[y][x].getChildren().get(1))).setFill(color);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStrokeWidth(1);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStroke(Color.BLACK);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setEffect(ds);
		}
		else if(s == Structure.TEMPLE){
			structureGroup[x][y].getChildren().get(2).setVisible(true);
			//((Circle)(structureGroup[y][x].getChildren().get(2))).setFill(color);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStrokeWidth(1);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStroke(Color.BLACK);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setEffect(ds);
		}
		else if(s == Structure.SANCTUARY){
			structureGroup[x][y].getChildren().get(3).setVisible(true);
			//((Rectangle)(structureGroup[y][x].getChildren().get(3))).setFill(color);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStrokeWidth(1);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStroke(Color.BLACK);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setEffect(ds);
		}
		else if(s == Structure.STRONGHOLD){
			structureGroup[x][y].getChildren().get(4).setVisible(true);
			//((Rectangle)(structureGroup[y][x].getChildren().get(4))).setFill(color);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStrokeWidth(1);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setStroke(Color.BLACK);
			//((Rectangle)(structureGroup[y][x].getChildren().get(0))).setEffect(ds);
		}


	}

	//**********************************


	public static class Tile extends Polygon { //was private, Olcay made it public

		public int tileX;
		public int tileY;
		public boolean isRiver;

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
		}

		void setGlow() {
			if(!isRiver){
				Glow glow = new Glow();
				glow.setLevel(5);
				this.setEffect(glow);
			}
		}
	}




	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setStagesToInitializeGame();


		//this part from now on follows the game-play flow.
		isPlaceDwellingPhaseOver = false; //newly put at 13.56 on 18 may, Olcay put here


	}

	//########################UPDATE LABELS##############################
	public void updateLabels(){
		GameHandler gh = GameHandler.getInstance();
		if (NewGameController.playerNumber == 2) {
			coin2.setText("" + (gh.getPlayers().get(0).getFaction().getAsset().getCoin()));
			coin4.setText("" + (gh.getPlayers().get(1).getFaction().getAsset().getCoin()));
			worker2.setText("" + (gh.getPlayers().get(0).getFaction().getAsset().getWorker()));
			worker4.setText("" + (gh.getPlayers().get(1).getFaction().getAsset().getWorker()));
			shipping2.setText("" + (gh.getPlayers().get(0).getFaction().getShippingLevel()));
			shipping4.setText("" + (gh.getPlayers().get(1).getFaction().getShippingLevel()));
			spade2.setText("" + (gh.getPlayers().get(0).getFaction().getSpadeLevel()));
			spade4.setText("" + (gh.getPlayers().get(1).getFaction().getSpadeLevel()));
			power21.setText("" + (gh.getPlayers().get(0).getFaction().getPowerBowl()[0]));
			power22.setText("" + (gh.getPlayers().get(0).getFaction().getPowerBowl()[1]));
			power23.setText("" + (gh.getPlayers().get(0).getFaction().getPowerBowl()[2]));
			power41.setText("" + (gh.getPlayers().get(1).getFaction().getPowerBowl()[0]));
			power42.setText("" + (gh.getPlayers().get(1).getFaction().getPowerBowl()[1]));
			power43.setText("" + (gh.getPlayers().get(1).getFaction().getPowerBowl()[2]));
			dweling2.setText("" + (gh.getPlayers().get(0).getNumberOfStructures(Structure.DWELLING)));
			dweling4.setText("" + (gh.getPlayers().get(1).getNumberOfStructures(Structure.DWELLING)));
			trading2.setText("" + (gh.getPlayers().get(0).getNumberOfStructures(Structure.TRADINGPOST)));
			trading4.setText("" + (gh.getPlayers().get(1).getNumberOfStructures(Structure.TRADINGPOST)));
			temple2.setText("" + (gh.getPlayers().get(0).getNumberOfStructures(Structure.TEMPLE)));
			temple4.setText("" + (gh.getPlayers().get(1).getNumberOfStructures(Structure.TEMPLE)));
			sanctuary2.setText("" + (gh.getPlayers().get(0).getNumberOfStructures(Structure.SANCTUARY)));
			sanctuary4.setText("" + (gh.getPlayers().get(1).getNumberOfStructures(Structure.SANCTUARY)));
			stronghold2.setText("" + (gh.getPlayers().get(0).getNumberOfStructures(Structure.STRONGHOLD)));
			stronghold4.setText("" + (gh.getPlayers().get(1).getNumberOfStructures(Structure.STRONGHOLD)));
			victory2.setText("" + (gh.getPlayers().get(0).getVictoryPoints()));
			victory4.setText("" + (gh.getPlayers().get(0).getVictoryPoints()));

		} else if (NewGameController.playerNumber == 3) {
			coin1.setText("" + (gh.getPlayers().get(0).getFaction().getAsset().getCoin()));
			worker1.setText("" + (gh.getPlayers().get(0).getFaction().getAsset().getWorker()));
			coin3.setText("" + (gh.getPlayers().get(1).getFaction().getAsset().getCoin()));
			worker3.setText("" + (gh.getPlayers().get(1).getFaction().getAsset().getWorker()));
			coin5.setText("" + (gh.getPlayers().get(2).getFaction().getAsset().getCoin()));
			worker5.setText("" + (gh.getPlayers().get(2).getFaction().getAsset().getWorker()));

		} else if (NewGameController.playerNumber == 4){
			coin1.setText("" + (gh.getPlayers().get(0).getFaction().getAsset().getCoin()));
			worker1.setText("" + (gh.getPlayers().get(0).getFaction().getAsset().getWorker()));
			coin2.setText("" + (gh.getPlayers().get(1).getFaction().getAsset().getCoin()));
			worker2.setText("" + (gh.getPlayers().get(1).getFaction().getAsset().getWorker()));
			coin3.setText("" + (gh.getPlayers().get(2).getFaction().getAsset().getCoin()));
			worker3.setText("" + (gh.getPlayers().get(2).getFaction().getAsset().getWorker()));
			coin4.setText("" + (gh.getPlayers().get(3).getFaction().getAsset().getCoin()));
			worker4.setText("" + (gh.getPlayers().get(3).getFaction().getAsset().getWorker()));

		}else if (NewGameController.playerNumber == 5){
			coin1.setText("" + (gh.getPlayers().get(0).getFaction().getAsset().getCoin()));
			worker1.setText("" + (gh.getPlayers().get(0).getFaction().getAsset().getWorker()));
			coin2.setText("" + (gh.getPlayers().get(1).getFaction().getAsset().getCoin()));
			worker2.setText("" + (gh.getPlayers().get(1).getFaction().getAsset().getWorker()));
			coin3.setText("" + (gh.getPlayers().get(2).getFaction().getAsset().getCoin()));
			worker3.setText("" + (gh.getPlayers().get(2).getFaction().getAsset().getWorker()));
			coin4.setText("" + (gh.getPlayers().get(3).getFaction().getAsset().getCoin()));
			worker4.setText("" + (gh.getPlayers().get(3).getFaction().getAsset().getWorker()));
			coin5.setText("" + (gh.getPlayers().get(4).getFaction().getAsset().getCoin()));
			worker5.setText("" + (gh.getPlayers().get(4).getFaction().getAsset().getWorker()));
		}
	}
	//###########################################################




	private void setStagesToInitializeGame() {
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

		bonusCardController = loader.getController();

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
		favorTileController = loader3.getController();
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
		townTileController = loader4.getController();

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

		GameHandler gh = GameHandler.getInstance();
		if (NewGameController.playerNumber == 2) {
			player1Pane.setVisible(false);
			player3Pane.setVisible(false);
			player5Pane.setVisible(false);
			//**
			name2Label.setText(gh.getPlayers().get(0).getName());
			faction2Label.setText(gh.getPlayers().get(0).getFaction().getName());
			name4Label.setText(gh.getPlayers().get(1).getName());
			faction4Label.setText(gh.getPlayers().get(1).getFaction().getName());

		} else if (NewGameController.playerNumber == 3) {
			player2Pane.setVisible(false);
			player4Pane.setVisible(false);
			//**
			name1Label.setText(gh.getPlayers().get(0).getName());
			faction1Label.setText(gh.getPlayers().get(0).getFaction().getName());
			name3Label.setText(gh.getPlayers().get(1).getName());
			faction3Label.setText(gh.getPlayers().get(1).getFaction().getName());
			name5Label.setText(gh.getPlayers().get(2).getName());
			faction5Label.setText(gh.getPlayers().get(2).getFaction().getName());

		} else if (NewGameController.playerNumber == 4){
			player3Pane.setVisible(false);
			//**
			name1Label.setText(gh.getPlayers().get(0).getName());
			faction1Label.setText(gh.getPlayers().get(0).getFaction().getName());
			name2Label.setText(gh.getPlayers().get(1).getName());
			faction2Label.setText(gh.getPlayers().get(1).getFaction().getName());
			name3Label.setText(gh.getPlayers().get(2).getName());
			faction3Label.setText(gh.getPlayers().get(2).getFaction().getName());
			name4Label.setText(gh.getPlayers().get(3).getName());
			faction4Label.setText(gh.getPlayers().get(3).getFaction().getName());

		}else if (NewGameController.playerNumber == 5){
			//**
			name1Label.setText(gh.getPlayers().get(0).getName());
			faction1Label.setText(gh.getPlayers().get(0).getFaction().getName());
			name2Label.setText(gh.getPlayers().get(1).getName());
			faction2Label.setText(gh.getPlayers().get(1).getFaction().getName());
			name3Label.setText(gh.getPlayers().get(2).getName());
			faction3Label.setText(gh.getPlayers().get(2).getFaction().getName());
			name4Label.setText(gh.getPlayers().get(3).getName());
			faction4Label.setText(gh.getPlayers().get(3).getFaction().getName());
			name5Label.setText(gh.getPlayers().get(4).getName());
			faction5Label.setText(gh.getPlayers().get(4).getFaction().getName());
		}

		FXMLLoader loader6 = new FXMLLoader();
		try {
			loader6.setLocation((new java.io.File("src/main/java/UI/view/PowerAction.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene6 = null;
		try {
			scene6 = new Scene(loader6.load());
		} catch (IOException e) {
			e.printStackTrace();
		}
		powerActionStage = new Stage();
		powerActionStage.setScene(scene6);
		powerActionStage.setHeight(400);
		powerActionStage.setWidth(600);
		powerActionStage.initStyle(StageStyle.UNDECORATED);
		powerActionStage.initOwner(GameUI.stage);
		powerActionStage.initModality(Modality.APPLICATION_MODAL);

		powerActionController = loader6.getController();

		//********

		FXMLLoader loader7 = new FXMLLoader();
		try {
			loader7.setLocation((new java.io.File("src/main/java/UI/view/IncomePhase.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene7 = null;
		try {
			scene7 = new Scene(loader7.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		incomePhaseStage = new Stage();
		incomePhaseStage.setScene(scene7);
		incomePhaseStage.setHeight(400);
		incomePhaseStage.setWidth(755);
		incomePhaseStage.initStyle(StageStyle.UNDECORATED);
		incomePhaseStage.initOwner(GameUI.stage);
		incomePhaseStage.initModality(Modality.APPLICATION_MODAL);
		//incomePhaseStage.show();

		FXMLLoader loader8 = new FXMLLoader();
		try {
			loader8.setLocation((new java.io.File("src/main/java/UI/view/firstAct.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene8 = null;
		try {
			scene8 = new Scene(loader8.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		firstActStage = new Stage();
		firstActStage.setScene(scene8);
		firstActStage.setHeight(450);
		firstActStage.setWidth(700);
		firstActStage.initStyle(StageStyle.UNDECORATED);
		firstActStage.initOwner(GameUI.stage);
		firstActStage.initModality(Modality.APPLICATION_MODAL);
		firstActStage.show();

		//*************
		FXMLLoader loader9 = new FXMLLoader();
		try {
			loader9.setLocation((new java.io.File("src/main/java/UI/view/ActionPhase.fxml")).toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		Scene scene9 = null;
		try {
			scene9 = new Scene(loader9.load());
		} catch (IOException e) {
			e.printStackTrace();
		}

		actionPhaseStage = new Stage();
		actionPhaseStage.setScene(scene9);
		actionPhaseStage.setHeight(500);
		actionPhaseStage.setWidth(755);
		actionPhaseStage.initStyle(StageStyle.UNDECORATED);
		actionPhaseStage.initOwner(GameUI.stage);
		actionPhaseStage.initModality(Modality.APPLICATION_MODAL);

		updateLabels();




	}
}