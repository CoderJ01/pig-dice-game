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

        // continue the game while all the players have less than 100 points
        while(gameOver() == false) {
            for(int i = 0; i < players.size(); i++) {
                players.get(i).determinePoints(players.get(i).rollFirstDice(), players.get(i).rollSecondDice());
                players.get(i).getPoints();

                if(players.get(i).getPoints() >= 100) {
                    break;
                }
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
            System.out.println("Player " + i + " (" + player.getName() + ") has " + player.getPoints() + " points");
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

    private static boolean gameOver() {
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).getPoints() < 100) {
                return false;
            }
        }
        return true;
    }
}