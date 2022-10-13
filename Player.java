public class Player {
    // variables
    private String name;
    private int dice1;
    private int dice2;
    private int points;

    // constructor
    public Player(String playerName) {
        this.name = playerName;
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
    
}