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

        // inquire if player wants to view rules
        if(viewOrNo(name) == true) {
            gamePlay(); // describe rules of game
        }

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
        System.out.println("\nPOINTS");
        System.out.println("******");
        for (Player player : players) {
            System.out.println(player.getName() + " scored a total of " + player.getPoints() + " points");
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
            // check for correct data type
            do {
                error = false;
                try {
                    System.out.print("\nHow many opponents would you like to play against? Enter a number from " + min + " to " + max + ": ");
                    numberOfOpponents = input.nextInt();
                }
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

    // describe the rules if the game
    private static void gamePlay() {
        System.out.println("\nRULES");
        System.out.println("*****");
        System.out.println("The first player to reach 100 points wins the game. The amount of points a player scores is the");
        System.out.println("sum of the dice rolled. However, if a player rolls a 1, the player scores no points. If a player");
        System.out.println("rolls two 1's, the player loses all the points said player accumulated throughout the game.");
        System.out.println("\nIf a player rolls two different numbers, then said player may roll again. If a player rolls");
        System.out.println("two of the same number, then the player must roll again. If a player rolls at least one 1, then");
        System.out.println("the player's turn ends.");
        
        // confirm that player understands the rules
        String confirmation = "";
        while(true) {
            System.out.print("\nEnter 'y' to confirm that you understand the rules: ");
            confirmation = input.next();
            if(confirmation.equals("y")) {
                break;
            }
        }
    }

    // ask if player would like to see the rules
    private static boolean viewOrNo(String name) {
        String view = "";
        System.out.print("\nHello " + name + ", would you like to view the rules of the game? If you would, enter 'y'. If not, enter any other key: ");
        view = input.next();
        if(view.equals("y")) {
            return true;
        }
        else {
            return false;
        }
    }
}