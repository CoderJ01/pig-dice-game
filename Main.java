public class Main {
    public static void main(String[] args) {
        // players
        Player joshua = new Player("Joshua");
        CPU CPU1 = new CPU("CPU_1");
        CPU CPU2 = new CPU("CPU_2");
        CPU CPU3 = new CPU("CPU_3");

        // continue the game while all the players have less than 100 points
        while(joshua.getPoints() < 100 && CPU1.getPoints() < 100 && CPU2.getPoints() < 100 && CPU3.getPoints() < 100) {
            // playable character
            int a = joshua.rollFirstDice();
            int b = joshua.rollSecondDice();
            joshua.determinePoints(a, b);
            joshua.getPoints();
            System.out.println("getPoints(): " + joshua.getPoints());

            if(joshua.getPoints() >= 100) {
                break;
            }

            // CPU 1
            int c = CPU1.rollFirstDice();
            int d = CPU1.rollSecondDice();
            CPU1.determinePoints(c, d);
            CPU1.getPoints();
            System.out.println("getPoints(): " + CPU1.getPoints());

            if(CPU1.getPoints() >= 100) {
                break;
            }

            // CPU 2
            int e = CPU2.rollFirstDice();
            int f = CPU2.rollSecondDice();
            CPU2.determinePoints(e, f);
            CPU2.getPoints();
            System.out.println("getPoints(): " + CPU2.getPoints());

            if(CPU2.getPoints() >= 100) {
                break;
            }

            // CPU 3
            int g = CPU3.rollFirstDice();
            int h = CPU3.rollSecondDice();
            CPU1.determinePoints(g, h);
            CPU3.getPoints();
            System.out.println("getPoints(): " + joshua.getPoints());

            if(CPU3.getPoints() >= 100) {
                break;
            }
        }
    }
}