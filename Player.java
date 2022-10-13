import java.util.Random;
import java.util.Scanner;

public class Player {
    // primative variables
    private int dice1;
    private int dice2;
    private int points;

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
        boolean turnContinues = false;
        displayDiceNumbers(dice1, dice2); // terminal display
        
        do {
            // if neither dice is 1, then the sum of the dices values are added to the players points
            if(dice1 != 1 && dice2 != 1) {
                this.points += (dice1 + dice2);
                if(optionalRoll() == true) {
                    turnContinues = true;
                    int x = rollFirstDice();
                    int y = rollSecondDice();
                    // recursion
                    determinePoints(x, y);
                }
                else {
                    turnContinues = false;
                }
            }
            // if both dice are 1, then the player loses all his points, and his turn ends
            else if(dice1 == 1 && dice2 == 1) {
                this.points = 0;
                turnContinues = false;
            }
            // if one die is 1, the player gets no points, and his turn ends
            else if(dice1 == 1 || dice2 == 1) {
                turnContinues = false;
            }
            // if the dices are the same number, the player earns points, and the player is obligated to roll again
            else if(dice1 == dice2) {
                this.points += (dice1 + dice2);
                // obligated roll will always be true
                if(obligatedRoll() == true) {
                    turnContinues = true;
                    int x = rollFirstDice();
                    int y = rollSecondDice();
                    // recursion
                    determinePoints(x, y);
                }
            }

        } while (turnContinues == true);
        
        return this.points;
    }

    // force the player to roll the dice again
    public boolean obligatedRoll() {
        boolean turnContinues = false;
        String obligated = "";

        while(!turnContinues) {
            System.out.print("You must roll again. Press 'r' key to roll dice: ");
            obligated = input.next();
            if(obligated != "r") {
                turnContinues = false;
            }
            else {
                turnContinues = true;
                break;
            }
        }
        return turnContinues;
    }

    // provide user the option to roll dice again
    public boolean optionalRoll() {
        String option = "";
        System.out.print("Would you like to roll again? If yes, press the 'y' key: ");
        option = input.next();
        if(option == "y") {
            return true;
        } 
        return false;
    }

    // display dice numbers
    public void displayDiceNumbers(int dice1, int dice2) {
        System.out.println("Player: " + this.name);
        System.out.println("Dice 1: " + dice1);
        System.out.println("Dice 2: " + dice2);
        System.out.println("Points: " + this.points);
    }
}