package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class BadConsequence {
    static final int MAXTREASURES = 10;
            
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;    
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    
    public boolean isEmpty(){
        return nHiddenTreasures == 0 && nVisibleTreasures == 0 && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    
    }
    
    public int getLevels(){ return levels; }    
    public int getNVisibleTreasures(){ return nVisibleTreasures; }    
    public int getNHiddenTreasures(){ return nHiddenTreasures; }    
    public ArrayList<TreasureKind> getsVisibleTreasures(){ return specificVisibleTreasures; }    
    public ArrayList<TreasureKind> getsHiddenTreasures(){   return specificHiddenTreasures; }
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        
        this.death = false;
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public BadConsequence(String text, boolean death){
        
        this.text = text;
        this.death = death;
        this.levels = Player.MAXLEVEL;
        this.nVisibleTreasures = MAXTREASURES;
        this.nHiddenTreasures = MAXTREASURES;
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,ArrayList<TreasureKind> tHidden){
    
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
        this.death = false;
        this.nVisibleTreasures = tVisible.size();
        this.nHiddenTreasures = tHidden.size();
        
    }

    public String toString(){
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
    
    public void substractVisibleTreasures(Treasure t) {
        if(specificVisibleTreasures.contains(t.getType())){
            specificVisibleTreasures.remove(t.getType());
            nVisibleTreasures--;
        }
    }
    public void substractHiddenTreasures(Treasure t) {
        if(specificHiddenTreasures.contains(t.getType())){
            specificHiddenTreasures.remove(t.getType());
            nHiddenTreasures--;
        }
    }
    
    /*  adjustToFitTreasureList:
    
        Distingue si es el tipo de mal rollo que se basa en el número de tesoros (no especificados) o en un vector de específicos y usa el 
        constructor correspondiente. El primero sólo ajusta los valores, usa el constructor y devuelve el bc. El otro busca si los tesoros que
        se pretenden eliminar están entre los tesoros del jugador para añadirlos al mal rollo final. Al finalizar se devuelve el mal rollo resultante.
    
    */
    public BadConsequence adjustToFitTreasureLists(ArrayList<TreasureKind> v,ArrayList<TreasureKind> h){
        if(this.nHiddenTreasures > 0 || this.nVisibleTreasures > 0) {
            int n_visibles, n_ocultos;

            if(this.nHiddenTreasures > h.size())
                n_ocultos = h.size();
            else
                n_ocultos = this.nHiddenTreasures;

            if(this.nVisibleTreasures > v.size())
                n_visibles = v.size();
            else
                n_visibles = this.nVisibleTreasures;

            BadConsequence final_bc = new BadConsequence(this.text, this.levels, n_visibles, n_ocultos);
            
            return final_bc;    
        }
        else {
            ArrayList<TreasureKind> v_visible = new ArrayList();
            ArrayList<TreasureKind> v_oculto = new ArrayList();
            
            for(TreasureKind visible:this.specificVisibleTreasures){
                if(v.contains(visible))
                    v_visible.add(visible);
            }
            
            for(TreasureKind oculto:this.specificHiddenTreasures){
                if(h.contains(oculto))
                    v_oculto.add(oculto);
            }
            
            BadConsequence final_bc = new BadConsequence(this.text, this.levels, v_visible, v_oculto);
        
            return final_bc;    
        }
        
        
    }

}

