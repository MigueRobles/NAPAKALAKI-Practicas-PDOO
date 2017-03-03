/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Robles Urquiza
 */
public class BadConsequence {
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden){
        
        this.death = false;
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
    }
    
    public BadConsequence(String text, boolean death){
        
        this.text = text;
        this.death = death;
        this.levels = 100;
        this.nVisibleTreasures = 100;
        this.nHiddenTreasures = 100;
        this.specificVisibleTreasures = new ArrayList();
        this.specificHiddenTreasures = new ArrayList();
   
    }
    
    public BadConsequence(String text, int levels, ArrayList<TreasureKind> tVisible,ArrayList<TreasureKind> tHidden){
    
        this.text = text;
        this.levels = levels;
        this.specificVisibleTreasures = new ArrayList();
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = new ArrayList();
        this.specificHiddenTreasures = tHidden;
        this.death = false;
        this.nVisibleTreasures = tVisible.size();
        this.nHiddenTreasures = tHidden.size();
        
    }
    
    public void setText(String text){
       this.text = text;
    }
    
    public void setLevels(int levels){
       this.levels = levels;
    }
    
    public void setnVisibleTreasures(int nVisibleTreasures){
       this.nVisibleTreasures = nVisibleTreasures;
    }
    
    public void setnHiddenTreasures(int nHiddenTreasures){
       this.nHiddenTreasures = nHiddenTreasures;
    }
    
    public void setDeath(boolean death){
       this.death = death;
    }
    
    public void setVisibleTreasures(ArrayList<TreasureKind> specificVisibleTreasures){
       this.specificVisibleTreasures = specificVisibleTreasures;
    }
    
    public void setHiddenTreasures(ArrayList<TreasureKind> specificHiddenTreasures){
       this.specificHiddenTreasures = specificHiddenTreasures;
    }

    public String getText(){
       return this.text;
    }
    
    public int getLevels(){
        return this.levels;
    }
    
    public int getnVisibleTreasures(){
        return this.nVisibleTreasures;
    }
    
    public int getnHiddenTreasures(){
        return this.nHiddenTreasures;
    }
    
    public boolean getDeath(){
        return this.death;
    }
    
    public ArrayList<TreasureKind> getsVisibleTreasures(){
        return this.specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getsHiddenTreasures(){
        return this.specificHiddenTreasures;
    }
    
    
    
    
    public String toString(){
        if(death){
            return "\"" + text +"\". Pierdes todos tus niveles y todos tus objetos.";
        }
        else if(nVisibleTreasures > 0 || nHiddenTreasures > 0){            
            String mensaje;
            mensaje = "\"" + text +"\". Pierdes:\n "; 
            System.out.print(mensaje);
            
            if(nVisibleTreasures > 0){
                String mensaje_visibles = Integer.toString(nVisibleTreasures) + " tesoros visibles: " ;
                System.out.print(mensaje_visibles);
                
                for(int i = 0; i < nVisibleTreasures; ++i){
                    System.out.print(specificVisibleTreasures.get(i));
                    switch (specificVisibleTreasures.get(i)){
                        case HELMET: mensaje_visibles.concat("casco");
                            break;
                        case ONEHAND: mensaje_visibles.concat("arma de una mano");
                            break;
                        case BOTHHANDS: mensaje_visibles.concat("arma de dos manos");
                            break;
                        case SHOES: mensaje_visibles.concat("botas");
                            break;
                        case ARMOR: mensaje_visibles.concat("armadura");
                            break;
                        default: mensaje_visibles.concat("a su elección");
                            break;
                    
                    }
                
                    if(i < nVisibleTreasures)
                        mensaje_visibles.concat(", ");
                    else
                        mensaje_visibles.concat(".\n");
                }
            mensaje.concat(mensaje_visibles);
            System.out.print(mensaje_visibles);
            }
            
            if(nHiddenTreasures > 0){
                String mensaje_ocultos = Integer.toString(nHiddenTreasures) + " tesoro(s) oculto(s): " ;
                for(int i = 0; i < nHiddenTreasures; ++i){
                    switch (specificHiddenTreasures.get(i)){
                        case HELMET: mensaje_ocultos.concat("casco");
                            break;
                        case ONEHAND: mensaje_ocultos.concat("arma de una mano");
                            break;
                        case BOTHHANDS: mensaje_ocultos.concat("arma de dos manos");
                            break;
                        case SHOES: mensaje_ocultos.concat("botas");
                            break;
                        case ARMOR: mensaje_ocultos.concat("armadura");
                            break;
                        default: mensaje_ocultos.concat("a su elección");
                            break;
                    
                    }
                
                    if(i < nHiddenTreasures)
                        mensaje_ocultos.concat(", ");
                    else
                        mensaje_ocultos.concat(".\n");
                }
            mensaje.concat(mensaje_ocultos);
            }
            
            return mensaje;
            }
            
        
        else{
            return "\"" + text +"\". Pierdes " + Integer.toString(levels) + " niveles, "+ Integer.toString(nVisibleTreasures) + " tesoros visibles y " + Integer.toString(nHiddenTreasures) + " tesoros ocultos.";
        }
    }
    
    

}

