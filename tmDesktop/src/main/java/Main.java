import GameLogic.*;
import UI.GameUI;
import UI.NewGameController;
import javafx.fxml.FXMLLoader;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws MalformedURLException {
        GameUI ui = new GameUI();
        ui.main(args);
        
        final int NUMBER_OF_ROUNDS = 6;
        int numberOfPlayers = 2;
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Faction> factions = new ArrayList<>();

        GameHandler gh = new GameHandler();
        // Create the Players
        players.add(new Player(1, "Ata"));
        players.add(new Player(2, "Zeynep"));
        System.out.println("Created the players with name " + players.get(0).getName());
        System.out.println("Created the players with name " + players.get(1).getName());

        // Create the Factions
        for (int i = 0; i < numberOfPlayers; i++) {
            int factionID = i;
            switch (factionID) {
                case 0: // Alchemists
                    Alchemists a = new Alchemists();
                    System.out.println("Created an Alchemist");
                    factions.add(a);
                    break;
                case 1: // Witches
                    Witches w = new Witches();
                    System.out.println("Created an Witch");
                    factions.add(w);
                    break;
            }
        }

        gh.createGame(numberOfPlayers, players, factions);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(players.get(i).getName() + " has " + players.get(i).getFaction().getAsset());
        }
        // Execute setup Phase
        gh.executeSetupPhase();
        // Play the game
        for(int i = 0; i < NUMBER_OF_ROUNDS; i++){
            gh.executeIncomePhase();
            //gh.executeActionPhase();
            //gh.executeCleanupPhase();
        }
        Player winner = gh.declareWinner();
        System.out.println(winner.getName() + "WON THE GAME WITH " + winner.getVictoryPoints() + " VP!");
    }
}
