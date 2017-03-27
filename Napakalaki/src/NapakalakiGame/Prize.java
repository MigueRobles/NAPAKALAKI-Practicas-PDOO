package NapakalakiGame;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class Prize {
    private int treasures;
    private int level;


    public Prize(int treasures, int level){
        this.treasures = treasures;
        this.level = level;
    }
    
    public int getTreasures(){
        return this.treasures;
    }
    
    public int getLevel(){
        return this.level;    
    } 
   
    public String toString(){
        return "Treasures = " + Integer.toString(treasures) + " / Levels = " + Integer.toString(level);
      }
}

