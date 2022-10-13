public class CPU extends Player {
   // constructor
   public CPU(String name) {
    super(name);
   }

   // force CPU to roll dice again
   @Override
   public boolean optionalRoll() {
    return true;
   }

   // force CPU to roll dice again
   @Override
   public boolean obligatedRoll() {
    return true;
   }
}