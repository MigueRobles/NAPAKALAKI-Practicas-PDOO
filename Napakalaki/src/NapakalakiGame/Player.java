
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
     // TODO   
    }
    
    public void applyPrize(Monster monster){
        // TODO
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        // TODO
    }
    
    public howManyVisibleTreasures(TreasureKind tkind){
        // TODO
    }
    
    public void dieIfNoTreasures(){
        if (this.nTreasures == 0) // TODO meter esta variable de instancia
            this.dead = true;
    }

    public boolean isDead(){
        return this.dead;
    }
    
    public Treasure[] getHiddenTreasures(){
        return this.treasure; // TODO Meter esta variable
    }
    
    public Treasure[] getVisibleTreasures(){
        
    }

}





