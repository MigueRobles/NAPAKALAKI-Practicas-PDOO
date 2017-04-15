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
        this.levels = 1;
        this.nVisibleTreasures = 0;
        this.nHiddenTreasures = 0;
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
    /**
    public String toString(){
        if(death){
            return "\"" + text +"\". Pierdes todos tus niveles y todos tus objetos.";
        }
        else if(nVisibleTreasures > 0 || nHiddenTreasures > 0){            
            String mensaje;
            mensaje = "\"" + text +"\". Debes descartarte de:\n"; 
           
            if(nVisibleTreasures > 0){
                if(nVisibleTreasures != Integer.MAX_VALUE){
                    String mensaje_visibles = Integer.toString(nVisibleTreasures) + " tesoro(s) visible(s): " ;
                
                    for(int i = 0; i < specificVisibleTreasures.size(); ++i){
                        switch (specificVisibleTreasures.get(i)){
                            case HELMET: mensaje_visibles += "cubrecabezas";
                                break;
                            case ONEHAND: mensaje_visibles += "arma de una mano";
                                break;
                            case BOTHHANDS: mensaje_visibles +="arma de dos manos";
                                break;
                            case SHOES: mensaje_visibles += "calzado";
                                break;
                            case ARMOR: mensaje_visibles += "armadura";
                                break;  
                        }
                        
                        if(i < specificVisibleTreasures.size()-1)
                            mensaje_visibles += ", ";
                        else
                            mensaje_visibles += ".\n";
                    }
                    mensaje += mensaje_visibles;
                }
                    else {
                        String mensaje_visibles = "Todos los tesoros visibles\n";
                        mensaje += mensaje_visibles;
                    }
                }
            
            
            if(nHiddenTreasures > 0){
                if(nHiddenTreasures != Integer.MAX_VALUE){
                    String mensaje_ocultos = Integer.toString(nHiddenTreasures) + " tesoro(s) oculto(s): " ;
                    for(int i = 0; i < specificHiddenTreasures.size(); ++i){
                        switch (specificHiddenTreasures.get(i)){
                            case HELMET: mensaje_ocultos += "cubrecabezas";
                                break;
                            case ONEHAND: mensaje_ocultos += "arma de una mano";
                                break;
                            case BOTHHANDS: mensaje_ocultos +="arma de dos manos";
                                break;
                            case SHOES: mensaje_ocultos += "calzado";
                                break;
                            case ARMOR: mensaje_ocultos += "armadura";
                                break;

                        }
                        if(specificHiddenTreasures.isEmpty())
                         mensaje_ocultos +="a su elección";

                        if(i < specificHiddenTreasures.size() -1)
                            mensaje_ocultos += ", ";
                        else
                            mensaje_ocultos += ".\n";
                    }
                    mensaje += mensaje_ocultos ;
                }
                
                else{
                    String mensaje_ocultos = "Todos los tesoros ocultos\n";
                    mensaje += mensaje_ocultos ;
                }
            }
            
            return mensaje;
            }
            
        
        else{
            return "\"" + text +"\". Pierdes " + Integer.toString(levels) + " niveles, "+ Integer.toString(nVisibleTreasures) + " tesoros visibles y " + Integer.toString(nHiddenTreasures) + " tesoros ocultos.";
        }
    }
    
    
*/
    //Pongo un To_s mas básico y que funcione directamente
    
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

