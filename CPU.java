import java.util.concurrent.TimeUnit;

public final class CPU extends Player {
   // constructor
   public CPU(String name) {
    super(name);
   }

   // force CPU to roll dice again
   @Override
   public boolean optionalRoll() {
    delay();
    return true;
   }

   // force CPU to roll dice again
   @Override
   public boolean obligatedRoll() {
    delay();
    return true;
   }

   private void delay() {
    try {
        // delay each output by one second
        TimeUnit.SECONDS.sleep(1);
    }
    catch(InterruptedException e) {
        System.out.println("Error");
    }
   }
}