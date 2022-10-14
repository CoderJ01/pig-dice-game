import java.util.ArrayList;
import java.util.List;

public class Main {

    // array of players
    private static List<Player> players = new ArrayList<>();
    public static void main(String[] args) {
        // players
        Player joshua = new Player("Joshua");
        CPU CPU1 = new CPU("CPU_1");
        CPU CPU2 = new CPU("CPU_2");
        CPU CPU3 = new CPU("CPU_3");

        // add players to list
        players.add(joshua);
        players.add(CPU1);
        players.add(CPU2);
        players.add(CPU3);

        // continue the game while all the players have less than 100 points
        while(joshua.getPoints() < 100 && CPU1.getPoints() < 100 && CPU2.getPoints() < 100 && CPU3.getPoints() < 100) {
            // playable character
            int a = joshua.rollFirstDice();
            int b = joshua.rollSecondDice();
            joshua.determinePoints(a, b);
            joshua.getPoints();

            if(joshua.getPoints() >= 100) {
                break;
            }

            // CPU 1
            int c = CPU1.rollFirstDice();
            int d = CPU1.rollSecondDice();
            CPU1.determinePoints(c, d);
            CPU1.getPoints();

            if(CPU1.getPoints() >= 100) {
                break;
            }

            // CPU 2
            int e = CPU2.rollFirstDice();
            int f = CPU2.rollSecondDice();
            CPU2.determinePoints(e, f);
            CPU2.getPoints();

            if(CPU2.getPoints() >= 100) {
                break;
            }

            // CPU 3
            int g = CPU3.rollFirstDice();
            int h = CPU3.rollSecondDice();
            CPU3.determinePoints(g, h);
            CPU3.getPoints();

            if(CPU3.getPoints() >= 100) {
                break;
            }
        }

        listPlayers();
    }

    // list the number of points each player has at the end of the game
    private static void listPlayers() {
        int i = 1;
        System.out.println("\nPOINTS");
        System.out.println("******");
        for (Player player : players) {
            System.out.println("Player " + i + ": " + player.getName() + " | " + player.getPoints() + " points");
            i++;
        }
    }
}