/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
package NapakalakiGame;

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.ArrayList;

public class NumericBadConsequence  extends BadConsequence {
    
    int nVisibleTreasures;
    int nHiddenTreasures;

    public NumericBadConsequence(String aText, int levels,int VisibleTreasures,int HiddenTreasures ){
     super(aText,levels);
     nVisibleTreasures = VisibleTreasures;
     nHiddenTreasures = HiddenTreasures;
    }   

    @Override
    public String toString() {
      return super.toString() + "\nPierdes: " + nVisibleTreasures + " tesoros visibles y : " + nHiddenTreasures + " tesoros ocultos.\n";
      
    }

    @Override
    public boolean isEmpty(){
        return nVisibleTreasures == 0 && nHiddenTreasures == 0;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        nVisibleTreasures = max(0,nVisibleTreasures -1);
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
        nHiddenTreasures = max(0,nHiddenTreasures -1);
    }
    
    @Override
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    @Override
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    @Override
    public NumericBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
        if(!isEmpty()){
            nVisibleTreasures = min(nVisibleTreasures,v.size());
            nHiddenTreasures = min(nHiddenTreasures,h.size());
            return new NumericBadConsequence(text, levels,nVisibleTreasures, nHiddenTreasures);
            }
        else
             return this;
    }
}

    