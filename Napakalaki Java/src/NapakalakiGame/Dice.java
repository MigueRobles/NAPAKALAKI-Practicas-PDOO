package NapakalakiGame;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */

public class Dice {
    private static final Dice instance = new Dice();
    
    private Dice(){}
    
    public static Dice getInstance(){
        return instance;
    }
    
    public int nextNumber(){
        return (int) ((Math.random()*6)+1);
        
    }
}