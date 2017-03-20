
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
    
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.name = name;
        level = INITIAL_LEVEL;
        dead = true;
        canISteal = true;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void bringToLife(){
        this.dead = false;
    }
    
    public int getCombatLevel(){
        return this.level;
    }
    
    public void incrementLevels(int levels){
        this.level += levels;
    }

    public void decrementLevels(int levels){
        this.level -= levels;
    }
    
    public void setPendingBadconsequence(BadConsequence bc){
      this.pendingBadConsequence = bc;
    }
    
    public void applyPrize(Monster monster){
        this.level += monster.getPrize().getLevel();
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        // TODO
    }
    
    public int howManyVisibleTreasures(TreasureKind tkind){
        return this.visibleTreasures.size();
    }
    
    public void dieIfNoTreasures(){
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

}





