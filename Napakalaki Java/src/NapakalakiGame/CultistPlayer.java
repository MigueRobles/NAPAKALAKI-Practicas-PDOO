/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
package NapakalakiGame;


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
    public int getCombatLevel() {
        return (int) (Math.round(super.getCombatLevel() * 1.7) + totalCultistPlayers * myCultistCard.getGainedLevels());
    }
    
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();
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
    
    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
}
