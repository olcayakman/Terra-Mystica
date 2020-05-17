package com.TerraMystica.GameLogic;

import java.util.*;

import static java.lang.System.out;

public class GameController {
    static GameBoard gameBoard = GameBoard.getInstance();
    static Scanner scanner = new Scanner(System.in);

    public static Terrain readTerrain() {
        out.println("Please enter the location you want to terraform and build:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return (Terrain) gameBoard.getHexagon(row, col);
    }

    public static int readAction() {
        out.println("Please enter your preference for the action you want to perform:");
        out.println("[1]: Terraform and build");
        out.println("[8]: Pass");
        return scanner.nextInt();
    }

    public static void showStructures(Player player) {
        List<Terrain> result = new ArrayList<>();
        out.println("DWELLINGS: ");
        player.getDwellings().forEach(dwelling -> result.add(dwelling.getLocation()));
        showTerrains(result);
        out.println();
    }

    public static void showPlayer(Player player) {
        var resource = player.getResource();
        out.println("PLAYER " + player.getName());
        out.println("-----------------");
        out.println("RESOURCES: ");
        out.println("Worker: " + resource.getWorker() + " Coin: " + resource.getCoin() +
                " Priest: " + resource.getPriest() + " Power: " + resource.getPower() + " Spade: " + resource.getSpade());
        out.println();
        showStructures(player);
    }

    public static void showTerrains(Collection<Terrain> terrains) {
        out.println("         ROW\tCOL");
        for (var terrain : terrains) {
            out.println("Terrain: " + terrain.getRow() + "\t\t" + terrain.getCol());
        }
    }

    public static void showUnoccupiedTerrains(Player player) {
        out.println("Unoccupied Terrains");
        showTerrains(gameBoard.getUnoccupiedTerrains(player.getFaction().getTerrainType()));
    }

    public static void showAvailableTerrainsForTerraformAndBuild(Player player) {
        out.println("Available terrains for terraform and build");
        showTerrains(gameBoard.getAvailableTerrainsForTerraformAndBuild(player));
    }

    public static List<Player> createPlayers() {
        out.println("Please enter the number of players: ");
        int numberOfPlayers = scanner.nextInt();
        scanner.nextLine();

        List<Player> players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            Player player = new Player(new Witches());
            players.add(player);
        }

        for (int i = 0; i < numberOfPlayers; i++) {
            out.println("Enter the name of PLAYER " + (i+1));
            players.get(i).setName(scanner.nextLine());
        }

        return players;
    }

    public static void placeFirstStructures(List<Player> players) {
        for (var player : players) {
            showPlayer(player);
            out.println("BUILD YOUR INITIAL DWELLINGS");
            showUnoccupiedTerrains(player);
            out.println("Please enter the appropriate row and column number for DWELLING 1");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            player.addStructure(new Dwelling((Terrain) gameBoard.getHexagon(row, col)));

            out.println("Please enter the appropriate row and column number for DWELLING 2");
            row = scanner.nextInt();
            col = scanner.nextInt();

            player.addStructure(new Dwelling((Terrain) gameBoard.getHexagon(row, col)));
        }
    }

    public static void main(String[] args) {
        var players = createPlayers();
        placeFirstStructures(players);

        out.println("----------BEGINNING OF THE GAME----------");
        Game game = new Game(players);

        while (!game.isEndOfGame()) {
            game.initializeRound();
            game.executeIncomePhase();

            out.println("---ROUND " + game.getRound() + "---");

            while (!game.isEndOfActionPhase()){
                var currentPlayer = game.getCurrentPlayer();
                showPlayer(currentPlayer);

                var actionChoice = readAction();
                if (actionChoice == 1) {
                    showAvailableTerrainsForTerraformAndBuild(currentPlayer);
                    currentPlayer.terraformAndBuild(readTerrain());
                }
                else if (actionChoice == 8) {
                    game.pass();
                }

                game.nextTurn();
            }
        }

        out.println("----------END OF THE GAME----------");
    }
}
