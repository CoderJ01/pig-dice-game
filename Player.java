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
}