/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
  * @author Jesús Sánchez de Lechina Tejada
  * @author Miguel Robles Urquiza  
  **/

public class CultistPlayer extends Player {
    public static int totalCultistPlayers = 0;
    public Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
        super(p.getName());
        level = p.getLevels();
        dead = p.isDead();
        canISteal = p.canISteal();
        hiddenTreasures = p.getHiddenTreasures();
        visibleTreasures = p.getVisibleTreasures();
        pendingBadConsequence = p.getPendingBadConsequence();
        enemy = p.getEnemy();
        myCultistCard = c;
        totalCultistPlayers += 1;
    }
    
    @Override
    protected int getCombatLevel() {
        return (int) (Math.round(super.getCombatLevel() * 1.7) + totalCultistPlayers * myCulstistCard.getGainedLevels());
    }
    
    protected int getOponentLevel(Monster m) {
        return m.getLevelAgainstCultistPlayer();
    }
    
    protected boolean shouldConvert() {
        return false;
    }
    
    private Treasure giveMeATreasure(){
        int indice = (int) (Math.random() % visibleTreasures.size());
        return visibleTreasures.remove(indice);
    }
    
    private boolean canYouGiveMeATreasure(){
        return visibleTreasures.size() > 0;
    }
    
    public int getTotalCUltistPlayers() {
        return totalCultistPlayers;
    }
}
