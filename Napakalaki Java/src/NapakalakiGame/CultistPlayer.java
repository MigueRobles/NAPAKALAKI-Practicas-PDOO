/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
/**
  * @author Jesús Sánchez de Lechina Tejada
  * @author Miguel Robles Urquiza  
  **/

public class CultistPlayer extends Player {
    public static int totalCultistPlayers = 0;
    //public Cultist myCultistCard;
    
    public CultistPlayer(Player p/*, Cultist c*/){
        super(p.getName());
        level = p.getLevels();
        dead = p.isDead();
        canISteal = p.canISteal();
        hiddenTreasures = p.getHiddenTreasures();
        visibleTreasures = p.getVisibleTreasures();
        pendingBadConsequence = p.getPendingBadConsequence();
        enemy = p.getEnemy();
        //myCultistCard = c;
        totalCultistPlayers += 1;
    }
}
