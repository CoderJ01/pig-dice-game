import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    // array of players
    private static List<Player> players = new ArrayList<>();
    public static void main(String[] args) {
        // players
        Player player1 = new Player("Joshua");
        CPU player2 = new CPU("CPU_1");
        CPU player3 = new CPU("CPU_2");
        CPU player4 = new CPU("CPU_3");

        // add players to list
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        // continue the game while all the players have less than 100 points
        while(player1.getPoints() < 100 && player2.getPoints() < 100 && player3.getPoints() < 100 && player4.getPoints() < 100) {
            // playable character
            int a = player1.rollFirstDice();
            int b = player1.rollSecondDice();
            player1.determinePoints(a, b);
            player1.getPoints();

            if(player1.getPoints() >= 100) {
                break;
            }

            // CPU 1
            int c = player2.rollFirstDice();
            int d = player2.rollSecondDice();
            player2.determinePoints(c, d);
            player2.getPoints();

            if(player2.getPoints() >= 100) {
                break;
            }

            // CPU 2
            int e = player3.rollFirstDice();
            int f = player3.rollSecondDice();
            player3.determinePoints(e, f);
            player3.getPoints();

            if(player3.getPoints() >= 100) {
                break;
            }

            // CPU 3
            int g = player4.rollFirstDice();
            int h = player4.rollSecondDice();
            player4.determinePoints(g, h);
            player4.getPoints();

            if(player4.getPoints() >= 100) {
                break;
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
}