/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
package NapakalakiGame;

public class DeathBadConsequence extends NumericBadConsequence{
    protected boolean death;
    
    
    public DeathBadConsequence(String aText, boolean d){
       super(aText,Player.MAXLEVEL, BadConsequence.MAXTREASURES,BadConsequence.MAXTREASURES);
       death = d;    
    }   

    @Override
    public String toString() {
      return text+ "Pierdes todos los tesoros y vuelves al nivel uno.\n";
    }

    public boolean getDeath(){
        return death;
    }
     
}
