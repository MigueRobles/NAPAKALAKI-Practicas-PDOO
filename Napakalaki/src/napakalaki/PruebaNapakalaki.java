/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Robles Urquiza
 */
public class PruebaNapakalaki {
    
    static ArrayList<Monster> monstruos = new ArrayList();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        monstruos.add(new Monster("Byakhees de bonanza", 8, prize, badConsequence));
        
        badConsequence = new BadConsequence("Embobados por el lindo primigenio te descartas de tu casco visible",0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan", 2, prize, badConsequence));
        
                
        for (int i = 0; i < monstruos.size(); ++i){
            System.out.println (monstruos.get(i).toString());
        }
        
    }
    
}

