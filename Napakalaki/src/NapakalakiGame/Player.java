
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class Player {
    private static final int INITIAL_LEVEL = 1;
    private static final int MAX_LEVEL = 10;


    private final String name;
    private int level;
    private boolean dead = true;
    private boolean canISteal = true;
    private Player enemy;
    private BadConsequence pendingBadConsequence;

    
    private ArrayList<Treasure> hiddenTreasures = new ArrayList();
    private ArrayList<Treasure> visibleTreasures = new ArrayList();
    
    public Player(String name){
        this.name = name;
        level = INITIAL_LEVEL;
        dead = true;
        canISteal = true;
        enemy = null;
        pendingBadConsequence = new BadConsequence(new String(),true);
    }
    
    public String getName(){ return name; }
    
    private void bringToLife(){ dead = false;  }
    
    private int getCombatLevel(){
        int total = this.level;
        for(int i = 0; i < this.visibleTreasures.size(); i++){
            total += this.visibleTreasures.get(i).getBonus();
        }
        return total;
    }
    
    public int getLevels(){ return this.level; }    
    private void incrementLevels(int l){ level += l; }
    private void decrementLevels(int l){ level -= l; }    
    private void setPendingBadconsequence(BadConsequence b){ pendingBadConsequence = b;} 
    
    private void applyPrize(Monster monster){ 
        incrementLevels(monster.getLevelsGained());
        int nTreasures = monster.getTreasuresGained();
        
        if(nTreasures > 0){
         CardDealer dealer = new CardDealer();
         dealer = CardDealer.getInstance();
         int i;
         for(i= 1; i < nTreasures; i++)
         hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    
    
    
    private void applyBadConsequence(Monster monster){
       decrementLevels(monster.getBadConsequence().getLevels());
       
       BadConsequence b = monster.getBadConsequence();
       BadConsequence pendingBad = b.adjustToFitTreasureList(visibleTreasures, hiddenTreasures);       
       setPendingBadconsequence(pendingBad);
      
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
       
        if(t.getType() != TreasureKind.ONEHAND && t.getType() != TreasureKind.BOTHHANDS){
            for (Treasure trea: visibleTreasures)
                if(trea.getType() == t.getType())
                    return false;
            return true;
        }
        else{
            int mano = 0;
            int manos = 0;
            for (Treasure trea: visibleTreasures){
                if(trea.getType() == TreasureKind.ONEHAND)
                  mano++;
                if(trea.getType() == TreasureKind.BOTHHANDS)
                  manos++;
            }
         if(mano == 0 && manos == 0)
             return true;
         
        return mano == 1 && t.getType() == TreasureKind.ONEHAND && manos == 0;
       
        }              
        
    }
    
    private int howManyVisibleTreasures(TreasureKind tkind){
        int total = 0;
        for(int i = 0; i < visibleTreasures.size(); i++){
            if(visibleTreasures.get(i).getType() == tkind)
                total +=  1;
        }
        return total;
    }
    
    private void dieIfNoTreasures(){
        if (hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()) 
            dead = true;
    }

    public boolean isDead(){ return dead; }    
    public ArrayList<Treasure> getHiddenTreasures(){ return hiddenTreasures; }    
    public ArrayList<Treasure> getVisibleTreasures(){ return visibleTreasures; }

    /* TODO
    public CombatResult combat(Monster monster){
        
        return
    }
    */
    /*
    public void makeTreasureVisible(Treasure t){
        // TODO
    }
    */
    /*
    public void discardVisibleTreasure(Treasure t){
        // TODO
    }
    */
    /*
    public void discardHiddenTreasure(Treasure t){
        // TODO
    }
    */
    
    public boolean validState(){ return pendingBadConsequence.isEmpty() && hiddenTreasures.size() < 5; }
    /*
    public void initTreasures(){
        // TODO
    }
    */
    /*
    public Treasure stealTreasure(){
        // TODO
    }
    /¡*/
    
    public void setEnemy(Player enemy){ enemy = enemy; }
    

    private Treasure giveMeATreasure(){
        int i;
        i = (int) (Math.random() * (hiddenTreasures.size()));
        Treasure tr;        
        tr = new Treasure(hiddenTreasures.get(i).getName(),hiddenTreasures.get(i).getBonus(),hiddenTreasures.get(i).getType());
        hiddenTreasures.remove(hiddenTreasures.get(i));  
        
       return tr;
    }

    
    public boolean canISteal(){return canISteal; }    
    private boolean canYouGiveMeATreasure(){ return (hiddenTreasures.size() > 0); }
    
    
    private void haveStolen(){ canISteal = false; }
    
    /*
    public void discardAllTreasures(){
        //TODO
    }
    */
    
}





