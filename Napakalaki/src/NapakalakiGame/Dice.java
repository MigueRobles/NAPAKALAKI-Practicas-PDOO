package NapakalakiGame;
import java.util.Random;


/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class Dice {
    
  private static  Dice instance = null;
 
  private Dice() { }
 
  public static Dice getInstance() {
 
        if (instance == null)
            instance = new Dice();
        return instance;
    }
  public int nextNumber() {
        Random rnd = new Random();    
        // rnd.nextInt devuelve un int aleatorio, el 6 dice la longitud del rango y 
        //el 0 es el valor inicial
        return (int)(rnd.nextInt() * 6 + 0);
    }
    
}
