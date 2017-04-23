package NapakalakiGame;


/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class Dice {
    
  private static  Dice instance = null;
 
  Dice() { }
 
  public static Dice getInstance() {
 
        if (instance == null)
            instance = new Dice();
        return instance;
    }
  public int nextNumber() {
       return  (int) (Math.random() * (6)) +1;

    }
    
}
