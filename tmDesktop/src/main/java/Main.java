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
            System.out.println("Enter the ID of the faction you want");
            int factionID = 1;
            switch (factionID){
                case 1: // Witches 
                    Witches w = new Witches("Withces", TerrainType.MOUNTAINS, 0, new int[]{1,2,3}, 0, 
                        new int[]{0,1,2}, new int []{3, 6, 5}, new Asset(5,4,3));
                    System.out.println("Created a witch");
                    factions.add(w);
                    break;
            }
        }

        gh.createGame(numberOfPlayers, players, factions);
        gh.executeActionPhase();
    }

}
