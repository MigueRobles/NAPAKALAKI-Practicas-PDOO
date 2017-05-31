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
    public String toString(){
      return super.toString() + "\nSpecificVisibleTreasures: " + visibleToString() + "\nSpecificHiddenTreasures: " + hiddenToString();
      
    }
    
    private String visibleToString(){
        String visible = "";
        
        for(TreasureKind t:sVisibleTreasures){
            visible += (t + " ");
        }
        return visible;
    }
    
    private String hiddenToString(){
        String hidden = "";
        
        for(TreasureKind t:sHiddenTreasures){
            hidden += (t + " ");
        }
        return hidden;
    }
    

    @Override
    public boolean isEmpty(){
        return sVisibleTreasures.size() == 0 && sHiddenTreasures.size() == 0;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t){
        if (!sVisibleTreasures.isEmpty())
            sVisibleTreasures.remove(t.getType());
    }
    
    @Override
    public int getNVisibleTreasures(){
        return this.sVisibleTreasures.size();
    }
    
    @Override
    public int getNHiddenTreasures(){
        return this.sHiddenTreasures.size();
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t){
       if (!sHiddenTreasures.isEmpty())
           sHiddenTreasures.remove(t.getType());
    }
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return sVisibleTreasures;
    }
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return sHiddenTreasures;
    }
    
    /*
    @Override
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
    */
    
    // Probamos implementación alternativa
    /*
    @Override
     public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
        ArrayList<TreasureKind> sV = new ArrayList<TreasureKind>();
        ArrayList<TreasureKind> sH = new ArrayList<TreasureKind>();

        for (Treasure tv : v) {
            sV.add(tv.getType());
        }

        ArrayList<TreasureKind> intersectionV = new ArrayList(sV);

        intersectionV.retainAll(this.sVisibleTreasures);

        for (Treasure th : h) {
            sH.add(th.getType());
        }

        ArrayList<TreasureKind> intersectionH = new ArrayList(sH);

        intersectionH.retainAll(this.sHiddenTreasures);
         return (new SpecificBadConsequence(this.text, this.levels, intersectionV, intersectionH));

     
    }*/
    //Otra alternativa
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        ArrayList<TreasureKind> specV = new ArrayList();
        ArrayList<TreasureKind> copy_spV = new ArrayList(sVisibleTreasures);
        ArrayList<TreasureKind> specH = new ArrayList();
        ArrayList<TreasureKind> copy_spH = new ArrayList(sHiddenTreasures);
        ArrayList<TreasureKind> typesH = new ArrayList();
        ArrayList<TreasureKind> typesV = new ArrayList();
        
        
        for(Treasure t: v){
            typesV.add(t.getType());
        }
        
        for(Treasure t: h){
            typesH.add(t.getType());
        }
                    
        for(TreasureKind t: typesV){
            if(copy_spV.contains(t)){
                specV.add(t);
                copy_spV.remove(t);
            }
        }
        
        for(TreasureKind t: typesH){
            if(copy_spH.contains(t)){
                specH.add(t);
                copy_spH.remove(t);
            }
        }
            
        BadConsequence bc = new SpecificBadConsequence(text, levels, specV, specH);
        
        return bc;        
    }
}
