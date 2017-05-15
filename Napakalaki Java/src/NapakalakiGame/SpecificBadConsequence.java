/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
package NapakalakiGame;

import java.util.ArrayList;

public class SpecificBadConsequence extends BadConsequence{
    ArrayList<TreasureKind> sVisibleTreasures = new ArrayList();
    ArrayList<TreasureKind> sHiddenTreasures = new ArrayList();

    public SpecificBadConsequence(String aText, int levels,ArrayList<TreasureKind> VisibleTreasures,ArrayList<TreasureKind> HiddenTreasures ){
     super(aText,levels);
     sVisibleTreasures = VisibleTreasures;
     sHiddenTreasures = HiddenTreasures;
    }   

    @Override
    public String toString() {
      return super.toString() + "\nSpecificVisibleTreasures: " + sVisibleTreasures + "\nSpecificHiddenTreasures: " + sHiddenTreasures;
      
    }

    boolean isEmpty(){
        return sVisibleTreasures == new ArrayList() && sHiddenTreasures == new ArrayList();
    }
    
    void substractVisibleTreasure(Treasure t){
        if (sVisibleTreasures.isEmpty())
            sVisibleTreasures.remove(t.getType());
    }
    void substractHiddenTreasure(Treasure t){
       if (sHiddenTreasures.isEmpty())
           sHiddenTreasures.remove(t.getType());
    }
    ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return sVisibleTreasures;
    }
    ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return sHiddenTreasures;
    }
    
    SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
     if(!isEmpty()){
                       
            ArrayList<TreasureKind> visibleTypes = new ArrayList();
            for(Treasure t:v){
                visibleTypes.add(t.getType());
            }            
            ArrayList<TreasureKind> hiddenTypes = new ArrayList();
            for(Treasure t:h){
                visibleTypes.add(t.getType());
            }
            
            sVisibleTreasures = new ArrayList();
            ArrayList<TreasureKind> cpySpecificVisibleTreasures = new ArrayList();            
            for(TreasureKind t:sVisibleTreasures) {
                cpySpecificVisibleTreasures.add(t);
            }
            
            sHiddenTreasures = new ArrayList();
            ArrayList<TreasureKind> cpySpecificHiddenTreasures = new ArrayList();            
            for(TreasureKind t:sHiddenTreasures){
                cpySpecificHiddenTreasures.add(t);
            }
            
            for(TreasureKind t_kind:visibleTypes) {
                if(cpySpecificVisibleTreasures.contains(t_kind)) {
                    sVisibleTreasures.add(t_kind);
                    cpySpecificVisibleTreasures.remove(t_kind);
                }
            }
            
            for(TreasureKind t_kind:hiddenTypes) {
                if(cpySpecificHiddenTreasures.contains(t_kind)) {
                    sHiddenTreasures.add(t_kind);
                    cpySpecificHiddenTreasures.remove(t_kind);
                }
            }
            
        return new SpecificBadConsequence(text, levels,sVisibleTreasures, sHiddenTreasures);
        }
     else
         return this;
    }
}
