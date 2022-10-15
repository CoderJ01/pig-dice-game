import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    // array of players
    private static List<Player> players = new ArrayList<>();

    public static void main(String[] args) {

        // add players to list
        players.add(new Player("Joshua"));
        players.add(new CPU("CPU_1"));
        players.add(new CPU("CPU_2"));
        players.add(new CPU("CPU_3"));
        players.add(new CPU("CPU_4"));
        players.add(new CPU("CPU_5"));

        // continue the game while all the players have less than 100 points
        int i = 0;
        while(true) {
            // loop through players (turns)
            players.get(i).determinePoints(players.get(i).rollFirstDice(), players.get(i).rollSecondDice());
            players.get(i).getPoints();

            // as soon as one of the players has a total of 100 points, end the game
            if(players.get(i).getPoints() >= 100) {
                break;
            }

            // loop only after break condition is checked
            if(i < (players.size() - 1)) {
                i++;
            }
            else {
                i = 0;
            }
        }
           
        listPlayers();
        rankPlayers();
    }

    // list the number of points each player has at the end of the game
    private static void listPlayers() {
        int i = 1;
        System.out.println("\nPOINTS");
        System.out.println("******");
        for (Player player : players) {
            System.out.println("Player " + i + " (" + player.getName() + ") scored a total of " + player.getPoints() + " points");
            i++;
        }
    }

    // rank players
    private static void rankPlayers() {
        // use collections
        Collections.sort(players);

        // print out ranks
        System.out.println("\nRANKS");
        System.out.println("*****");
        int i = 1;
        for(Player player : players) {
            System.out.println(i + ". " + player.getName());
            i++;
        }
    }
}