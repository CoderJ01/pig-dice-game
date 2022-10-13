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

        do {
            // if neither dice is 1, then the sum of the dices values are added to the players points
            if(dice1 != 1 && dice2 != 1) {
                this.points += (dice1 + dice2);
            }
            // if both dice are 1, then the player loses all his points
            else if(dice1 == 1 && dice2 == 1) {
                this.points = 0;
                turnContinues = false;
            }
            // if one die is 1, the player gets no points
            else if(dice1 == 1 || dice2 == 1) {
                turnContinues = false;
            }
            // if the dices are the same number, the player earns points
            else if(dice1 == dice2) {
                this.points += (dice1 + dice2);
            }

        } while (turnContinues == true);
        
        return this.points;
    }
}