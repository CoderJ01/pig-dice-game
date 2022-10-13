import java.util.concurrent.TimeUnit;

public class CPU extends Player {
   // constructor
   public CPU(String name) {
    super(name);
   }

   // force CPU to roll dice again
   @Override
   public boolean optionalRoll() {
    try {
        // delay each output by three seconds
        TimeUnit.SECONDS.sleep(3);
    }
    catch(InterruptedException e) {
        System.out.println("Error");
    }
    return true;
   }

   // force CPU to roll dice again
   @Override
   public boolean obligatedRoll() {
    try {
        // delay each output by three seconds
        TimeUnit.SECONDS.sleep(3);
    }
    catch(InterruptedException e) {
        System.out.println("Error");
    }
    return true;
   }
}