public class Main {
    public static void main(String[] args) {
        // players
        Player joshua = new Player("Joshua");
        CPU CPU1 = new CPU("CPU_1");
        CPU CPU2 = new CPU("CPU_2");
        CPU CPU3 = new CPU("CPU_3");

        // initilize parameters with points
        int w = joshua.getPoints();
        int x = CPU1.getPoints();
        int y = CPU2.getPoints();
        int z = CPU3.getPoints();

        // continue the game while all the players have less than 100 points
        while(w < 100 && x < 100 && y < 100 && z < 100) {
            // playable character
            int a = joshua.rollFirstDice();
            int b = joshua.rollSecondDice();
            joshua.determinePoints(a, b);

            // When Player 1 reaches 100 points, end game
            if(w >= 100) {
                System.out.println(joshua.getName() + " wins the game with " + joshua.getPoints() + " points");
                break;
            }

            // CPU 1
            int c = CPU1.rollFirstDice();
            int d = CPU1.rollSecondDice();
            CPU1.determinePoints(c, d);

            // When Player 2 reaches 100 points, end game
            if(x >= 100) {
                System.out.println(CPU1.getName() + " wins the game with " + CPU1.getPoints() + " points");
                break;
            }

            // CPU 2
            int e = CPU2.rollFirstDice();
            int f = CPU2.rollSecondDice();
            CPU2.determinePoints(e, f);

            // When Player 3 reaches 100 points, end game
            if(y >= 100) {
                System.out.println(CPU2.getName() + " wins the game with " + CPU2.getPoints() + " points");
                break;
            }

            // CPU 3
            int g = CPU3.rollFirstDice();
            int h = CPU3.rollSecondDice();
            CPU1.determinePoints(g, h);

            // When Player 4 reaches 100 points, end game
            if(z >= 100) {
                System.out.println(CPU3.getName() + " wins the game with " + CPU3.getPoints() + " points");
                break;
            }
        }
    }
}