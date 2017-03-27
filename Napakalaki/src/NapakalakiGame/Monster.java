package NapakalakiGame;

/**
 *
 * @author Jesús Sánchez de Lechina Tejada & Miguel Ángel Robles Urquiza
 */
public class Monster {
    private String name;
    private int combatLevel;

    private Prize prize;
    private BadConsequence badconsequence;
    
    public Monster(String name, int level, Prize prize, BadConsequence bc){
        this.name = name;
        this.combatLevel = level;
        this.prize = prize;
        this.badconsequence = bc;
    }
    
    public String getString(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public BadConsequence getBadConsequence(){
        return badconsequence;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setCombatLevel(int level){
        this.combatLevel = level;
    }
    
    public void setPrize(Prize prize){
        this.prize = prize;
    }
    
    public void setBadConsequence(BadConsequence bc){
        this.badconsequence = bc;
    }

    @Override
    public String toString(){
        return "Monster: " + name + " \nCombat level: " + Integer.toString(combatLevel) + " \nPrize: " + prize.toString() + "\nBad Consequence: " + badconsequence.toString() + "\n";
    }
}
    
