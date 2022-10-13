public class Main {
    public static void main(String[] args) {
        Player joshua = new Player("Joshua");
        int a = joshua.rollFirstDice();
        int b = joshua.rollSecondDice();
        System.out.println(a + " " + b);
    }
}