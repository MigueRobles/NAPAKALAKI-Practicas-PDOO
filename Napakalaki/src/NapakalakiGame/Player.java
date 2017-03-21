
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Miguel y Jesús
 */
public class Player {
    private String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private static int INITIAL_LEVEL = 1;
    private Player enemy;
    
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private ArrayList<BadConsequence> pendingBadConsequence = new ArrayList();
    
    public Player(String name){
        this.name = name;
        level = INITIAL_LEVEL;
        dead = true;
        canISteal = true;
    }
    
    public String getName(){
        return this.name;
    }
    
    private void bringToLife(){
        this.dead = false;
    }
    
    private int getCombatLevel(){
        int total = this.level;
        for(int i = 0; i < this.visibleTreasures.size(); i++){
            total += this.visibleTreasures.get(i).getBonus();
        }
        return total;
    }
    
    public int getLevels(){
        return this.level;
    }
    
    private void incrementLevels(int levels){
        this.level += levels;
    }

    private void decrementLevels(int levels){
        this.level -= levels;
    }
    
    private void setPendingBadconsequence(ArrayList<BadConsequence> bc){
      this.pendingBadConsequence = bc;
    }
    
    private void applyPrize(Monster monster){
        this.level += monster.getPrize().getLevel();
        // TODO Añadir los tesoros ganados
    }
    
    /*
    private void applyBadConsequence(Monster monster){
        // TODO
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        // TODO
    }
    */
    private int howManyVisibleTreasures(TreasureKind tkind){
        int total = this.level;
        for(int i = 0; i < this.visibleTreasures.size(); i++){
            if(this.visibleTreasures.get(i).getType() == tkind)
                total += this.visibleTreasures.get(i).getBonus();
        }
        return total;
    }
    
    private void dieIfNoTreasures(){
        if (this.hiddenTreasures.size() == 0 && this.visibleTreasures.size() == 0) 
            this.dead = true;
    }

    public boolean isDead(){
        return this.dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return this.hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return this.visibleTreasures;
    }

    /* TODO
    public CombatResult combat(Monster monster){
        
        return
    }
    */
    
    public void makeTreasureVisible(Treasure t){
        // TODO
    }
    
    public void discardVisibleTreasure(Treasure t){
        // TODO
    }
    
    public void discardHiddenTreasure(Treasure t){
        // TODO
    }
    
    public boolean validState(){
        if(!this.pendingBadConsequence.isEmpty() && this.hiddenTreasures.size() < 5)
            return true;
        else 
            return false;
    }
    
    public void initTreasures(){
        // TODO
    }
    
    /*
    public Treasure stealTreasure(){
        // TODO
    }
    */
    
    public void setEnemy(Player enemy){
        this.enemy = enemy;
    }
    
    /*
    private giveMeATreasure(){
        // TODO
    }
*/
    
    public boolean canISteal(){
        return this.canISteal;
    }
    
    private boolean canYouGiveMeATreasure(){
        return (this.hiddenTreasures.size() > 0);
    }
    
    
    private void haveStolen(){
        this.canISteal = false;
    }
    
    /*
    public void discardAllTreasures(){
        //TODO
    }
    */
    
}





