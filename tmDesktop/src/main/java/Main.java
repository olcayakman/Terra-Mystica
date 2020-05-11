import UI.GameUI;
import GameLogic.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int numberOfPlayers = 1;
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Faction> factions = new ArrayList<>();

        GameHandler gh = new GameHandler();
        // Create the Players 
        for(int i = 0; i < numberOfPlayers; i++){
            int playerID = i;
            String name = "Ata";
            players.add(new Player(playerID, name));
        }
        System.out.println("Created the players with name " + players.get(0).getName());

        // Create the Factions
        for(int i = 0; i < numberOfPlayers; i++){
            int factionID = 1;
            switch (factionID){
                case 1: // Witches 
                    Alchemists a = new Alchemists();
                    System.out.println("Created an Alchemist");
                    factions.add(a);
                    break;
            }
        }
        
        gh.createGame(numberOfPlayers, players, factions);
            for(int i = 0; i < numberOfPlayers; i++){
                System.out.println(players.get(i).getName() + " has " + players.get(i).getFaction().getAsset());
            }
        gh.executeActionPhase();
    }

}
