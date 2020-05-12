import UI.GameUI;
import GameLogic.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
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
                    System.out.println("Created an Alchemist");
                    factions.add(w);
                    break;
            }
        }

        gh.createGame(numberOfPlayers, players, factions);
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println(players.get(i).getName() + " has " + players.get(i).getFaction().getAsset());
        }
        
        gh.executeSetupPhase();
        gh.executeActionPhase();
    }

}
