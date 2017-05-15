/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
package NapakalakiGame;

public class Cultist {
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gainedLevels) {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    public int getGainedLevels(){
        return gainedLevels;
    }
}
