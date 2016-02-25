public class sound {
 
  public static void test() {
    
    // scale increments
    int[] steps = { 0, 2, 4, 5, 7, 9, 11, 12 };
    for (int i = 0; i < steps.length; i++) {
      double hz = 440.0 * Math.pow(2, steps[i] / 12.0);
      StdAudio.play(hz, 1.0, 0.5);
    }
    
    StdAudio.play("FaustArp.wav");
    
    for (int i = 0; i < steps.length; i++) {
      double hz = 440.0 * Math.pow(2, steps[i] / 12.0);
      StdAudio.play(hz, 1.0, 0.5);
    }
    
    
    StdAudio.close();
  } // end test
  
 
  
} // end class sound