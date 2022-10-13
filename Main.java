public class Main {
    public static void main(String[] args) {
        // players
        Player joshua = new Player("Joshua");
        CPU CPU1 = new CPU("CPU_1");
        CPU CPU2 = new CPU("CPU_2");
        CPU CPU3 = new CPU("CPU_3");
        
        // playable character
        int a = joshua.rollFirstDice();
        int b = joshua.rollSecondDice();
        joshua.determinePoints(a, b);

        // CPU 1
        int c = CPU1.rollFirstDice();
        int d = CPU1.rollSecondDice();
        CPU1.determinePoints(c, d);

        // CPU 2
        int e = CPU2.rollFirstDice();
        int f = CPU2.rollSecondDice();
        CPU2.determinePoints(e, f);

        // CPU 3
        int g = CPU3.rollFirstDice();
        int h = CPU3.rollSecondDice();
        CPU1.determinePoints(g, h);
    }
}