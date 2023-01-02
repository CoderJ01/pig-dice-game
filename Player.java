import java.util.Random;
import java.util.Scanner;

public class Player implements Comparable<Player>{
    // fields
    private int points;
    private boolean turnContinues = true;
    private final String NAME;
    private Scanner input = new Scanner(System.in);
    private Random rand = new Random();

    // constructor
    public Player(String playerName) {
        NAME = playerName;
        this.points = 0;
    }

    // getters
    public final String getName() {
        return NAME;
    }

    public final int getPoints() {
        return this.points;
    }    

    // roll die
    public final int rollDie() {
        return rand.nextInt(6) + 1;
    }

    // determine the number of points the player earns
    public final int determinePoints(int die1, int die2) {

        this.turnContinues = true;

        while(this.turnContinues && this.points < 100) {
            // if neither dice is 1 nor the same number, then the sum of the dices values are added to the players points
            if(die1 != 1 && die2 != 1 && (die1 != die2)) {
                this.points += (die1 + die2);
                displayInfo(die1, die2); // terminal display
                if(optionalRoll()) {
                    this.turnContinues = true;
                    int x = rollDie();
                    int y = rollDie();
                    determinePoints(x, y); // recursion
                }
                else {
                    this.turnContinues = false;
                }
            }
            // if both dice are 1, then the player loses all his points, and his turn ends
            else if(die1 == 1 && die2 == 1) {
                this.points = 0;
                displayInfo(die1, die2); 
                this.turnContinues = false;
            }
            // if one die is 1, the player gets no points, and his turn ends
            else if(die1 == 1 || die2 == 1) {
                displayInfo(die1, die2); 
                this.turnContinues = false;
            }
            // if the dice are the same number, the player earns points, and the player is obligated to roll again
            else if(die1 == die2 && (die1 != 0 || die2 != 0)) {
                this.points += (die1 + die2);
                displayInfo(die1, die2); 
                // obligated roll will always be true
                if(obligatedRoll()) {
                    this.turnContinues = true;
                    int x = rollDie();
                    int y = rollDie();
                    determinePoints(x, y);
                }
            }
            // if player does not roll this, player's turn ends
            else if(die1 == 0 || die2 == 0) {
                this.turnContinues = false;
            }
        }
        
        return this.points;
    }

    // force the player to roll the dice again
    public boolean obligatedRoll() {
        this.turnContinues = false;

        while(!this.turnContinues) {
            System.out.print("\nYou must roll again. Enter the 'r' key to roll dice: ");
            String obligated = input.next();
            if(!obligated.equals("r")) {
                this.turnContinues = false;
            }
            else {
                this.turnContinues = true;
            }
        }
        return this.turnContinues;
    }

    // provide user the option to roll dice again
    public boolean optionalRoll() {
        System.out.print("\n" + NAME + ", would you like to roll the dice? If yes, enter the 'y' key: ");
        String option = input.next();
        if(!option.equals("y")) {
            return false;
        }
        else {
            return true;
        }
    }

    // display dice numbers and points
    public final void displayInfo(int die1, int die2) {
        System.out.println("\nPlayer: " + NAME);
        System.out.println("Die 1: " + die1);
        System.out.println("Die 2: " + die2);
        System.out.println("Points: " + this.points);
    }

    // sort players by the number of points they have
    @Override
    public final int compareTo(Player rankPlayer) {
        return rankPlayer.points - this.points;
    }
}