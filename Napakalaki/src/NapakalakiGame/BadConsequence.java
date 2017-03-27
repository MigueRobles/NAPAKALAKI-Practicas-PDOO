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
        if(nHiddenTreasures == 0 && nVisibleTreasures == 0 && specificVisibleTreasures == new ArrayList() && specificHiddenTreasures == new ArrayList())
          return true;
        return false;
    
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
         return "Text:" + text + "\n Levels:  " + levels + "\n Tesoros visibles: "+ specificVisibleTreasures + "\n Tesoros ocultos: "+ specificHiddenTreasures;            
        }
        else if(specificVisibleTreasures.size() > 0){        
         return "Text:" + text + "\n Levels:  " + levels + "\n Tesoros visibles: " + specificVisibleTreasures;
        }
        else if(specificHiddenTreasures.size() > 0){
         return "Text:" + text + "\n Levels:  " + levels + "\n Tesoros ocultos: " + specificHiddenTreasures;
        }         
        else{
         return "Text:" + text + "\n Levels:  " + levels + "\n Tesoros visibles: " + nVisibleTreasures + "\n Tesoros ocultos: " + nHiddenTreasures;
        }
    }
}

