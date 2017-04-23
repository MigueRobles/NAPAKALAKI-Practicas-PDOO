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

    Prize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getTreasures(){ return treasures; }    
    public int getLevel(){ return level; } 
   
    public String toString(){
        return "Treasures: " + Integer.toString(treasures) + " / Levels: " + Integer.toString(level);
      }
}

