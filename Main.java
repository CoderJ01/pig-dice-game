import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // fields
    private static List<Player> players = new ArrayList<>(); // array of players
    private static Scanner input = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {

        // retrieve player's name
        String name = getPlayerName();
        int numberOfOpponents = opponents();

        // add players to list
        players.add(new Player(name));
        
        for(int i = 1; i <= numberOfOpponents; i++) {
            players.add(new CPU("CPU_" + i));
        }

        int i = rand.nextInt(players.size()); // first player to roll dice will be randomly determined
        int x = 0, y = 0;
        // loop through players (turns)
        while(true) {
            // ask player to roll the dice
            if(players.get(i).optionalRoll() == true) {
                x = players.get(i).rollFirstDie();
                y = players.get(i).rollSecondDie();
            }
            // player earns 0 points for skipping turn
            else {
                x = 0;
                y = 0;
            }
            // determine points player gets after roll
            players.get(i).determinePoints(x, y);
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

    // prompt non-CPU player for name
    private static String getPlayerName() {
        System.out.print("Enter your name: ");
        String name = input.next();
        return name;
    }

    // allow player to pick the number of opponents to play against
    private static int opponents() {
        int numberOfOpponents = 0;
        boolean error = false;
        int min = 1, max = 9;

        while(true) {
            do {
                error = false;
                try {
                    System.out.print("\nHow many opponents would you like to play against? Enter a number from " + min + " to " + max + ": ");
                    numberOfOpponents = input.nextInt();
                }
                // prevent user from entering wrong data type
                catch(InputMismatchException e) {
                    error = true;
                    input.nextLine();
                }
            } while(error);

            // check that integer is within proper range
            if(numberOfOpponents >= min && numberOfOpponents <= max) {
                break;
            }
        }
        return numberOfOpponents;
    }
}