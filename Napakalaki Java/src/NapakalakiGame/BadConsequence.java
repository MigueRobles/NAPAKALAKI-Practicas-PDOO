package NapakalakiGame;

import static java.lang.Math.max;
import java.util.ArrayList;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public abstract class BadConsequence {
    static final int MAXTREASURES = 10;
            
    protected String text;
    protected int levels;   
    
      
    public int getLevels(){ return levels; }    
    
    public  String getText(){return text;}    

    public BadConsequence(String text, int levels){
        
        this.text = text;
        this.levels = levels;       
    }  
    

    @Override
    public String toString(){
        return text + "\nPierdes " + levels + " niveles.\n";
    }
    
    
    public abstract boolean isEmpty();
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h);
    
    public abstract int getNVisibleTreasures();
    
    public abstract int getNHiddenTreasures();
    
        /*
        if(death){
            return "\"" + text +"\"" ;
        }
        else if(specificVisibleTreasures.size() > 0 &&  specificHiddenTreasures.size() > 0){     
         return text + "\nLevels: " + levels + "\nTesoros visibles: "+ specificVisibleTreasures + "\nTesoros ocultos: "+ specificHiddenTreasures;            
        }
        else if(specificVisibleTreasures.size() > 0){        
         return text + "\nLevels: " + levels + "\nTesoros visibles: " + specificVisibleTreasures;
        }
        else if(specificHiddenTreasures.size() > 0){
         return text + "\nLevels  " + levels + "\nTesoros ocultos: " + specificHiddenTreasures;
        }         
        else{
         return text + "\nLevels  " + levels + "\nTesoros visibles: " + nVisibleTreasures + "\nTesoros ocultos: " + nHiddenTreasures;
        }
    }
    
    public void substractVisibleTreasure(Treasure t) {
        if(!isEmpty()){
            if(specificVisibleTreasures.contains(t.getType())){
                specificVisibleTreasures.remove(t.getType());
                nVisibleTreasures = specificVisibleTreasures.size();
            }
            else
                nVisibleTreasures = max(0, nVisibleTreasures -1);
        }
        
    }
      public void substractHiddenTreasure(Treasure t) {
        if(!isEmpty()){
            if(specificHiddenTreasures.contains(t.getType())){
                specificHiddenTreasures.remove(t.getType());
                nHiddenTreasures = specificHiddenTreasures.size();
            }
            else
                nHiddenTreasures = max(0, nHiddenTreasures -1);
        }
        
    }
    */
    /*  adjustToFitTreasureList:
    
        Distingue si es el tipo de mal rollo que se basa en el número de tesoros (no especificados) o en un vector de específicos y usa el 
        constructor correspondiente. El primero sólo ajusta los valores, usa el constructor y devuelve el bc. El otro busca si los tesoros que
        se pretenden eliminar están entre los tesoros del jugador para añadirlos al mal rollo final. Al finalizar se devuelve el mal rollo resultante.
    
    *//*
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v,ArrayList<Treasure> h){
        
        if(!this.isEmpty()){
            this.nVisibleTreasures = Math.min(this.nVisibleTreasures, v.size());
            this.nHiddenTreasures = Math.min(this.nHiddenTreasures, h.size());
            
            ArrayList<TreasureKind> visibleTypes = new ArrayList();
            for(Treasure t:v){
                visibleTypes.add(t.getType());
            }
            
            ArrayList<TreasureKind> hiddenTypes = new ArrayList();
            for(Treasure t:h){
                visibleTypes.add(t.getType());
            }
            
            this.specificVisibleTreasures = new ArrayList();
            ArrayList<TreasureKind> cpySpecificVisibleTreasures = new ArrayList();
            
            for(TreasureKind t:this.specificVisibleTreasures) {
                cpySpecificVisibleTreasures.add(t);
            }
            
            this.specificHiddenTreasures = new ArrayList();
            ArrayList<TreasureKind> cpySpecificHiddenTreasures = new ArrayList();
            
            for(TreasureKind t:this.specificHiddenTreasures){
                cpySpecificHiddenTreasures.add(t);
            }
            
            for(TreasureKind t_kind:visibleTypes) {
                if(cpySpecificVisibleTreasures.contains(t_kind)) {
                    specificVisibleTreasures.add(t_kind);
                    cpySpecificVisibleTreasures.remove(t_kind);
                }
            }
            
            for(TreasureKind t_kind:hiddenTypes) {
                if(cpySpecificHiddenTreasures.contains(t_kind)) {
                    specificHiddenTreasures.add(t_kind);
                    cpySpecificHiddenTreasures.remove(t_kind);
                }
            }
            
            if(specificHiddenTreasures.isEmpty()) {
                return new BadConsequence(this.text, this.levels, nVisibleTreasures, nHiddenTreasures);
            }
            else
                return new BadConsequence(this.text, this.levels, specificVisibleTreasures, specificHiddenTreasures);
            
        }
        return this;
    }*/
    
  
    

}

