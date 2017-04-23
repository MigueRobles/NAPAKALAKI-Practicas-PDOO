package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class Player {
    static final int INITIALLEVEL = 1;
    static final int MAXLEVEL = 10;


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
        level = INITIALLEVEL;
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
         CardDealer dealer = CardDealer.getInstance();
         for(int i = 1; i < nTreasures; i++)
            hiddenTreasures.add(dealer.nextTreasure());
        }
    }
    
    
    
    private void applyBadConsequence(Monster monster){
       decrementLevels(monster.getBadConsequence().getLevels());
       
       BadConsequence b = monster.getBadConsequence();
       
       ArrayList<TreasureKind> v_treasures = new ArrayList();
       ArrayList<TreasureKind> h_treasures = new ArrayList();
       
       for(Treasure t:this.visibleTreasures)
           v_treasures.add(t.getType());
       
       for(Treasure t:this.hiddenTreasures)
           h_treasures.add(t.getType());
       
       
       BadConsequence pendingBad = b.adjustToFitTreasureLists(v_treasures, h_treasures);
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

    
    public CombatResult combat(Monster monster){
        int myLevel = getCombatLevel();
        int monsterLevel = monster.getCombatLevel();
        if(!canISteal){
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber();
            if(number < 3)
                monsterLevel += enemy.getCombatLevel();            
        }
        if(myLevel > monsterLevel){
            applyPrize(monster);
            if(myLevel >= MAXLEVEL)
                return CombatResult.WINGAME;
            return CombatResult.WIN;
        }
        else{
            applyBadConsequence(monster);
            return CombatResult.LOSE;
        }
        
    }
    
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t); 
        if((pendingBadConsequence!=null) && (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractVisibleTreasures(t);
        }
        dieIfNoTreasures();        
    }
    
    
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t); 
        if((pendingBadConsequence!=null) && (!pendingBadConsequence.isEmpty())){
            pendingBadConsequence.substractHiddenTreasures(t);
        }
        dieIfNoTreasures();      
    }
    
    
    public boolean validState(){ return pendingBadConsequence.isEmpty() && hiddenTreasures.size() < 5; }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        if(number > 1){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }
        if(number == 6){
            treasure = dealer.nextTreasure();
            hiddenTreasures.add(treasure);
        }      
                
    }
    
    
    public Treasure stealTreasure(){
        
        if(canISteal()){
            if(this.enemy.canYouGiveMeATreasure()) {
                Treasure treasure = this.enemy.giveMeATreasure();
                this.hiddenTreasures.add(treasure);
                haveStolen();
                return treasure;
            }
        }
        return null;
    }
    
    
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
    
    
    public void discardAllTreasures(){
        ArrayList<Treasure> hcopy = new ArrayList(hiddenTreasures);
        ArrayList<Treasure> vcopy = new ArrayList(visibleTreasures);

        for (Treasure trea: vcopy)
            discardVisibleTreasure(trea);
        for (Treasure trea: hcopy)
            discardHiddenTreasure(trea);
    }
    
    
}





