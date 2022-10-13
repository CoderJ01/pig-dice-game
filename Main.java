public class Main {
    public static void main(String[] args) {
        // Player joshua = new Player("Joshua");
        // int a = joshua.rollFirstDice();
        // int b = joshua.rollSecondDice();
        // System.out.println(a + " " + b);

        // joshua.determinePoints(a, b);

        CPU CPU1 = new CPU("CPU1");
        int c = CPU1.rollFirstDice();
        int d = CPU1.rollSecondDice();
        System.out.println(c + " " + d);

        CPU1.determinePoints(c, d);
    }
}