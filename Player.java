import java.util.Random;
import java.util.Scanner;

public class Player {
    // primative variables
    private int dice1;
    private int dice2;
    private int points;
    private boolean turnContinues = true;

    // non-primative variables
    private String name;
    private Scanner input = new Scanner(System.in);
    private Random rand = new Random();

    // constructor
    public Player(String playerName) {
        this.name = playerName;
        this.points = 0;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public int getFirstDieNumber() {
        return this.dice1;
    }

    public int getSecondDieNumber() {
        return this.dice2;
    }

    public int getPoints() {
        return this.points;
    }    

    // roll first dice
    public int rollFirstDice() {
        return rand.nextInt(6) + 1;
    }

    // roll second dice
    public int rollSecondDice() {
        return rand.nextInt(6) + 1;
    }

    // determine the number of points the player earns
    public int determinePoints(int dice1, int dice2) {

        while(this.turnContinues == true && this.points < 100) {
            // if neither dice is 1, then the sum of the dices values are added to the players points
            if(dice1 != 1 && dice2 != 1 && (dice1 != dice2)) {
                this.points += (dice1 + dice2);
                displayInfo(dice1, dice2); // terminal display
                if(optionalRoll() == true) {
                    this.turnContinues = true;
                    int x = rollFirstDice();
                    int y = rollSecondDice();
                    // recursion
                    determinePoints(x, y);
                }
                else {
                    this.turnContinues = false;
                }
            }
            // if both dice are 1, then the player loses all his points, and his turn ends
            else if(dice1 == 1 && dice2 == 1) {
                this.points = 0;
                displayInfo(dice1, dice2); // terminal display
                this.turnContinues = false;
                break;
            }
            // if one die is 1, the player gets no points, and his turn ends
            else if(dice1 == 1 || dice2 == 1) {
                displayInfo(dice1, dice2); // terminal display
                this.turnContinues = false;
                break;
            }
            // if the dices are the same number, the player earns points, and the player is obligated to roll again
            else if(dice1 == dice2) {
                this.points += (dice1 + dice2);
                displayInfo(dice1, dice2); // terminal display
                // obligated roll will always be true
                if(obligatedRoll()) {
                    this.turnContinues = true;
                    int x = rollFirstDice();
                    int y = rollSecondDice();
                    // recursion
                    determinePoints(x, y);
                }
            }
        }
        
        return this.points;
    }

    // force the player to roll the dice again
    public boolean obligatedRoll() {
        this.turnContinues = false;
        String obligated = "";

        while(!this.turnContinues) {
            System.out.print("You must roll again. Press 'r' key to roll dice: ");
            obligated = input.next();
            if(!obligated.equals("r")) {
                this.turnContinues = false;
            }
            else {
                this.turnContinues = true;
                break;
            }
        }
        return this.turnContinues;
    }

    // provide user the option to roll dice again
    public boolean optionalRoll() {
        String option = "";
        System.out.print("Would you like to roll again? If yes, press the 'y' key: ");
        option = input.next();
        if(!option.equals("y")) {
            return false;
        }
        else {
            return true;
        }
    }

    // display dice numbers and points
    public void displayInfo(int dice1, int dice2) {
        System.out.println("\nPlayer: " + this.name);
        System.out.println("Dice 1: " + dice1);
        System.out.println("Dice 2: " + dice2);
        System.out.println("Points: " + this.points);
    }
}